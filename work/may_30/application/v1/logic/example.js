const {v4: uuidv4} = require('uuid');
const exampleApi = require('../model/api/example-api');

class Example {
    constructor(test_obj = {}) {
        console.log("Constructor ");
        this._id = test_obj.id || uuidv4();
        this._name = test_obj.name || 'default';
        this._example = test_obj.example || true;
        this._api = test_obj.api || new exampleApi(); // this gives us the ability to use object composition and easier unit testing
    }
    // some properties we may not want to changed after construction
    get id() {
        return this._id;
    }
    get name() {
        return this._name;
    }
    get first_name() {
        return this.name.split(' ')[0];
    }
    // some properties we want ensure are the correct type and throw an error if not
    set name(name) {
        if (typeof stringValue !== 'string') {
            throw new Error('Name must be a string');
        }
        this._name = name;
    }
    get example() {
        return this._example;
    }
    // some properties we want to force a type
    set example(example) {
        this._example = Boolean(example);
    }
    // an easy way to get out all the values for easy json stringing
    export() {
        const exported = {};
        for (const key of Object.getOwnPropertyNames(Object.getPrototypeOf(this))) {
            if (typeof this[key] !== 'function') {
                exported[key] = this[key];
            }
        }
        return exported;
    }
    
    merge(updated) {
        const blacklist = ['id'];
        //console.log("Called Merge");
        //console.log(updated);

        for (const property in this) {
            if (updated[property] && !blacklist.includes(property)) {
                this[property] = updated[property];
            } 
        }
    }
    
    async publishExample() {
        const results = await this._api.publish(this.export());
        return results;
    }
    
    async getCats() {
        const cats = await this._api.getCats();
        return cats;
    }


    // easy way to use a factory method to get class objects when all you have is an id
    static async getFromAPI(some_id) {
        const api = new exampleApi();
        const results = await api.getExample(some_id);
        return new Example(results);
    }
}

module.exports = Example;
