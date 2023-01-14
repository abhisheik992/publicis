module.exports = function (app) {

    var cards = require('../controllers/creditcard.controller.js');

    // Create a new card
    app.post('/cards', function (req, res) { cards.create });

    // Retrieve all cards
    app.get('/cards', function (req, res) { cards.findAll });

}