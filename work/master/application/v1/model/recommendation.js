const {v4: uuidv4} = require('uuid');
const BaseModel = require('./base-model');

class RecommendationModel extends BaseModel {
    constructor(input) {
        super();

        this._recommendation_id = input.recommendation_id || v4();
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
        this._pdf_link = input._pdf_link || '';
        this._fields = input._fields || [];
        this._products = input._products || [];

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

    get enrolled_acres_total() {
        return this._enrolled_acres_total;
    }

    set enrolled_acres_total(val) {
        this._enrolled_acres_total = val;
    }

    get pdf_link() {
        return this._pdf_link;
    }

    set pdf_link(val) {
        this._pdf_link = val;
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
}

module.exports = RecommendationModel;
