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
	
	var postOutcome = {
		data: {
			postID: postID
		},
		message: "Here is your post!", 
		success: true,
		statusCode: 200,
		errors: [], 
		currentUser: "davey"
	}

    res.json(postOutcome)

}

//FUNCTIONS B: All Routes Related to Post Actions
//Function B1: Create a Post 
//Function B2: Update a Post 

//Function B3: Delete a Post
async function deleteSinglePost(req, res) {
	const postID = req.params_post_id;
	
	var postOutcome = {
		data: {
			postID: postID
		},
		message: "Post was deleted", 
		success: true,
		statusCode: 200,
		errors: [], 
		currentUser: "davey"
	}

    res.json(postOutcome)

}

module.exports = {  getSinglePost, deleteSinglePost };
