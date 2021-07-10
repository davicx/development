//Array of Values
var hobbiton = ["frodo", "sam"];
var bree = ["merry", "pippin"];
var minas_tirith = ["aragon", "faramir"];
var dol_amroth = ["elendil"];

//Associative Array with a list as value
var shire = {
    "hobbiton": hobbiton,
    "bree": bree
};

var gondor = {
    "minas_tirith": minas_tirith,
    "dol_amroth": dol_amroth
};

//Loop over Associative Array
for (var key in shire) {
    if (shire.hasOwnProperty(key)) {
        console.log("PLACE: " + key);
        let shirePeople = shire[key];
        console.log(shirePeople);
        
        for(let i = 0; i < shirePeople.length; i++) {
            console.log(shirePeople[i]);
        }
    }
} 

//Classes
class Post {
  constructor(postID) {
      this.postID = postID;
      this.postFrom = "";
      this.postTo = "";
      this.postCaption = "";
  }

  //Getter
  get postCaption() {
    return this._postCaption;
  } 

  //Setter
  set postCaption(newCaption) {
    this._postCaption = newCaption;
  }

  getPostInfo() {
      console.log("Post " + this.postID + " " + postFrom + " " + postTo);  
  }

  //Method A2: Get User Info 
  static postText(caption)  {
      console.log("You made a post! " + caption);
  }
}

let currentPost = new Post(1);
console.log(currentPost.postID);
console.log(currentPost.postID);
currentPost.postCaption = "hiya!"
console.log(currentPost.postCaption)



