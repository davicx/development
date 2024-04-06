//const db = require('../functions/conn');

/*
FUNCTIONS A: All Routes Related to Getting Posts
	1) Function A1: Get Single Post
	2) Function A2: Get All Posts

FUNCTIONS B: All Routes Related to Post Actions
	1) Function B1: Create a Post 
	2) Function B2: Update a Post 
	3) Function B3: Delete a Post
*/

//FUNCTIONS A: All Routes Related to Getting Posts
//Function A1: Get Single Post
async function getSinglePost(req, res) {
	const postID = req.params.post_id;

	try {
        dosomething();
    }
    catch (e) {
        console.log(e);
    }

	var postOutcome = {
		data: {
			postID: postID
		},
		message: "", 
		success: true,
		statusCode: 200,
		errors: [], 
		currentUser: "davey"
	}

    res.json(postOutcome)

}

function dosomething() {
    throw new Error('a error is thrown from dosomething');
}
 

module.exports = {  getSinglePost  };
