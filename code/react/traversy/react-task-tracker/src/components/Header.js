import PropTypes from 'prop-types'
import Button from './Button'

import React from 'react'

const Header = ({title}) => {

  const onClick = (e) => {
    console.log("you clicked!");
    console.log(e);
  }
 
  /*
    let count = 0;

  function onClick(count) {
      console.log("you clicked! " + count);
      count = count + 1;
      //console.log(e);
  } */

  return (
    <header className='header'>
      <h4> {title} </h4>
       <Button color='green' text='Add' onClick={onClick} />
    </header>
  )
}

Header.defaultProps = {
  title: 'Hiya say something!'
}

Header.propTypes = {
  title: PropTypes.string.isRequired,
}

export default Header


//STYLE:
//<p style= { headingStyle }> Header! </p> 
const headingStyle = {
  backgroundColor: 'blue',
}

/*
const Header = ({ title }) => {
  const onClick = (message) => {
    console.log("hiya! ", message);
  }


    return (
        <div>
            <header className='header'>
              <h4> { title } </h4>
              <Button color='green' text='Add' onClick={onClick}  />
            </header>
            
        </div>
    )
}





export default Header


*/




//TYPE 1:
/*
const Header = (props) => {
    return (
        <div>
            <p>{props.hiya}</p>
        </div>
    )
}


Header.defaultProps = {
  hiya: 'Hiya!'
}

export default Header

//TYPE 2:
const Header = ({ title }) => {
    return (
        <div>
            <p style={headingStyle}> style </p>
            <p> { title } </p>
            <button className='btn'>Add</button>
        </div>
    )
}


//TYPE 3: Props Input
//App.js
import Header from './components/Header'

function App() {
  return (
    <div className="container">
      <header className="App-header">
        <p> hi </p>
        <p> { console.log("hiya") }</p>
        <Header />
         <Header title = 'Hello'/>  
      </header>
    </div>
  );
}

export default App;

//Header 
const Header = (props) => {
  return (
      <div>
          <p>task tracker {props.title}</p>
      </div>
  )
}

export default Header
*/

//TYPE 3: Default Props
/*
const Header = (props) => {
    return (
        <div>
            <p>{props.hiya}</p>
        </div>
    )
}

Header.defaultProps = {
  hiya: 'Hiya!'
}

export default Header

*/

/*
import PropTypes from 'prop-types'
import { useLocation } from 'react-router-dom'
import Button from './Button'

const Header = ({ title, onAdd, showAdd }) => {
  const location = useLocation()

  return (
    <header className='header'>
      <h1>{title}</h1>
      {location.pathname === '/' && (
        <Button
          color={showAdd ? 'red' : 'green'}
          text={showAdd ? 'Close' : 'Add'}
          onClick={onAdd}
        />
      )}
    </header>
  )
}

Header.defaultProps = {
  title: 'Task Tracker',
}

Header.propTypes = {
  title: PropTypes.string.isRequired,
}

// CSS in JS
// const headingStyle = {
//   color: 'red',
//   backgroundColor: 'black',
// }

export default Header
*/
