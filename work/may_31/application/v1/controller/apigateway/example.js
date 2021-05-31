const Example = require('../../logic/example');

exports.requirements = {
    get: {
        availableParams: ['example_id']
    },
    post: {
        requiredBody: 'v1-example-request'
    }
};

exports.get = async (request, response) => {
    const example = new Example();
    response.body = await example.getCats();
    console.log("DV: example.js");
    return response;
};

exports.post = async (request, response) => {
    response.body = request.body;
    return response;
};


exports.patch = async (request, response) => {
    //response.body = request.body.status;
    const newStatus = request.body.postType;
    const example = new Example();
    example.merge(request.body);   
    console.log("_________________________");
    console.log(request.body.postFrom);
    return response;
};
