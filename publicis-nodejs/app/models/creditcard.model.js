var mongoose = require('mongoose');

var CreditCardSchema = mongoose.Schema({
    creditHolder: String,
    creditCardNumber: String,
    creditLimit: Number,
    creditBalance: Number
}, {
    timestamps: true
});

module.exports = mongoose.model('creditcard', CreditCardSchema);