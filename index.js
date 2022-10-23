const express = require('express');
const app = express();
const mongoose = require('mongoose');
const bcrypt = require('bcryptjs');
const jwt = require('jsonwebtoken');

const { User } = require('./model/user');
const auth = require('./middleware/auth');


app.use(express.json());

mongoose
.connect('mongodb+srv://jobchoice:Jobchoice65@jobchoice.4paiwbc.mongodb.net/?retryWrites=true&w=majority',{
    useNewUrlParser: true,
    useUnifiedTopology: true,
})
.then(() => console.log('MongoDB connected'));

app.post('/user/register', async(req,res) =>{
    const newUser = req.body;

    const salt = await bcrypt.genSalt(10);
    newUser.password = await bcrypt.hash(newUser.password, salt);

    let createdUser = await User.create(newUser);
    if(!createdUser) return  res.status(500).send('Cannot create user');

    const token = jwt.sign(
        {
            createdUer: createdUser._id,
            code: createdUser.code,
            email: createdUser.email,
            firstname: createdUser.firstname,
            lastname: createdUser.lastname
            
        },
        'eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IjEyMzQiLCJmaXJzdG5hbWUiOiJNYWtrcmFwb25nIiwibGFzdG5hbWUiOiJTb21ib29uIiwiY29udHJhY3QiOiIwOTU5MjY5OTg2IiwiYWxnIjoiSFMyNTYifQ',
    );

    res.send({
        message: 'Create user successfully',
        user: createdUser,
        token: token,
    });
});

app.post('/user/login', async(req,res) =>{

    console.log(req.body)
    let user = await User.findOne({email: req.body.email});

    if (!user) return res.send('User not found.',404);

    const validPassword = await bcrypt.compare(req.body.password, user.password);
    if (!validPassword) return res.status(400).send('Invalid email or password.');

    delete user.password;

    const token = jwt.sign(
        {
            _id: user._id,
            code: user.code,
            firstName: user.firstname,
            lastName: user.lastname,
            email: user.email
        },
        'eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IjEyMzQiLCJmaXJzdG5hbWUiOiJNYWtrcmFwb25nIiwibGFzdG5hbWUiOiJTb21ib29uIiwiY29udHJhY3QiOiIwOTU5MjY5OTg2IiwiYWxnIjoiSFMyNTYifQ',
    );

    res.send({
        message: 'Logged In',
        user: user,
        token: token,
    });
    
});

app.get('/protected',auth, (req, res) => {
    res.send('access Success');
});

const server = app.listen(process.env.PORT || 5000, function(){
    console.log("Express server listening on port %d in %s mode", this.address().port, app.settings.env);
});

module.express = server;