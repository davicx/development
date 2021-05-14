import { useState } from 'react'
import React from 'react';
import Header from './components/Header'
import Posts from './components/Posts'
//import Tasks from './components/Tasks'

function App() {
  const name = "davey"
  const myArray = ['hiya', 'me too!']

  return (
    <div>
      
      <div className="container">
        <Header title = 'Task Tracker '/>
      </div>
      
      <Posts />

    </div>
  );
}

export default App;


/*


function App() {
  const name = "davey"

  return (
    <div className="">
      <p> hello { name }</p>
    </div>
  );
}

export default App;



function App() {
  const [tasks, setTasks] = useState([
    {
        id: 1,
        text: 'Garden Store',
        day: 'Saturday',
        reminder: true,
    },
    {
        id: 2,
        text: 'Store',
        day: 'Saturday',
        reminder: true,
    },
    {
        id: 3,
        text: 'Shopping',
        day: 'Thursday',
        reminder: false,
    }
  ])

  //Delete Task
  const deleteTask = (id) => {
    //console.log('delete', id);
    setTasks(tasks.filter((task) => task.id !== id))
  }

  const mySayHelloFunction = () => {
    console.log('Say Hello!');
  }


  return (
    <div className="container">
      <header className="App-header">
        <Header title = {'My Title'}/>
        <Tasks tasks={ tasks } onDelete={ deleteTask } sayHelloDavid = { mySayHelloFunction }/>
      </header>
    </div>
  );
}

*/


/*

class App extends React.Component {
  render() {
    return (
      <div>
        <p> hello!</p>
      </div>
    );
  }
}

*/



