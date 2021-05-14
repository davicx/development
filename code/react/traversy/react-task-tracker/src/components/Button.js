import PropTypes from 'prop-types'

const Button = ( { color, text, onClick}) => {
    return (
        <button onClick={onClick} style={{backgroundColor: color}}  className='btn'> 
            {text} 
        </button>
    )
}

export default Button

Button.defaultProps = {
    color: 'steelblue',
}

Button.propTypes = {
    text: PropTypes.string,
    color: PropTypes.string,
    onClickArrow: PropTypes.func,
}
  

//WORKS
/*

    let count = 0;

    function onClick(count) {
        console.log("you clicked! " + count);
        count = count + 1;
        //console.log(e);
    }
     */
/*
//rafce
const Button = ({color, text, onClick}) => {
    return (
    //<button onClick={onClick} style={{backgroundColor: color}} className='btn'>
    <button onClick={ () => onClick("hi!!") } style={{backgroundColor: color}} className='btn'>
        {text}
    </button>
    )
}

//onClick={ () => onDelete(task.id)




export default Button

*/



//Button with its own On Click
/*
const Button = ({color, text}) => {

    const onClick = () => {
        console.log("hiya");
    }
 

    const onClick = (e) => {
        console.log("hiya" + e);
    }


    return (
    <button onClick={onClick} style={{backgroundColor: color}} className='btn'>
        {text}
    </button>
    )
}

Button.defaultProps = {
    color: 'steelblue',
}
  
Button.propTypes = {
    text: PropTypes.string,
    color: PropTypes.string,
    onClick: PropTypes.func,
}

export default Button

*/