//Stop 10

//Promises



//Callbacks
const posts = [
	{title: 'Post One', body: 'Hello Post one!'},
	{title: 'Post Two', body: 'Hello Post two!'}
];

function getPosts() {
	setTimeout(() => {
		let output = '';
		
		posts.forEach((post) => {
			output += `<li> ${post.title} </li>`;
		})

		document.body.innerHTML = output;

	}, 1000);
}

function createPost(post, callback) {
	setTimeout(() => {
		posts.push(post);
		callback();
	}, 2000);
}


createPost({title: 'Post Three', body: 'Hello Post Three!'}, getPosts);







/*



//Basic Template
const posts = [
	{title: 'Post One', body: 'Hello Post one!'},
	{title: 'Post Two', body: 'Hello Post two!'}
];

function getPosts() {
	setTimeout(() => {
		let output = '';
		
		posts.forEach((post) => {
			output += `<li> ${post.title} </li>`;
		})

		document.body.innerHTML = output;

	}, 1000);
}

function createPost(post) {
	setTimeout(() => {
		posts.push(post);
	}, 2000);
}

getPosts();
createPost({title: 'Post Three', body: 'Hello Post Three!'});
*/