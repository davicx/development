import {
  Box,
  Button,
  CircularProgress,
  Image,
  Input,
  SimpleGrid,
  Text,
} from '@chakra-ui/react';
import { useState } from 'react';
import useMutation from '../hooks/useMutation';
//import useQuery from '../hooks/useQuery';

const validFileTypes = ['image/jpg', 'image/jpeg', 'image/png'];
const URL = '/post/photo/local';

const Posts = () => {
  const [error, setError] = useState('');
  const {
    mutate: uploadImage,
    isLoading: uploading,
    error: uploadError,
  } = useMutation({ url: URL });

  const handleUpload = async e => {
    console.log(e)
    const file = e.target.files[0];
    console.log(file)

    if (!validFileTypes.find(type => type === file.type)) {
      setError('File must be in JPG/PNG format');
      return;
    }

    const form = new FormData();
    form.append('image', file);

    await uploadImage(form);

  }

  return (
    <Box mt={6}>
      <Input id="imageInput" type="file" hidden onChange={handleUpload} />
      <Button as="label" htmlFor="imageInput" colorScheme="blue" variant="outline" mb={4} cursor="pointer">
        Upload
      </Button>
      {error && <Text>{error}</Text>}

      <Text textAlign="left" mb={4}>
        Posts
      </Text>
    </Box>
  );
};
export default Posts;
