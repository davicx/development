const {assert} = require('chai');
const BaseModel = require(process.cwd() + '/application/v1/model/base-model');

class testClass extends BaseModel {
    constructor() {
        super();
        this._test = 'test';
    }
}

describe('Test BaseModel Object', () => {
    const baseModelObject = new BaseModel();

    describe('instantiate', () => {
        it('object is not undefined', () => {
            assert.equal(true, baseModelObject !== undefined);
        });
    });

    describe('blacklist', () => {
        const testObject = new testClass();
        testObject.blacklist = ['id', 'name'];

        it('set accept an array as param', () => {
            assert.deepEqual(testObject._blacklist, ['id', 'name']);
        });

        it('get should return _blacklist', () => {
            assert.deepEqual(testObject.blacklist, ['id', 'name']);
        });
    });

    describe('test export()', () => {
        const testObject = new testClass();
        const result = testObject.export();

        it('exports properties to ', () => {
            assert.deepEqual(result, {_test: 'test'});
        });
    });

    describe('test merge()', () => {
        const testObject = new testClass();
        const result = testObject.merge({_test: 'merged'});

        it('exports properties to ', () => {
            assert.deepEqual(result, {_test: 'merged'});
        });
    });
});
