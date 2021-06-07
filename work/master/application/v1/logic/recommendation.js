const ProposalApi = require('../model/api/eluminate/api/proposal-api');
const RecommendationModel = require('../model/recommendation');

class RecommendationLogic {
    constructor(rest_client) {
        this._rest_client = rest_client || new ProposalApi();
        this._url = '/1/proposal';
    }

    async list(params) {
        const grower_id = ''; // TODO remove mock data and destructure params
        try {
            const response = await this._rest_client.get(grower_id);

            const testout = response.data.map((x) => new RecommendationModel(x).export());

            return testout;
        } catch (error) {
            global.logger.warn('Proposal API error list', error);
        }
    }

    async getById(params) {
        const {recommendation_id} = params;
        try {
            const response = await this._rest_client.getProposal(recommendation_id);

            const testoutput = new RecommendationModel(response.data).export();

            return testoutput;
        } catch (error) {
            global.logger.warn('Proposal API error getById', error);
        }
        return response;
    }
}

module.exports = RecommendationLogic;
