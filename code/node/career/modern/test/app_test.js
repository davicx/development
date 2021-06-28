const mocha = require('mocha');
let chai = require('chai');
let chaiHttp = require('chai-http');
let should = require('chai').should();
chai.use(chaiHttp);
chai.should();
const assert = require('assert');
let app = require('./../app');


//TEST 1: Test our the GET route to Fetch all Programs (Route 1)
describe('GET /api/programs', () => {
    it('It should GET all the Programs', (done) => {
      chai.request(app)
          .get('/api/programs')
          .end((err, res) => {
              console.log(res.status);
                res.status.should.be.equal(200);
                res.body.should.be.a('array');
                res.body.length.should.be.eq(2);
            done();
          });
    });
});

//TEST 2: Test our the GET route to Fetch all Individual Program (Route 2)
describe('GET /api/program/1', () => {
  it('It should GET all the Programs', (done) => {
    chai.request(app)
        .get('/api/program/1')
        .end((err, res) => {
            console.log(res.status);
              res.status.should.be.equal(200);
          done();
        });
  });
});

//TEST 3: Test our the GET route to Fetch a Section based on its Program and Section ID (Route 3)
describe('GET /api/program/1/section/2', () => {
  it('It should GET all the Programs', (done) => {
    chai.request(app)
        .get('/api/program/1')
        .end((err, res) => {
            console.log(res.status);
              res.status.should.be.equal(200);
          done();
        });
  });
});
