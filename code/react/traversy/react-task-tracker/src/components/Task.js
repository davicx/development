import React from 'react'
import { FaTimes } from 'react-icons/fa'

const Task = ({task, onDelete }) => {
    return (
        <div className='task'>
            <h4>{ task.text } <FaTimes className='closeIcon' onClick={ () => onDelete(task.id) }/> </h4>
            <p>{task.day }</p>
        </div>
    )
}

export default Task
