const db = require('./../functions/conn');



class Post {
    constructor(postID) {
        this.postID = postID;
        this.postFrom = "";
        this.postTo = "";
        this.postCaption = "";
    }
    
    //METHODS A: POST RELATED
    //Method A1: Make a Text Post
    static async createPostText(req)  {
        const connection = db.getConnection(); 
        const masterSite = req.body.masterSite 
        const postType = req.body.postType 
        const postFrom = req.body.postFrom 
        const postTo = req.body.postTo 
        const groupID = req.body.groupID 
        const postCaption = req.body.postCaption 
        console.log("Step 1A: Create a new post from Post Class");  
     
        var postOutcome = {
            outcome: 0,
            postID: 0,
            errors: []
        }

        //INSERT POST
        return new Promise(async function(resolve, reject) {
            try {
                const queryString = "INSERT INTO posts (master_site, post_type, group_id, post_from, post_to, post_caption) VALUES (?, ?, ?, ?, ?, ?)"
    
                connection.query(queryString, [masterSite, postType, groupID, postFrom, postTo, postCaption], (err, results, fields) => {
                    if (!err) {
                        console.log("Step 1B: You created a new Post with ID " + results.insertId);    
                        postOutcome.outcome = 200;       
                        postOutcome.postID = results.insertId;       
                    } else {    
                        postOutcome.outcome = "no worky"
                        postOutcome.errors.push(err);
                    } 
                    resolve(postOutcome);
                }) 
                
            } catch(err) {
                postOutcome.outcome = "rejected";
                console.log("Post Class: error in promise " + err);
                reject(postOutcome);
            } 
        });
    }

    //Method A2: Make a Photo Post
    static async createPostPhoto(req, file)  {
        const connection = db.getConnection(); 
        const masterSite = req.body.masterSite 
        const postType = req.body.postType 
        const postFrom = req.body.postFrom 
        const postTo = req.body.postTo 
        const groupID = req.body.groupID 
        const postCaption = req.body.postCaption 
        const fileName = file.originalname
        const fileNameServer = file.filename
        let fileURL = ""
        if(file.destination) {
            fileURL = file.destination
        } else {
            fileURL = file.location
        }

        var postOutcome = {
            outcome: 0,
            postID: 0,
            errors: []
        }

        //INSERT POST
        return new Promise(async function(resolve, reject) {
            try {
                const queryString = "INSERT INTO posts (master_site, post_type, group_id, post_from, post_to, post_caption) VALUES (?, ?, ?, ?, ?, ?)"
    
                connection.query(queryString, [masterSite, postType, groupID, postFrom, postTo, postCaption], (err, results, fields) => {
                    if (!err) {
                        console.log("You created a new Post with ID " + results.insertId);    
                        postOutcome.outcome = 200;       
                        postOutcome.postID = results.insertId;       
                    } else {    
                        postOutcome.outcome = "no worky"
                        postOutcome.errors.push(err);
                    } 
                    resolve(postOutcome);
                }) 
                
            } catch(err) {
                postOutcome.outcome = "rejected";
                console.log("REJECTED " + err);
                reject(postOutcome);
            } 
        });
    }

    //Method A3: Make a Video Post
    static async createPostVideo(req)  {
        const connection = db.getConnection(); 
        const masterSite = req.body.masterSite 
        const postType = req.body.postType 
        const postFrom = req.body.postFrom 
        const postTo = req.body.postTo 
        const groupID = req.body.groupID 
        const postCaption = req.body.postCaption 
        const videoURL = req.body.videoURL 
        const videoCode = req.body.videoCode 

        var postOutcome = {
            outcome: 500,
            postID: 0,
            errors: []
        }
        
        //INSERT POST
        return new Promise(async function(resolve, reject) {
            try {
                const queryString = "INSERT INTO posts (master_site, post_type, group_id, post_from, post_to, post_caption, video_url, video_code) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
    
                connection.query(queryString, [masterSite, postType, groupID, postFrom, postTo, postCaption, videoURL, videoCode], (err, results, fields) => {
                    if (!err) {
                        console.log("Post.js: You created a new Post with ID " + results.insertId);    
                        //console.log(results)
                        postOutcome.outcome = 200;       
                        postOutcome.postID = results.insertId;       
                    } else {    
                        postOutcome.outcome = "no worky"
                        postOutcome.errors.push(err);
                    } 
                    resolve(postOutcome);
                }) 
                
            } catch(err) {
                postOutcome.outcome = "rejected";
                console.log("REJECTED " + err);
                reject(postOutcome);
            } 
        });
        
    }

    //METHODS B: UPDATE POST
    static async updatePostCaption(postID, newPostCaption, currentUser)  {
        const connection = db.getConnection(); 

        var updatePostOutcome = {
            postID: postID,
            success: false,
            message: "", 
            errors: []
        }

        //UPDATE POST
        return new Promise(async function(resolve, reject) {
            try {
                const queryString = "UPDATE posts SET post_caption = ? WHERE post_id = ? AND post_from = ?"

                connection.query(queryString, [newPostCaption, postID, currentUser], (err, rows) => {
                    if (!err) {  
                        console.log("ROWS " + rows.affectedRows)
                        if(rows.affectedRows > 0) {
                            updatePostOutcome.success = true     
                            updatePostOutcome.message = "You updated the post!"   
                        }
                    } else {    
                        updatePostOutcome.message = "no worky"
                        updatePostOutcome.errors.push(err);
                    } 
                    resolve(updatePostOutcome);
                }) 
                
            } catch(err) {
                updatePostOutcome.message = "rejected";
                updatePostOutcome.errors.push(err);
                console.log("REJECTED " + err);
                reject(updatePostOutcome);
            } 
        });
    }
  

}


module.exports = Post;