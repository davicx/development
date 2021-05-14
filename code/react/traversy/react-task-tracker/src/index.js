import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';


ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

/*



function MyApp() {
  const name = "davey"

  return (
    <div className="">
      <p> hello { name } my app! </p>
      <p> It is {new Date().toLocaleTimeString()}.</p>
    </div>
  );
}

setInterval(MyApp, 1000);
export default App;

function tick() {
  const element = (
    <div>
      <p>Hello, world!</p>
      <p>It is {new Date().toLocaleTimeString()}.</p>
    </div>
  );
  ReactDOM.render(element, document.getElementById('root'));
}

setInterval(tick, 1000);
*/
/*
const functions = require("./functions/main");

const user = {
  firstName: 'Davey',
  lastName: 'V'
};

const element = (
  <p>
    Hello, {functions.formatName(user)}!
  </p>
);

const hello = ( <p> Hello </p> );

ReactDOM.render(
  element,
  document.getElementById('root')
);
*/



/*
//MAIN
ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);
*/

//LEARNING
/*
const name = 'Davey';
const element = <h4>Hello, {name} </h4>;

ReactDOM.render(
  element,
  document.getElementById('root')
);
*/

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
