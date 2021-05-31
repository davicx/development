const axios = require('axios');

class ExampleApi {
    constructor(rest_client) {
        this._rest_client = rest_client || axios; // this gives us the ability to use object composition and easier unit testing
        this._url = 'https://www.boredapi.com/api/activity';
        console.log("DV: ExampleApi ");
    }
    
    //Why are there two GET methods and where are these called 
    async getCats() {
        try {
            const response = await this._rest_client({method: 'GET', url: this._url});
            console.log("DV: getCats()");
            return response.data;
        } catch (error) {
            global.logger.warn('axios error', error);
        }
        return {};
    }
    async getExample() {
        try {
            const response = await this._rest_client({method: 'GET', url: this._url});
            console.log("DV: getExample()");
            return response.data;
        } catch (error) {
            global.logger.warn('axios error', error);
        }
        return {};
    }
    async publishExample(data) {
        try {
            const response = await this._rest_client({method: 'POST', url: this._url, data});
            console.log("DV: publishExample()");
            return response.data;
        } catch (error) {
            global.logger.warn('axios error', error);
        }
        return {};
    }
}

module.exports = ExampleApi;
