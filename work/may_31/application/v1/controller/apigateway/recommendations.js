const recommendationLogic = require('../../logic/recommendation');
const recommendationFactory = require('../../logic/factories/recommendation');

exports.requirements = {
    get: {
        availableParams: ['grower_id', 'recommendation_id', 'pdf_id']
    },
    post: {
        requiredBody: 'v1-recommendation-request'
    }
};

const _list = async (request, response) => {
    // TODO Validation
    const recommendationList = await recommendationLogic.list();
    // TODO respond 404 on empty array
    response.body = {recommendations: recommendationList};
    return response;
};

const _getRecommendationById = async (request, response) => {
    // TODO Validation
    const recommendation = await recommendationLogic.getById(request.params.recommendation_id);
    // TODO respond 404 on empty array
    response.body = {recommendation: recommendation};
    return response;
};

const _getGamePlanPDF = async (request, response) => {
    // TODO Validation
    const pdf_link = await recommendationLogic.getPDFLink(request.params.recommendation_id);
    // TODO respond 404 on empty array
    response.body = {pdf_link: pdf_link};
    return response;

};

exports.get = async (request, response) => {   
    // TODO valid request? Adjust logic here to handle different types of GET requests?
    if (typeof request.params.pdf_id !== 'undefined' && request.params.pdf_id === 'true') {
        await _getGamePlanPDF(request, response);
    } else {
        if (request.params && request.params.recommendation_id) { 
            await _getRecommendationById(request, response);
        } else {
            await _list(request, response);
        }  
    }
};

exports.post = async (request, response) => {
    response.body = request.body;
    return response;
};




exports.patch = async (request, response) => {
    console.log("___________REQUEST______________");

    input = {recommendation_id: request.body.recommendation_id, status: request.body.status}
    const updated = new recommendationLogic(input);
    const recommendation = await recommendationFactory.getById(request.body.recommendation_id);

    //console.log("_________ORIGINAL_________");
    //console.log(recommendation);

    //console.log("_________UPDATE_________");
    //console.log(updated);

    recommendation.merge(updated);

    //console.log("_________MERGED_________");
    //console.log(recommendation);

    //SUCCESS
    response.body = {recommendation: recommendation};
    
    //ERROR
    /*
    response.code = 409;
    response.setError(
        'data_conflict',
        'There was conflict with your request; the data has not changed. Try again'
    );
    */

    return response;


};



/*

  const recommendation_id = request.body.recommendation_id
    const status = request.body.status
    const updated = {recommendation_id: recommendation_id, status: status }
    response.body = {recommendation: updated};
exports.patch = async (request, response) => {
    console.log("___________REQUEST______________");
    
    //STEP 1: Validate the PATCH Request 


    //STEP 2: Get the data from the PATCH Request
    const recommendation_id = request.body.recommendation_id
    const status = request.body.status

    //STEP 3: Create a Recommendation Object with all the data (The full object with the data to update)
    //input = {recommendation_id: recommendation_id, status: status }
    const updated = {recommendation_id: recommendation_id, status: status }

    input = {recommendation_id: recommendation_id, status: status }
    const newRecommendationObject = new recommendationLogic(updated);



    const recommendationObject = new recommendationLogic(input);
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
    
    
    console.log("_________ORIGINAL_________");
    console.log(recommendationObject);

    console.log("_________NEW_________");
    console.log(newRecommendationObject);

    console.log("_________MERGED_________");
    recommendationObject.merge(newRecommendationObject);
    console.log(recommendationObject);
    
    response.body = {updated_recommendation: recommendationObject};

    return response;

    //const recommendation = await recommendationLogic.getById(request.body.recommendation_id);
    

    /*
     "recommendation_id": "5c32d6be-7c5c-4d16-8999-c62e0b256223",

        "recommendation_pdf": ,         
        "
        "
    */

    //recommendation.merge(updated);
    
    
    //response.body = {recommendation: recommendation};

    //response.status = 200;
    //return response;

    //response.body = input;
    /*
    if (typeof request.params.pdf_id !== 'undefined' && request.params.pdf_id === 'true') {
        await _getGamePlanPDF(request, response);
    } else {
        if (request.params && request.params.recommendation_id) { 
            await _getRecommendationById(request, response);
        } else {
            await _list(request, response);
        }  
    }
    */


    
    //STEP 4: Create the new updated Recommendation Object using a Factory (from the patch request)

    
    //
    //const recommendationObject = new recommendationLogic(input);
    //recommendationObject.getById(recommendation_id);
    //console.log(recommendationObject);
    
    //const recommendationObject = await new recommendationApi().getById(recommendation_id);

    //console.log(recommendationObject);
    //recommendationObject.merge(updated);  
    
    //console.log();

    /*
    exports.getById = async (committed_unit_id, production_plan_id) => {
        const result = await committedUnits.getById(committed_unit_id, production_plan_id);
        return result && result.committed_unit_id ? new CommittedUnit(result) : {};
    };
    */


/////
/*
const {assert} = require('chai');
const RecommendationLogic = require(process.cwd() + '/application/v1/logic/recommendation');
const mockData = require(process.cwd() + '/test/mocks/recommendations.json');

describe('Test Recommendation Object', () => {
    describe('test constructor no data', () => {
        it('should create a rest client', () => {
            const recommendationObject = new RecommendationLogic();
            assert.equal(true, '_rest_client' in recommendationObject);
        });
    });

    describe('list()', () => {
        it('should return list array of recommendations', async () => {
            const recommendationObject = new RecommendationLogic();
            const result = await recommendationObject.list('');

            assert.deepEqual(result.length, mockData.length);
        });
    });

    describe('getById()', () => {
        it('should return a single recommendation', async () => {
            const recommendationObject = new RecommendationLogic();
            const id = mockData[0].recommendation_id;

            const result = await recommendationObject.getById({recommendation_id: id});
            assert.equal(result._recommendation_id, mockData[0].recommendation_id);
        });
    });
});
*//*
//////



    //const pdf_link = await recommendationLogic.getPDFLink(request.params.recommendation_id);
    //console.log("DV: Its ID! " + recommendationObject._recommendation_id)
    //response.body = request.body.status;
    //const newStatus = request.body.postType;
    //const example = new Example();
    //console.log("DV: " + recommendation_id + " " + status);


};

*/
/*
        "recommendation_id": "17caa20c-da85-4257-9216-31cbf9c55e6f",
        "title": "Recommendation Demo 2",
        "status": "ACCEPTED",
        "status": "PLANNED"
}

*/
/*
const {assert} = require('chai');
const RecommendationLogic = require(process.cwd() + '/application/v1/logic/recommendation');
const recommendationApi = require(process.cwd() + '/application/v1/model/api/recommendation-api');
const mockData = require(process.cwd() + '/test/mocks/recommendations.json');

describe('Test Recommendation Object', () => {
    const recommendationObject = new RecommendationLogic();
    const recommendationObjectWithData = new RecommendationLogic(mockData[0]);
    */

/*
exports.patch = async (request, response) => {
    //response.body = request.body.status;
    const newStatus = request.body.postType;
    
    console.log("_________________________");
    console.log(request.body.postFrom);
    return response;
};
*/
/*
merge(updated) {
    const blacklist = ['id'];
    for (const property in this) {
        if (updated[property] && !blacklist.includes(property)) {
            this[property] = updated[property];
        }
    }
}

exports.patch = async (request, response) => {
    if (
        (await validator.scaleTicketExists(request, response)) &&
        (await validator.doesProductionPlanExistById(request, response)) &&
        (await validator.checkForCommittedUnitsIdAndValidate(request, response))
    ) {
        let scale_ticket = await scaleTicketFactory.getById(
            request.params.production_plan_id,
            request.params.scale_ticket_id
        );
        scale_ticket = new ScaleTicketLogic(scale_ticket);
        scale_ticket.merge(request.body);
        try {
            await scale_ticket.update(request.authorizer['x-cognito-username']);
            response.body = scale_ticket.export();
        } catch (error) {
            global.logger.error(error);
            const updatedScaleTicket = await scaleTicketFactory.getById(
                request.params.production_plan_id,
                request.params.scale_ticket_id
            );
            response.code = 409;
            response.body = {
                errors: ['The data has changed; please review changes and try again'],
                current: updatedScaleTicket.export()
            };
        }
    }
    return response;
};

exports.patch = async (request, response) => {
    let production_plan = {};
    if (await validator.productionPlanExists(request, response)) {
        production_plan = await productionPlansFactory.getById(request.params.production_plan_id);
        const _production_plan = new ProductionPlanLogic(production_plan);
        _production_plan.merge(request.body);
        try {
            await _production_plan.update(request.authorizer['x-cognito-username']);
            response.body = _production_plan.export();
        } catch (error) {
            global.logger.error(error);
            const updatedProductionPlan = await productionPlansFactory.getById(request.params.production_plan_id);
            response.code = 409;
            response.body = {
                errors: ['The data has changed; please review changes and try again'],
                current: updatedProductionPlan
            };
        }
    }
    return response;
};

exports.patch = async (request, response) => {
    let committed_unit = {};
    if (
        validator.isValidCommittedUnitPatch(request, response) &&
        (await validator.committedUnitExists(request, response))
    ) {
        committed_unit = await committedUnitsFactory.getById(
            request.params.committed_unit_id,
            request.params.production_plan_id
        );
        committed_unit.merge(request.body);
        try {
            await committed_unit.update(request.authorizer['x-cognito-username']);
            response.body = committed_unit.export();
        } catch (error) {
            global.logger.error(error);
            response.code = 409;
            response.setError(
                'data_conflict',
                'There was conflict with your request; the data has not changed. Try again'
            );
        }
    }
    return response;
};
*/

/*
[PATCH]/recommendations
rec = new Rec()
rec.merge(request.body)
response.body = rec.export()
return response

exports.patch = async (request, response) => {
    response.body = await salesYearFactory.update(request.body.sales_year, request.authorizer['x-cognito-username']);

    return response;
};
*/