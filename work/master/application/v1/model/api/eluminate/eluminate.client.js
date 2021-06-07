const Logger = require('@syngenta-digital/alc/src/common/logger');
const axios = require('axios');
// const http = require('http');
const oauthClient = require('client-oauth2');

class EluminateClient {
    constructor() {
        this._auth = new oauthClient({
            clientId: process.env.ELUMINATE_CLIENT_ID,
            clientSecret: process.env.ELUMINATE_CLIENT_SECRET,
            authorizationGrants: ['credentials'],
            accessTokenUri: process.env.ELUMINATE_AUTH_URL + '/connect/token',
            scopes: 'eluminate-core supplyplan proposals gameplan harvestpriority seed-service syngenta-users'
        });

        this._client = axios.create({
            baseURL: process.env.ELUMINATE_API_URL + '/api',
            timeout: 30000
            // httpAgent: new http.Agent({keepAlive: true})
        });
    }

    async _setAccessToken() {
        if (!this._auth.accessToken) {
            try {
                const response = await this._auth.credentials.getToken();
                this._client.defaults.headers.common['Authorization'] = 'Bearer ' + response.accessToken;
            } catch (err) {
                global.logger.warn('Failed to get Token', err);
            }
        }
    }

    async callApi(opts) {
        await this._setAccessToken();

        return await this._client.request({method: opts.method, url: opts.path});
    }
}

module.exports = EluminateClient;
