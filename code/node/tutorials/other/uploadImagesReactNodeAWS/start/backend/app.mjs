import express, { json } from "express";
import cors from "cors";
import multer, { memoryStorage } from "multer";
import { uploadToS3 } from "./s3.mjs";
import "dotenv/config";
import { S3Client, GetObjectCommand } from '@aws-sdk/client-s3'
import { getSignedUrl } from '@aws-sdk/s3-request-presigner'



const app = express();
const PORT = process.env.PORT || 4000;

//const storage = memoryStorage();
//const upload = multer({ storage });
const storage = multer.diskStorage({
  destination: (req, file, cb) => {
    cb(null, 'uploads/');
  }
});

const upload = multer({
  storage: storage,
  limits: { fileSize: 100000000 },
});

app.use(
  cors({
    origin: "*",
  })
);
app.use(json());

app.get("/", (req, res) => res.send("Yo! success"));

app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});

app.post("/images", upload.single("image"), (req, res) => {
  const { file } = req;
  const userId = req.headers["x-user-id"];
  console.log("API: Uploading a file")
  console.log(file)
  console.log("userId: " + userId)
  
  if (!file || !userId) {
    return res.status(400).json({ message: "Bad request" });
  }

  //Upload File
  const { error, key } = uploadToS3({ file, userId });

  if (error) {
    return res.status(500).json({ message: error.message });
  } 

  return res.status(201).json({ key });
});


// https://stackoverflow.com/questions/52667434/aws-s3-generating-signed-urls-accessdenied
app.get("/url", upload.single("image"), async (req, res) => {

  const bucketName = process.env.AWS_BUCKET_NAME
  const region = process.env.AWS_BUCKET_REGION
  const accessKeyId = process.env.AWS_ACCESS_KEY
  const secretAccessKey = process.env.AWS_SECRET_KEY

const s3Client = new S3Client({
    region,
    accessKeyId,
    secretAccessKey
  })

  const command = new GetObjectCommand({
    Bucket: bucketName,
    Key: "images/postImage-1715552334522-432267929-stars.jpg"
  })
  const preSignedUrl = await getSignedUrl(s3Client, command, {
    expiresIn: 3600
  })


  console.log(preSignedUrl)
  res.json({get:"Get"})
});

