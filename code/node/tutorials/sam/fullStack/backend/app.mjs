import "dotenv/config";
import express, { json } from "express";
import multer, { memoryStorage } from "multer";
import cors from "cors";

const storage = memoryStorage();
const upload = multer({ storage });

const app = express();

const PORT = process.env.PORT || 4000;

app.use(
  cors({
    origin: "*",
  })
);
app.use(json());

app.get("/", (req, res) => res.send("success"));


app.post("/images", upload.single("image"), (req, res) => {
  const { file } = req;
  //const userId = req.headers["x-user-id"];

  //if (!file || !userId) return res.status(400).json({ message: "Bad request" });

  //const { error, key } = uploadToS3({ file, userId });
  //if (error) return res.status(500).json({ message: error.message });

  return res.status(201).json({succes: "Success"});
});

app.get("/images", async (req, res) => {
  const userId = req.headers["x-user-id"];

  if (!userId) return res.status(400).json({ message: "Bad request" });

  const { error, presignedUrls } = await getUserPresignedUrls(userId);
  if (error) return res.status(400).json({ message: error.message });

  return res.json(presignedUrls);
});

app.listen(PORT, () => {
  console.log(`Server listening on port ${PORT}`);
});
