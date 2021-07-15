//FUNCTIONS TABLE OF CONTENTS//
/*

FUNCTIONS A: Connect Four 
	1) Function A1:   
	2) Function A2:  

*/

document.addEventListener('DOMContentLoaded', () => {

  const squares = document.querySelectorAll('.grid div')
  const result = document.querySelector('#result')
  const result = document.getElementById("result").textContent
  const result = document.getElementById("result")
  const displayCurrentPlayer = document.querySelector('#current-player')
  let currentPlayer = 1

  function checkBoard() {
   console.log("do we have a winner?")
  }
  
  
  //Squares
  for (let i = 0; i < squares.length; i++) {
    squares[i].onclick = () => {
      //if the square below your current square is taken, you can go ontop of it
      if (squares[i + 7].classList.contains('taken') &&!squares[i].classList.contains('taken')) {
        if (currentPlayer == 1) {
          squares[i].classList.add('taken')
          squares[i].classList.add('player-one')
          currentPlayer = 2
          displayCurrentPlayer.innerHTML = currentPlayer
        } else if (currentPlayer == 2){
          squares[i].classList.add('taken')
          squares[i].classList.add('player-two')
          currentPlayer = 1
          displayCurrentPlayer.innerHTML = currentPlayer        
        } 
      } else alert('cant go here')
      console.log("check");
      checkBoard()
    }
  }
  
})

