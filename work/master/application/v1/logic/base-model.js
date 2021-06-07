class BaseModel {
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
        for (const property in this) {
            if (updated[property] && !this._blacklist.includes(property)) {
                this[property] = updated[property];
            }
        }

        return this.export();
    }
}

module.exports = BaseModel;
