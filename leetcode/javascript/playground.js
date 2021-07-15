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

function printBoard() {
    for (let i = 0; i < board.length; i++) {
        console.log("Board "+ i + " " + board[i]);
    }
}




