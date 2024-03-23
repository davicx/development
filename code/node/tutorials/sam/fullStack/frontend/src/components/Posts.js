import { useState } from 'react';
import { Box, Button, Text, Input } from '@chakra-ui/react';
import useMutation from '../hooks/useMutation';

//GLOBAL
const validFileTypes = ['image/jpg', 'image/jpeg', 'image/png'];
const ErrorText = ({ children, ...props }) => (
  <Text fontSize="lg" color="red.300" {...props}>
    {children}
  </Text>
);
const URL = '/images';


//COMPONENT
const Posts = () => {
  const { mutate: uploadImage, isLoading: uploading, error: uploadError } = useMutation({url: URL})
  const [error, setError] = useState('');

  //Function: Upload Button
  const handleUpload = async e => {
    console.log(e)
    const file = e.target.files[0];
    if (!validFileTypes.find(type => type === file.type)) {
      console.log("not the right type dude")
 
      setError('File must be in JPG/PNG format');
      return;
    }

    const form = new FormData();
    form.append('image', file);
    await uploadImage(form)

  };


  return (
    <Box mt={6}>
      <Input id="imageInput" type="file" hidden onChange={handleUpload} />
      <Button
        as="label"
        htmlFor="imageInput"
        colorScheme="blue"
        variant="outline"
        mb={4}
        cursor="pointer"
        isLoading={uploading}
      >
        Upload
      </Button>

      {error && <ErrorText>Error: {error}</ErrorText>}
      {uploadError && <ErrorText>Error Upload: {error}</ErrorText>}
      
      <Text textAlign="left" mb={4}>
        Posts
      </Text>
    </Box>
  );
};
export default Posts;
