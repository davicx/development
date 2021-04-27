import React from 'react'
import { FaTimes } from 'react-icons/fa'

const Task = ({task, onDelete, sayHelloDavid }) => {
    return (
        <div className='task'>
            <h4>{ task.text } <FaTimes className='closeIcon' onClick={ () => onDelete(task.id) }/> </h4>
            <p onClick={ sayHelloDavid }>{ task.day } { task.id }</p>
        </div>
    )
}

export default Task


/*
    <button onClick={onClick} style={{backgroundColor: color}} className='btn'>
        {text}
    </button> */