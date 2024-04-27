import { useState } from 'react'
import axios from 'axios'

import './App.css'

async function postImage({image, description}) {
  const formData = new FormData();
  formData.append("image", image)
  formData.append("description", description)
  //const result = await axios.post('http://localhost:3003/sam/images/local', formData, { headers: {'Content-Type': 'multipart/form-data'}})
  const result = await axios.post('http://localhost:3003/sam/images/', formData, { headers: {'Content-Type': 'multipart/form-data'}})

  console.log(result.data)
  return result.data
}


function App() {
  const [file, setFile] = useState()
  const [description, setDescription] = useState("")
  const [images, setImages] = useState([])

  const submit = async event => {
    event.preventDefault()
    const result = await postImage({image: file, description: description})
    setImages([result.image, ...images])
  }

  const fileSelected = event => {
    const file = event.target.files[0]
		setFile(file)
	}

  return (
    <div className="App">
      <form onSubmit={submit}>
        <input onChange={fileSelected} type="file" accept="image/*"></input>
        <input value={description} onChange={e => setDescription(e.target.value)} type="text"></input>
        <button type="submit">Submit</button>
      </form>

      { images.map( image => (
        <div key={image}>
          <img src={image}></img>
        </div>
      ))}

      <img alt = "no worky" src="https://insta-app-bucket-tutorial.s3.us-west-2.amazonaws.com/images/e919f0febe8dd3506ae2405c5cf25979"></img>

    </div>
  );
}

export default App;



//APPENDIX
/*
<form action="/profile" method="post" enctype="multipart/form-data">
  <input type="file" name="avatar" />
</form>
*/


/*
axios({
  method: "post",
  url: "myurl",
  data: bodyFormData,
  headers: { "Content-Type": "multipart/form-data" },
})
  .then(function (response) {
    //handle success
    console.log(response);
  })
  .catch(function (response) {
    //handle error
    console.log(response);
  });

    /*
  axios({
    method: "POST",
    url: "http://localhost:3003/sam/images/local",
    data: formData,
    headers: { "Content-Type": "multipart/form-data" },
  })
    .then(function (response) {
      //handle success
      console.log(response);
    })
    .catch(function (response) {
      //handle error
      console.log(response);
    });
    
*/
