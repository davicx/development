//POST
class Post {
    post_id;
    post_message;
    comments = [];

    constructor(post_id) {
      this.post_id = post_id;
    }

    //Add a Comment
    addComment(comment) {
        this.comments.push(comment);
    }
}

const post_one = new Post(1);
post_one.post_message = "hiya";
post_one.addComment("hiya!!");

const post_two = new Post(2);
post_two.post_message = "Post 2!!";
post_two.addComment("New comment! hiya!!");

console.log(post_one.post_id + " " + post_one.post_message + " " + post_one.comments);
console.log(post_two.post_id + " " + post_two.post_message + " " + post_two.comments);

user_comments = [post_one, post_two]

console.log(user_comments[0].comments[0]);
