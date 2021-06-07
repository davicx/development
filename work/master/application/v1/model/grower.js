const BaseModel = require('./base-model');

class GrowerModel extends BaseModel {
    constructor(grower) {
        super();

        this._id = grower.id || '';
    }
}

module.exports = BaseModel;
