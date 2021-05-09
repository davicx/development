//Filter
var numbers = [1, 3, 6, 8, 11];

var lucky = numbers.filter(function(number) {
  return number > 7;
});

//console.log(lucky);

class Post {

  constructor(postID) {
    this.postID = postID;
  }
  
  //Getter
  /*
  get postID() {
    return this.postID;
  }
  */

  //Method
  getPostLikes() {
    console.log("Post Likes");
  }
}

let currentPost = new Post(1);
currentPost.getPostLikes();
