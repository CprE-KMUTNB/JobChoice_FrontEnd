const mongoose = require('mongoose')

const userSchema = new mongoose.Schema({
    email: String,
    password: String,
    firstname: String,
    lastname: String,
    contact: String,
});

const User = mongoose.model('email', userSchema)

exports.User = User;