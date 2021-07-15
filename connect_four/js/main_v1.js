//FUNCTIONS TABLE OF CONTENTS//
/*

FUNCTIONS A: Connect Four 
	1) Function A1:   
	2) Function A2:  

*/

document.addEventListener('DOMContentLoaded', () => {
  const squares = document.querySelectorAll('.grid div')

  function checkBoard() {
   console.log("do we have a winner?")
  }
  
  //Squares
  for (let i = 0; i < squares.length; i++) {
    squares[i].onclick = () => {
      console.log("Square: " + i);
      if(squares[i].classList.contains('has')) {
        console.log( squares[i] + " Has the class")
      } else {
        console.log("nope")

      }
        checkBoard()
    }
  }
  
})

