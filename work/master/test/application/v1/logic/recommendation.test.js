const {assert} = require('chai');
const RecommendationLogic = require(process.cwd() + '/application/v1/logic/recommendation');
const mockData = require(process.cwd() + '/test/mocks/recommendations.json');

describe('Test Recommendation Object', () => {
    describe('test constructor no data', () => {
        it('should create a rest client', () => {
            const recommendationObject = new RecommendationLogic();
            assert.equal(true, '_rest_client' in recommendationObject);
        });
    });

    describe('list()', () => {
        it('should return list array of recommendations', async () => {
            const recommendationObject = new RecommendationLogic();
            const result = await recommendationObject.list('');

            assert.deepEqual(result.length, mockData.length);
        });
    });

    describe('getById()', () => {
        it('should return a single recommendation', async () => {
            const recommendationObject = new RecommendationLogic();
            const id = mockData[0].recommendation_id;

            const result = await recommendationObject.getById({recommendation_id: id});
            assert.equal(result._recommendation_id, mockData[0].recommendation_id);
        });
    });
});
