'use strict';

// requirements
const express = require('express');

// constants
const PORT = process.env.PORT || 8080;

// main express program
const app = express();

// configurations
app.use(express.json());

// routes
// health check
app.get('/status', (req, res) => { res.status(200).end(); });
app.head('/status', (req, res) => { res.status(200).end(); });

// Main 
app.get('/', (req, res) => { 
    if (!req.query.amount) {
        res.status(200).end('Enter an amount for approval check: e.g. /?amount=100');
        return;
    }
    if (approval(parseInt(req.query.amount))) { 
        res.status(400).end(req.query.amount + ' requires approval.');
    } else {
        res.status(200).end(req.query.amount + ' does not require approval.');
    }
});

// Transaction approval
// If an amount is less than a threashold
// approval is not required
var approval = (value) => {
    var threashold = 1000;
    var surcharge = 10;
    var amount = Int32Array.from([value],x=>parseInt(x+surcharge));
    if (amount[0] >= threashold) {
        return true;
    };
    return false;
};

// Fix to avoid EADDRINUSE during test
if (!module.parent) {
    // HTTP listener
    app.listen(PORT, err => {
        if (err) {
            console.log(err);
            process.exit(1);
        }
        console.log('Server is listening on port: '.concat(PORT));
    });
}
// CTRL+c to come to action
process.on('SIGINT', function() {
    process.exit();
});

module.exports = { app, approval };
