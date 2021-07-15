let a = ['a1','a2','a3','a4']
let b = ['b1','b2','b3','b4']
let c = ['c1','c2','c3','c4']
let d = ['d1','d2','d3','d4']

board = [a,b,c,d]
const playerOne = 'p1';
const playerTwo = 'p2';

dropPiece(4) 


function dropPiece(row) {
    row = row - 1;
    for(let i = 0; i < board.length; i++) {
        console.log(board[i][row]);
    }
}






/*
for (let i = 0; i < a.length; i++) {
    if(playerOne.toUpperCase() !== a[i].toUpperCase()) {
        console.log(playerOne + " Does not equal " + a[i]);
    } else {
        console.log("MATCH! " + playerOne + " Does equal " + a[i]);
    }
    
}
*/


function printBoard() {
    for (let i = 0; i < board.length; i++) {
        console.log("Board "+ i + " " + board[i]);
    }
}

/*
let a1 = ['-','-','-','-']
let a2 = ['-','-','-','-']
let a3 = ['-','-','-','-']
let a4 = ['a','b','c','d']

var board = [a1,a2,a3,a4]

const a = 0;
const b = 1;
const c = 2;
const d = 3;

//printBoard();
dropPiece(b);
//printBoard()            

function dropPiece(row) {
    //board[row][0] = '1';
    console.log(board[3][row]);
    console.log(board.length)
    //console.log(board[row][0])
    //console.log(board[row][1])
    //console.log(board[row][2])
    //console.log(board[row][3])
}


*/



