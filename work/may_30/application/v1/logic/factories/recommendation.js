const recommendationUnits = require('../../model/recommendation');
const hardcodedMockData = require('../../../../test/mocks/recommendations.json');

exports.getById = async (recommendation_id) => {
    const data = hardcodedMockData;
    const key = Object.keys(data).find((item) => data[item].recommendation_id === recommendation_id);
    if (!key) {
        console.log("empty");
    }
    console.log("DATA!!")
    console.log(data[key]);


    console.log("Factory! " + recommendation_id);
    return data[key]
    /*
    const recommendationObject = new recommendationUnits(recommendation_id);
    recommendationObject.title = "Recommendation Demo 1";
    recommendationObject.status = "PLANNED";
    recommendationObject.is_accepted = "false";
    recommendationObject.total_amount = 300;
    recommendationObject.enrolled_fields_quantity = 2;
    recommendationObject.enrolled_fields_quantity = 2;
    recommendationObject.enrolled_fields_total = 3;
    recommendationObject.enrolled_acres_quantity = 700;
    recommendationObject.recommendation_pdf = "http://www.africau.edu/images/default/sample.pd";
    recommendationObject.fields = ["field1","field2","field3"];
    */

   

};

