import Task from './Task'

//rafce
const Tasks = ({tasks, onDelete, sayHelloDavid }) => {
    return (
        <div>
            {tasks.map((task) =>(
                <Task key={task.id} task = {task} onDelete={onDelete} sayHelloDavid={ sayHelloDavid } />
            ))}
        </div>
    )
}

export default Tasks




/*
import { FaTimes } from 'react-icons/fa'

const Task = ({ task, onDelete, onToggle }) => {
  return (
    <div
      className={`task ${task.reminder ? 'reminder' : ''}`}
      onDoubleClick={() => onToggle(task.id)}
    >
      <h3>
        {task.text}{' '}
        <FaTimes
          style={{ color: 'red', cursor: 'pointer' }}
          onClick={() => onDelete(task.id)}
        />
      </h3>
      <p>{task.day}</p>
    </div>
  )
}

export default Task

*/