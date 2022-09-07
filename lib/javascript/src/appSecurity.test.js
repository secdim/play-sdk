const request = require('supertest');
const { app, approval } = require('./app');

describe('security', () => {
    
    it('Request to -500, should throw RangeError exception', async () => {
        expect.assertions(1);
        try {
            approval(-500)
        } catch (ex) {
            expect(ex).toBeInstanceOf(RangeError);
        }
    });

    it('Int32bit maximum amount, should throw RangeError exception', async () => {

        expect.assertions(1);
        try {
            approval(2147483648)
        } catch (ex) {
            expect(ex).toBeInstanceOf(RangeError);
        }
    });

    it('Arithmetic result into Int32bit max value, should throw RangeError exception', async () => {

        expect.assertions(1);
        try {
            approval(2147483647 - 10 + 1)
        } catch (ex) {
            expect(ex).toBeInstanceOf(RangeError);
        }
    });


    it('Arithmetic result into Int32bit max value, should throw RangeError exception', async () => {
        expect.assertions(1);
        try {
            approval(-2147483648 - 10 - 1)
        } catch (ex) {
            expect(ex).toBeInstanceOf(RangeError);
        }
    });
});
