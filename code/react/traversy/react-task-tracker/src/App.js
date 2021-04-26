//STOP: 54
import { useState } from 'react'

import Header from './components/Header'
import Tasks from './components/Tasks'

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
    console.log('delete', id);
  }

  return (
    <div className="container">
      <header className="App-header">
        <Header title = {'My Title'}/>
        <Tasks tasks={ tasks } onDelete={ deleteTask }/>
      </header>
    </div>
  );
}

export default App;

/*
<Header title = 'Hello'/>  
*/


//Function Mapping: ra