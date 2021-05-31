const axios = require('axios');
const hardcodedMockData = require('./mock-recommendations.json');

class RecommendationApi {
    constructor(rest_client) {
        this._rest_client = rest_client || axios;
        this._url = 'https://www.boredapi.com/api/activity';
    }

    // TODO temp method to get from mock data
    _findById(recommendation_id) {
        const data = hardcodedMockData;
        const key = Object.keys(data).find((item) => data[item].recommendation_id === recommendation_id);
        if (!key) {
            return [];
        }
        return data[key];
    }

    async list() {
        try {
            const response = await this._rest_client({method: 'GET', url: this._url});
            response.data = hardcodedMockData; // TODO remove mock data
            return response.data;
        } catch (error) {
            global.logger.warn('axios error', error);
        }
        return response;
    }

    async getById(recommendation_id) {
        try {
            const response = await this._rest_client({method: 'GET', url: this._url});
            response.data = this._findById(recommendation_id); // TODO remove mock data

            return response.data;
        } catch (error) {
            global.logger.warn('axios error', error);
        }
        return response;
    }
}

module.exports = RecommendationApi;
