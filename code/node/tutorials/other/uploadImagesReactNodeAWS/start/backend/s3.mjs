import {
  GetObjectCommand,
  ListObjectsV2Command,
  PutObjectCommand,
  S3Client,
} from "@aws-sdk/client-s3";
//import { getSignedUrl } from "@aws-sdk/s3-request-presigner";
//import { v4 as uuid } from "uuid";
//const s3 = new S3Client();
//const fs = require('fs');

const bucketName = process.env.AWS_BUCKET_NAME
const region = process.env.AWS_BUCKET_REGION
const accessKeyId = process.env.AWS_ACCESS_KEY
const secretAccessKey = process.env.AWS_SECRET_KEY

const s3 = new S3Client({
    region,
    accessKeyId,
    secretAccessKey
})




//Upload to S3
export const uploadToS3 = async (file) => {
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



/*
export const uploadToS3 = async ({ file, userId }) => {
  const key = `${userId}/${uuid()}`;
  const command = new PutObjectCommand({
    Bucket: BUCKET,
    Key: key,
    Body: file.buffer,
    ContentType: file.mimetype,
  });

  try {
    await s3.send(command);
    return { key };
  } catch (error) {
    console.log(error);
    return { error };
  }
};

const getImageKeysByUser = async (userId) => {
  const command = new ListObjectsV2Command({
    Bucket: BUCKET,
    Prefix: userId,
  });

  const { Contents = [] } = await s3.send(command);

  return Contents.sort(
    (a, b) => new Date(b.LastModified) - new Date(a.LastModified)
  ).map((image) => image.Key);
};

export const getUserPresignedUrls = async (userId) => {
  try {
    const imageKeys = await getImageKeysByUser(userId);

    const presignedUrls = await Promise.all(
      imageKeys.map((key) => {
        const command = new GetObjectCommand({ Bucket: BUCKET, Key: key });
        return getSignedUrl(s3, command, { expiresIn: 900 }); // default
      })
    );
    return { presignedUrls };
  } catch (error) {
    console.log(error);
    return { error };
  }
};

/*
import { getSignedUrl } from "@aws-sdk/s3-request-presigner";
import { v4 as uuid } from "uuid";

import {
  GetObjectCommand,
  ListObjectsV2Command,
  PutObjectCommand,
  S3Client,
} from "@aws-sdk/client-s3";
//import { getSignedUrl } from "@aws-sdk/s3-request-presigner";
//import { v4 as uuid } from "uuid";
//const fs = require('fs');

const bucketName = process.env.AWS_BUCKET_NAME
const region = process.env.AWS_BUCKET_REGION
const accessKeyId = process.env.AWS_ACCESS_KEY
const secretAccessKey = process.env.AWS_SECRET_KEY

const s3 = new S3Client();
const BUCKET = process.env.BUCKET;

export const uploadToS3 = async ({ file, userId }) => {
  const key = `${userId}/${uuid()}`;
  const command = new PutObjectCommand({
    Bucket: BUCKET,
    Key: key,
    Body: file.buffer,
    ContentType: file.mimetype,
  });

  try {
    await s3.send(command);
    return { key };
  } catch (error) {
    console.log(error);
    return { error };
  }
};
*/

/*
const getImageKeysByUser = async (userId) => {
  const command = new ListObjectsV2Command({
    Bucket: BUCKET,
    Prefix: userId,
  });

  const { Contents = [] } = await s3.send(command);

  return Contents.sort(
    (a, b) => new Date(b.LastModified) - new Date(a.LastModified)
  ).map((image) => image.Key);
};

export const getUserPresignedUrls = async (userId) => {
  try {
    const imageKeys = await getImageKeysByUser(userId);

    const presignedUrls = await Promise.all(
      imageKeys.map((key) => {
        const command = new GetObjectCommand({ Bucket: BUCKET, Key: key });
        return getSignedUrl(s3, command, { expiresIn: 900 }); // default
      })
    );
    return { presignedUrls };
  } catch (error) {
    console.log(error);
    return { error };
  }
};


*/



/*



*/
/*
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


*/
