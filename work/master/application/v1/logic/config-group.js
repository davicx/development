//const RecommendationModel = require('../model/recommendation');
//const RecommendationLogic = require('../../logic/recommendation');

const BaseModel = require('./base-model');

class ConfigurationGroup extends BaseModel {
    constructor(input) {
        super();

        this._config_region = input.config_region || '';
        this._config_group = input.config_group || Array();

        this.blacklist = ['config_region'];

    }

    get config_region() {
        return this._config_region;
    }

    get config_group () {
        return this._config_group;
    }

    set config_group(val) {
        this._config_group = val;
    }

}

module.exports = ConfigurationGroup;
