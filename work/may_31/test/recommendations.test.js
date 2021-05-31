const mocha = require('mocha');
const {assert} = require('chai');
let recommendations = require('./../application/v1/controller/apigateway/recommendations');
let chai = require('chai');
let chaiHttp = require('chai-http');
let should = require('chai').should();
chai.use(chaiHttp);
chai.should();


describe('Test Example', () => {
    describe('example', () => {
        it('true is true', async () => {
            assert.equal(1, 1);
        });
    });
});


/*
//TEST 1: Test our the GET route to Fetch all Programs (Route 1)


*/