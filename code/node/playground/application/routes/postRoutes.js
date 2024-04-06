const express = require('express')
const postRouter = express.Router();
const posts = require('../logic/postLogic')
const authMiddleware = require('../middleware/auth')

//postRouter.get("/posts/group/:group_id", authMiddleware.verifyUser, (req, res) => {

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
postRouter.get("/posts/:post_id", authMiddleware.verifyUser, (req, res) => {
	posts.getSinglePost(req, res);
})


//Function A2: Get All Posts
postRouter.get("/posts/user_name", (req, res) => {
	const userName = req.params.user_name;
	res.json({userName: userName})
})

//FUNCTIONS B: All Routes Related to Post Actions
//Function B1: Create a Post 
postRouter.post('/post', authMiddleware.verifyUser, function(req, res) {
	//const postFrom = req.body.postFrom 
	//const postTo = req.body.postTo 
	//const postCaption = req.body.postCaption 
	console.log(req.body)

	res.json({postCaption: "postCaption"})
})

//Function B2: Update a Post 
postRouter.put("/post", authMiddleware.verifyUser, function(req, res) {
	posts.updateSinglePost(req, res);
})

//Function B3: Delete a Post
postRouter.delete("/posts/:post_id", authMiddleware.verifyUser, function(req, res) {
	posts.deleteSinglePost(req, res);
})

module.exports = postRouter;

    
////

/*


const postFunctions = require('../functions/postFunctions')
const posts = require('../logic/posts')
var jwt = require('jsonwebtoken');
var jwt_decode = require('jwt-decode');
const db = require('../functions/conn');
const middlewares = require('../functions/middlewareFunctions')
*/

/*
//FUNCTIONS A: All Functions Related to Posts
//Route A1: Post Text
postRouter.post('/post/text', function(req, res) {
    posts.postText(req, res);
})


//Route A3: Post Video
postRouter.post('/post/video', function(req, res) {
    posts.postVideo(req, res);
})

//Route A4: Post Article
postRouter.post('/post/article', function(req, res) {
    posts.postArticle(req, res);
})

//FUNCTIONS B: All Functions Related to getting Posts
//Route B1: Get all Group Posts
postRouter.get("/posts/group/:group_id", middlewares.verifyUser, (req, res) => {
    posts.getAllGroupPosts(req, res);
})

//Route B2: Get Group Posts Pagination
postRouter.get("/posts/group/:group_id/:page", middlewares.verifyUser, (req, res) => {
    posts.getGroupPosts(req, res);
})

//Route B2: Get all User Posts 
postRouter.get("/posts/user/:user_name/:page", middlewares.verifyUser, (req, res) => {
    posts.getAllUserPosts(req, res);
})
//Route B3: Get Single Post by ID 
postRouter.get("/posts/:post_id", (req, res) => {
	posts.getSinglePost(req, res);
})

//Route B4: Get All Posts
postRouter.get("/posts", (req, res) => {
	posts.getAllPosts(req, res);
})

//FUNCTIONS C: All Functions Related to Post Actions
//Function C1: Like a Post
postRouter.post('/post/like', function(req, res) {
    posts.likePost(req, res);
})

//Function C2: Unlike a Post 
postRouter.post('/post/unlike', function(req, res) {
	posts.unlikePost(req, res);
})

//Function C3: Select all Likes
postRouter.get("/post/likes", (req, res) => {
	posts.getAllLikes(req, res);
})

//Function C4: Select all Likes for a Post
postRouter.get("/post/likes/:post_id", (req, res) => {
	posts.getPostLikes(req, res);
})

//Function C5: Delete a Post
postRouter.post("/post/delete/", (req, res) => {
	posts.deletePost(req, res);
})

//Function C6: Edit a Text Post 
postRouter.post("/post/caption/edit/", (req, res) => {
	posts.editPost(req, res);
})
*/




















