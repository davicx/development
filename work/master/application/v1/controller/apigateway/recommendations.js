const RecommendationLogic = require('../../logic/recommendation');

exports.requirements = {
    get: {
        availableParams: ['grower_id', 'recommendation_id']
    },
    post: {
        requiredBody: 'v1-recommendation-request'
    }
};

exports.get = async (request, response) => {
    if (request.params && request.params.recommendation_id) {
        const recommendation = await new RecommendationLogic().getById(request.params);
        // TODO respond 404 on empty array
        response.body = {recommendation: recommendation};
        return response;
    } else {
        const recommendationList = await new RecommendationLogic().list(request.params);
        // TODO respond 404 on empty array
        response.body = {recommendations: recommendationList};
        return response;
    }
};

exports.post = async (request, response) => {
    response.body = request.body;
    return response;
};
