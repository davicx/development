const {v4: uuidv4} = require('uuid');
const recommendationApi = require('./api/recommendation-api');
const hardcodedMockData = require('./api/mock-recommendations.json');
const BaseLogic = require('./base-logic');

class Recommendation extends BaseLogic {
    constructor(input = {}) {
        super();

        this._recommendation_id = input.recommendation_id || uuidv4();
        this._title = input.title || 'default';
        this._status = input.status || '';
        this._is_accepted = input._is_accepted || false;
        this._plan_type = input._plan_type || 'PLANNED';
        this._seller_id = input._seller_id || '';
        this._seller_phone_number = input._seller_phone_number || '';
        this._seller_email = input._seller_email || '';
        this._total_amount = input._total_amount || 0;
        this._enrolled_fields_quantity = input._enrolled_fields_quantity || 0;
        this._enrolled_fields_total = input._enrolled_fields_total || 0;
        this._enrolled_acres_quantity = input._enrolled_acres_quantity || 0;
        this.game_plan_pdf = input.game_plan_pdf || '';
        this._fields = input._fields || [];
        this._products = input._products || [];

        this._api = input.api || new recommendationApi();
        this.blacklist = ['recommendation_id'];
    }

    get recommendation_id() {
        return this._recommendation_id;
    }

    get title() {
        return this._title;
    }

    set title(val) {
        this._title = val;
    }

    get status() {
        return this._status;
    }

    set status(val) {
        this._status = val;
    }

    get is_accepted() {
        return this._is_accepted;
    }

    set is_accepted(val) {
        this._is_accepted = val;
    }

    get plan_type() {
        return this._plan_type;
    }

    set plan_type(val) {
        this._plan_type = val;
    }

    get seller_id() {
        return this._seller_id;
    }

    set seller_id(val) {
        this._seller_id = val;
    }

    get seller_phone_number() {
        return this._seller_phone_number;
    }

    set seller_phone_number(val) {
        this._seller_phone_number = val;
    }

    get seller_phone_email() {
        return this._seller_phone_email;
    }

    set seller_phone_email(val) {
        this._seller_phone_email = val;
    }

    get total_amount() {
        return this._total_amount;
    }

    set total_amount(val) {
        this._total_amount = val;
    }

    get enrolled_fields_quantity() {
        return this._enrolled_fields_quantity;
    }

    set enrolled_fields_quantity(val) {
        this._enrolled_fields_quantity = val;
    }

    get enrolled_fields_total() {
        return this._enrolled_fields_total;
    }

    set enrolled_fields_total(val) {
        this._enrolled_fields_total = val;
    }

    get enrolled_acres_quantity() {
        return this._enrolled_acres_quantity;
    }

    set enrolled_acres_quantity(val) {
        this._enrolled_acres_quantity = val;
    }

    get game_plan_pdf() {
        return this._game_plan_pdf;
    }

    set game_plan_pdf(val) {
        this._game_plan_pdf = val;
    }

    get enrolled_acres_total() {
        return this._enrolled_acres_total;
    }

    set enrolled_acres_total(val) {
        this._enrolled_acres_total = val;
    }

    get fields() {
        return this._fields;
    }

    set fields(val) {
        this._fields = val;
    }

    get products() {
        return this._products;
    }

    set products(val) {
        this._products = products;
    }

    static async list() {
        const results = await new recommendationApi().list();

        if (!results || results.length <= 0) {
            return [];
        }

        return results.map((x) => new Recommendation(x).export());
    }

    static async getById(recommendation_id) {
        const results = await new recommendationApi().getById(recommendation_id);

        if (!results || results.length <= 0) {
            return [];
        }

        return new Recommendation(results).export();
    }
    
 

}

module.exports = Recommendation;



/*

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
*/