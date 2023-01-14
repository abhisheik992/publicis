const { validateCardNUmber, doubleAndSumDigits } = require('../controllers/creditcard.controller.js')
const app = require('../../');
const request = require('supertest')

// const jest = require('jest')

describe("Credit Card Tests", () => {
    beforeEach(() => {
        jest.setTimeout(999999);
        jest.useFakeTimers('legacy')
      });

    test('Validating Credit Card Number', async () => {
        expect(validateCardNUmber(79927398713)).toStrictEqual(true);
        expect(doubleAndSumDigits(8)).toStrictEqual(7);
    })

    test('should create a new credit card', async () => {
        const res = await request(app).post('/cards').send({
                creditHolder: "Dimbu",
                creditCardNumber: "79927398712",
                creditLimit: 2000.0
            }, 100000)
        expect(res.status).toEqual(201);
    });

    test('should fetch all cards', async () => {
        const res = await request(app).get(`/cards`);
        expect(res.status).toEqual(200);
      });
})