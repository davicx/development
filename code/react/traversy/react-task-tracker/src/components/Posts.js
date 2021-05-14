import React from 'react'
import Button from './Button'

const Posts = () => {
    const onClick = (e) => {
        console.log("you liked me! ");
        //console.log(e);
    }

    return (
        <div className='post'>
            <p> I am a post! </p>
            <Button color='blue' text='Like' onClick={onClick} /> 
        </div>
    )
}

export default Posts


/*
const Header = ({title}) => {

  const onClick = (e) => {
    console.log("you clicked!");
    console.log(e);
  }


  return (
    <header className='header'>
      <h4> {title} </h4>
       <Button color='green' text='Add' onClick={onClick} />
    </header>
  )
}

*/