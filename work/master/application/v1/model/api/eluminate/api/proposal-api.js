const EluminateClient = require('../eluminate.client');
const mockProposals = require('../../../../../../test/mocks/recommendations.json'); // TODO remove temp data

class ProposalApi {
    constructor(eluminate_client) {
        this._eluminate_client = eluminate_client || new EluminateClient();
        this._url_path = '/1/proposal';
    }

    // TODO temp method to get from mock data
    _findById(id) {
        const data = mockProposals;
        const key = Object.keys(data).find((item) => data[item].recommendation_id === id);
        if (!key) {
            return [];
        }
        return data[key];
    }

    async get() {
        const opts = {
            method: 'GET',
            path: this._url_path
        };

        return await Promise.resolve({data: mockProposals}); // TODO remove mock
        // return await this._eluminate_client.callApi(opts);
    }

    async getProposal(proposalId) {
        const opts = {
            method: 'GET',
            path: `${this._url_path}/${proposalId}`
        };

        return await Promise.resolve({data: this._findById(proposalId)}); // TODO remove mock
        // return await this._eluminate_client.callApi(opts);
    }
}

module.exports = ProposalApi;
