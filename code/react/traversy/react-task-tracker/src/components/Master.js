//EXAMPLE 1: Simple Component with Props that is an array

/*
//App
import { useState } from 'react'
import React from 'react';
import Header from './components/Header'

function App() {
  const name = "davey"
  const myArray = ['hiya', 'me too!']

  return (
    <div className="">
      <Header inputArray = {myArray} />
    </div>
  );
}

export default App;

//Header
import PropTypes from 'prop-types'
import Button from './Button'

import React from 'react'

const Header = (props) => {
  return (
    <div>
      <p> hello {props.inputArray[1]} </p>
    </div>
  )
}

Header.defaultProps = {
  title: 'Hiya!'
}

export default Header
*/