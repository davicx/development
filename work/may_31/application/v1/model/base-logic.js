class BaseLogic {
    constructor() {
        this._blacklist = [];
    }

    get blacklist() {
        return this._blacklist;
    }

    set blacklist(val) {
        this._blacklist = val;
    }

    export() {
        const exported = {};
        for (const key of Object.getOwnPropertyNames(this)) {
            if (typeof this[key] !== 'function' && !key.includes('blacklist')) {
                exported[key] = this[key];
            }
        }
        return exported;
    }
    
    merge(updated) {
        const blacklist = ['recommendation_id'];
        for (const property in this) {
            if (updated[property] && !blacklist.includes(property)) {
                this[property] = updated[property];
            } 
        }
        return this.export();
    }
}

module.exports = BaseLogic;
