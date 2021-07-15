//FUNCTIONS TABLE OF CONTENTS//
/*

FUNCTIONS A: Connect Four 
	1) Function A1:   
	2) Function A2:  

*/

document.addEventListener('DOMContentLoaded', () => {

  const squares = document.querySelectorAll('.grid div')
  const result = document.querySelector('#result')
  //const result = document.getElementById("result").textContent
  //const result = document.getElementById("result")
  const displayCurrentPlayer = document.querySelector('#current-player')
  let currentPlayer = 1

  var board = [
    [1, 2, 2, 1],
    [0, 1, 1, 1],
    [0, 0, 2, 2],
    [0, 1, 1, 2]
  ];


  function checkBoard() {
    for (let i = 0; i < board.length; i++) {
      console.log("row " + i)
      for (let j = 0; j < board[i].length; j++) {
        console.log(board[i][j]);
      }
    
    }
    
  }
  
  
  //Squares
  for (let i = 0; i < squares.length; i++) {
    squares[i].onclick = () => {
      /*
      console.log("Square: " + i);
      if(squares[i].classList.contains('has')) {
        console.log( squares[i] + " Has the class")
      } else {
        console.log("nope")

      }
      */

        checkBoard()
    
    }
  }
  
})


/*

//FUNCTIONS A: Connect Four 
const btn = document.querySelector('button');

btn.onclick = function() {
	alert();
  //document.body.style.backgroundColor = rndCol;
}



const container = document.querySelector('.grid-container');
var squares = document.querySelectorAll('.grid-item');
//var x = document.querySelectorAll(".grid-item").length;

container.onclick = function() {
	
	console.log(squares);
}


 
//const grid = document.querySelectorAll('button');


for (let i = 0; i < buttons.length; i++) {
  buttons[i].onclick = bgChange;
}

squares.forEach(function(square) {
  console.log(square);
});


 for (let i = 0; i < squares.length; i++) {
    squares[i].onclick = () => {
      console.log(squares[i]);
    }
  }
*/