const express = require('express')
const app = express()
require('dotenv').config();
const crypto = require('crypto')
//const sharp = require('sharp');
/*
import { S3Client, PutObjectCommand, DeleteObjectCommand, GetObjectCommand } from "@aws-sdk/client-s3"
import { getSignedUrl } from "@aws-sdk/s3-request-presigner"

import dotenv from 'dotenv'
const multerS3 = require('multer-s3');

const s3 = new S3({ region, accessKeyId, secretAccessKey })
const fs = require('fs') 
const multer = require('multer')
const upload = multer({ dest: './uploads' })

*/
const S3 = require('aws-sdk/clients/s3')


const cookieParser = require('cookie-parser');
var cors = require('cors')
const morgan = require('morgan')
var bodyParser = require('body-parser');
const multer = require('multer')
//const upload = multer({ dest: 'uploads/' })
//const { uploadFile, getFileStream } = require('./s3')
var mime = require('mime-types')

var bodyParser = require('body-parser');
const { S3Client, GetObjectCommand, PutObjectCommand } = require("@aws-sdk/client-s3");
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));


app.use(express.json());
app.use(cors())
app.use(cookieParser())
//App
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

//Multer
const storage = multer.memoryStorage()
const upload = multer({storage: storage})

//const { uploadFile, getFileStream } = require('./s3')
//var mime = require('mime-types')

//Signed URL
const { getSignedUrl } = require("@aws-sdk/s3-request-presigner");


//APP
app.use(express.json());
app.use(cors())
app.use(cookieParser())

//ENV
const bucketName = process.env.AWS_BUCKET_NAME
const bucketRegion = process.env.AWS_BUCKET_REGION
const accessKey = process.env.AWS_ACCESS_KEY
const secretAccessKey = process.env.AWS_SECRET_KEY

const generateFileName = (bytes = 32) => crypto.randomBytes(bytes).toString('hex')


//S3
const s3 = new S3Client({ 
  credentials: {
    accessKeyId: accessKey,
    secretAccessKey: secretAccessKey 
  },
  region: bucketRegion
})

app.get("/", (req, res) => {
  console.log("Hello!");
  res.json({hi: "hiya!"})
})


app.get("/api/posts", async (req, res) => {
  console.log("Hello!");
  const post1 = {userName: "davey", caption: "hiya!", imageKey: "59045070_p0.jpg"}
  //const post2 = {userName: "Frodo", caption: "B"}
  //const post3 = {userName: "David", caption: "B"}

  //const posts = [post1, post2, post3];
  const posts = [post1];

  const getObjectParams = {
    Bucket: bucketName,
    Key: post1.imageKey,
  }

  //const client = new S3Client(clientParams);
  const command = new GetObjectCommand(getObjectParams);
  const url = await getSignedUrl(s3, command, { expiresIn: 3600 });
  post1.imageURL = url

  res.json({posts})

})




app.post("/api/posts", upload.single('image'), async (req, res) => {
  console.log("Hello! got your image!");
  const file = req.file
  const caption = req.body.caption
  //const caption = req.body.caption
  const imageName = generateFileName()

  //const fileBuffer = await sharp(file.buffer).resize({ height: 1920, width: 1080, fit: "contain" }).toBuffer()

  const params = {
    Bucket: bucketName,
    Key: imageName + req.file.originalname,
    Body: req.file.buffer,
    ContentType: req.file.mimetype
  }

  const command = new PutObjectCommand(params)

  await s3.send(command)

  console.log(req.body)
  res.json({file: file.originalname, caption: caption})
})

app.delete("/api/posts", (req, res) => {
  res.json({hello: "hello!"})

})

app.listen(3003, () => {
  console.log("Server is up and listening on 3003...")
})





/*

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