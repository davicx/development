import React from 'react';
import { ChakraProvider, Box } from '@chakra-ui/react';
import Profile from './components/Profile';
import theme from './config/theme';

//STOP 20: Setting up AWS
function App() {
  return (
    <ChakraProvider theme={theme}>
      <Box textAlign="center" fontSize="2xl" m="3rem auto" p={5} maxW={700}>
        <Profile />
        
      </Box>
    </ChakraProvider>
  );
}

export default App;


/*

import { S3Client, GetObjectCommand } from '@aws-sdk/client-s3'
import { getSignedUrl } from '@aws-sdk/s3-request-presigner'

const s3Client = new S3Client()
const command = new GetObjectCommand({
  Bucket: "some-bucket",
  Key: "some-object"
})

const preSignedUrl = await getSignedUrl(s3Client, command, {
  expiresIn: 3600
})

console.log(preSignedUrl)
*/