const { post } = require("request");

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

function createPost(post) {
    setTimeout(() => {
        posts.push(post);
        callback();
    }, 2000);
}

createPost({title: 'Post Three', body: 'This is my Three post '});




/*
const { post } = require("request");

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

function createPost(post) {
    setTimeout(() => {
        posts.push(post);
        callback();
    }, 2000);
}

createPost({title: 'Post Three', body: 'This is my Three post '});


*/
