const express = require('express')
const app = express()
const cookieParser = require('cookie-parser');
var cors = require('cors')
const morgan = require('morgan')
const multer = require('multer')
const upload = multer({ dest: 'uploads/' })
const { uploadFile, getFileStream } = require('./s3')
var mime = require('mime-types')

var bodyParser = require('body-parser');
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


app.use(express.json());
app.use(cors())
app.use(cookieParser())
//app.use(morgan('short'));

app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})

app.get("/", (req, res) => {
  console.log("Hello!");
  res.json({hi: "hiya!"})
})

app.post("/images", (req, res) => {
  console.log("Hello! got your image!");
  console.log(req.body)
  res.json({hello: "hello!"})
})


//UPLOAD Local
app.post("/sam/images/local", upload.single('image'), (req, res) => {
  let description = req.body.description
  let file = req.file

  console.log(file)
  res.json({hello: "Hello! got your image!", description: description, file: file})
})

//UPLOAD AWS
app.post('/sam/images', upload.single('image'), async (req, res) => {
  const file = req.file
  const description = req.body.description

  //add error handling
  const result = await uploadFile(file)
  const fullKey = "/images/" + result.key;

  let fileExtension = mime.extension(file.mimetype) 

  console.log("result")
  console.log(result)
  console.log("file")
  console.log(file)

  res.send({yay: "yay!", result: result, imagePath: fullKey, file: file, description: description, fileExtension: fileExtension})

})

//images/4e0e3dcad36549f198eb751de1c03679
//GET IMAGE
app.get('/sam/images/:key', (req, res) => {
  console.log(req.params)
  const key = req.params.key

  const fullKey = "images/" + key;
  console.log("You got the image with full key")
  console.log(fullKey)
  const readStream = getFileStream(fullKey)

  readStream.pipe(res)
  //res.json({hi:key})
})



/*

//UPLOAD Local
app.post('/local/images', upload.single('image'), async (req, res) => {
  const file = req.file
  const description = req.body.description

  let fileExtension = mime.extension(file.mimetype) 

  console.log(file)
  console.log("description")
  console.log(description)


  res.send({yay: "yay!", file: file, description: description, fileExtension: fileExtension})
})

//UPLOAD AWS
app.post('/images', upload.single('image'), async (req, res) => {
  const file = req.file
  const description = req.body.description


  //add error handling
  const result = await uploadFile(file)
  const fullKey = "/images/" + result.key;

  let fileExtension = mime.extension(file.mimetype) 

  console.log("result")
  console.log(result)
  console.log("file")
  console.log(file)

  res.send({yay: "yay!", result: result, imagePath: fullKey, file: file, description: description, fileExtension: fileExtension})

})





*/

// Put this statement near the top of your module
/*
var bodyParser = require('body-parser');
// Put these statements before you define any routes.
//app.use(bodyParser.urlencoded());
app.use(bodyParser.json());

var forms = multer();

// apply them
app.use(bodyParser.urlencoded({ extended: true }));

*/
////