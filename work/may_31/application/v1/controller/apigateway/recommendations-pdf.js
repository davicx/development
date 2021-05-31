const recommendationLogic = require('../../logic/recommendation');

exports.requirements = {
    get: {
        requiredParams: ['recommendation_id']
    }
};


exports.get = async (request, response) => {   
   const recommendation_pdf = await recommendationLogic.getPDFLink(request.params.recommendation_id);
   let output = {recommendation_pdf: "recommendation_pdf"};
   response.body = {recommendation_pdf: "recommendation_pdf"};
   console.log(output)
   return response;
};


/*
exports.get = async (request, response) => {
    const example = new Example();
    response.body = await example.getCats();
    console.log("DV: example.js");
    return response;
};
*/
