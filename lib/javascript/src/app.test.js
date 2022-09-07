const request = require('supertest');
const { app, approval } = require('./app');

describe('usability', () => {

    it('Requst for 500, should return 200', async () => {
        const res = await request(app)
            .get('/')
            .query({amount: 500});
        expect(res.statusCode).toEqual(200);
        expect(res.text).toContain('500 does not require approval.');
    });

    it('Requst for 1001, should return 400', async () => {
        const res = await request(app)
            .get('/')
            .query({amount: 1001});
        expect(res.statusCode).toEqual(400);
        expect(res.text).toContain('1001 requires approval.');
    });

    it('when request /status, should return 200', async () => {
        const res = await request(app)
            .get('/status');
        expect(res.statusCode).toEqual(200);
    });


});
