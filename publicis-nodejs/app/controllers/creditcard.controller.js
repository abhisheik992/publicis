var Card = require('../models/creditcard.model.js');

exports.create = async function (req, res) {
    // Create and Save a new Card
    if (!req.body) {
        res.status(400).send({ message: "Details can not be empty", status: 400 });
    }

    if (!req.body.creditHolder || !req.body.creditCardNumber || !req.body.creditLimit) {
        res.status(400).send({ message: "Details can not be empty", status: 400 });
    }

    let cardNumber = req.body.creditCardNumber;
    if (cardNumber.length > 20) {
        res.status(422).send({ message: "Card Number Not Valid", status: 422 });
    }
    console.log("Here");
    if (validateCardNUmber(cardNumber)) {

        var card = new Card({
            creditHolder: req.body.creditHolder,
            creditCardNumber: req.body.creditCardNumber,
            creditLimit: req.body.creditLimit,
            creditBalance: req.body.creditLimit,
        });

       await card.save(function (err, data) {
            if (err) {
                console.log(err);
                res.status(500).send({ message: "Some error occurred while creating the Card." });
            } else {
                res.send({ data: data, status: 201, message: "created" });
            }
        });
    } else {
        res.status(422).send({ message: "Card Number Validation failed", status: 422 });
    }

};

validateCardNUmber = (card) => {
    console.log(card);
    let sum = 0;
    try {
        //let card number = 79927398713
        let length = card.length; //length 11
        for (let i = length; i > 0; i--) {
            let digit = Number(card.substring(i - 1, i));
            if ((card.length - (i - 1)) % 2 == 0) {
                digit = doubleAndSumDigits(digit);
            }
            sum = sum + digit;
        }

        return sum % 10 == 0;
    } catch (err) {
        console.log(err);
        throw Error('VAlidation of Card Number Failed ');
    }
    return false;
}

doubleAndSumDigits = (digit) => {
    let ret = digit * 2;
    if (ret > 9) {
        ret = ret - 9;
    }
    return ret;
}

exports.findAll = function (req, res) {
    // Retrieve and return all cards from the database.
    Card.find(function (err, data) {
        if (err) {
            res.status(500).send({ message: "Some error occurred while retrieving notes." });
        } else {
            res.send({ data: data, status: 200, message: "Successfully fetched data" });
        }
    });
};

module.exports = {
    validateCardNUmber,
    doubleAndSumDigits
}