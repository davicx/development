const { post } = require("request");
const { restart } = require("nodemon");
const axios = require('axios');

const posts = [
    {title: 'Post One', body: 'This is my first post '},
    {title: 'Post Two', body: 'This is my Two post '}
];

function getPosts() {
    setTimeout(() => {
        let output = '';
        //Loop over Posts
        posts.forEach((post) => {
            output = output + post.title + " ";
        })
        console.log(output);
    
    }, 1000);
}


var auth_token = "just made";

function createPost(post) {
    return new Promise((resolve, reject) => {
        
        setTimeout(() => {
            posts.push(post);

            //Do Error Checking here 
            const error = false;

            auth_token = "hiya"

            if(!error) {
                resolve();
            } else {
                reject("Somethin wrong");
            }
 
        }, 2000);
    })
}

//createPost({title: 'Post Three', body: 'This is my Three post '}).then(getPosts).catch(err =>console.log(err));

//ASYNC
async function init() {
    console.log(auth_token)
    await createPost({title: 'Post Three', body: 'This is my Three post '});
    console.log(auth_token)
    //getPosts();
}

//init();
var user_code = "first";

//ASYNC AWAIT FETCH
async function getUser() {
    try {
      
      //const response = await axios.get('http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php');
      const response = await axios.get('http://0.0.0.0:8888');
      var response_headers = response.headers;
      //console.log(response_headers);
      
      console.log(response.status);

      const output = response.data;
      user_code = "code!"
      console.log(output);

  
    } catch (error) {
        console.log(error);
      
    }
  }
  
//getUser();
console.log(user_code);
(async () => {
    await getUser()
    console.log(user_code);
})()


async function fetchUsers() {
    try {
  
      const response = await axios.get('http://people.oregonstate.edu/~vasquezd/sites/template/site_files/rest/user.php');
      const data = await response.json();
      console.log(data);

    } catch (error) {

    }
  }



