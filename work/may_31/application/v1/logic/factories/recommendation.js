const recommendationUnits = require('../../model/recommendation');
const hardcodedMockData = require('../../../../test/mocks/recommendations.json');

exports.getById = async (recommendation_id) => {
    const data = hardcodedMockData;

    for (let i=0; i < data.length; i++){        
        if(data[i].recommendation_id == recommendation_id) {            
            
            input = {
                _recommendation_id: data[i].recommendation_id, 
                _title: data[i].title, 
                _status: data[i].status,
                _is_accepted: data[i].is_accepted, 
                _plan_type: data[i].plan_type, 
                _seller_id: data[i].seller_id, 
                _seller_name: data[i].seller_name, 
                _seller_phone_number: data[i].seller_phone_number, 
                _seller_email: data[i].seller_email, 
                _total_amount: data[i].total_amount, 
                _enrolled_fields_quantity: data[i].enrolled_fields_quantity, 
                _enrolled_fields_total: data[i].enrolled_fields_total, 
                _enrolled_acres_quantity: data[i].enrolled_acres_quantity, 
                _enrolled_acres_total: data[i].enrolled_acres_total, 
                _recommendation_pdf: data[i].recommendation_pdf, 
                _seller_id: data[i].seller_id, 
                _fields: data[i].fields,
                _products: data[i].products
            }

            let recommendation = new recommendationUnits(input);
            return recommendation;
        } 
    }
};