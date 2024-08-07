require('dotenv').config()
const S3 = require('aws-sdk/clients/s3')
const fs = require('fs');

const bucketName = process.env.AWS_BUCKET_NAME
const region = process.env.AWS_BUCKET_REGION
const accessKeyId = process.env.AWS_ACCESS_KEY
const secretAccessKey = process.env.AWS_SECRET_KEY

const s3 = new S3({
    region,
    accessKeyId,
    secretAccessKey
  })


//Upload to S3
function uploadFile(file) {
    const fileStream = fs.createReadStream(file.path)
    //const key = "images/" + file.filename;
    const key = "images/" + file.filename;
  
    const uploadParams = {
      Bucket: bucketName,                                                                                                                                                               
      Body: fileStream,
      Key: key
    }
  
    return s3.upload(uploadParams).promise()

}

exports.uploadFile = uploadFile

//Download from S3
function getFileStream(fileKey) {
  const downloadParams = {
    Key: fileKey,
    Bucket: bucketName
  }

  return s3.getObject(downloadParams).createReadStream()
}

exports.getFileStream = getFileStream



/*  
const s3 = new S3({
    region: region,
    accessKeyId: accessKeyId,
    secretAccessKey: secretAccessKey
  })
*/

/*
//Download from S3
function getFileStream(fileKey) {
const downloadParams = {
    Key: fileKey,
    Bucket: bucketName
}

return s3.getObject(downloadParams).createReadStream()
}
exports.getFileStream = getFileStream
  */