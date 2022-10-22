const jwt = require('jsonwebtoken');

module.exports = (req, res, next) => {
    const token = req.header('x-auth-token');

    try {
        const decoded = jwt.verify(
            token,
            'eyJ1c2VybmFtZSI6InRlc3QiLCJwYXNzd29yZCI6IjEyMzQiLCJmaXJzdG5hbWUiOiJNYWtrcmFwb25nIiwibGFzdG5hbWUiOiJTb21ib29uIiwiY29udHJhY3QiOiIwOTU5MjY5OTg2IiwiYWxnIjoiSFMyNTYifQ', 
            {
                ignoreExpiration: true,
            }
        );

        req.user = decoded;
        next();
    }   catch(ex) {
        res.status(400).send('Invalid token');
    }
};