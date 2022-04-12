/**
 * @param {number[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var gameOfLife = function (board) {
  let newBoard = [];
  for (let i = 0; i < board.length; i++) {
    newBoard[i] = [];
    for (let j = 0; j < board[i].length; j++) {
      let startM = i - 1 > -1 ? i - 1 : i;
      let startN = j - 1 > -1 ? j - 1 : j;
      let endM = i + 1 < board.length ? i + 1 : i;
      let endN = j + 1 < board[i].length ? j + 1 : j;
      let countLive = 0;
      for (let m = startM; m <= endM; m++) {
        for (let n = startN; n <= endN; n++) {
          if ((m != i || n != j) && board[m][n] == 1) {
            countLive++;
          }
        }
      }
      let value = 0;
      if (board[i][j] == 0) {
        if (countLive == 3) {
          value = 1;
        }
      } else {
        value = 1;
        if (countLive > 3 || countLive < 2) {
          value = 0;
        }
      }
      newBoard[i].push(value);
    }
  }
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      board[i][j] = newBoard[i][j];
    }
  }
};

let board1 = [
  [0, 1, 0],
  [0, 0, 1],
  [1, 1, 1],
  [0, 0, 0],
];
let board2 = [
  [1, 1],
  [1, 0],
];

gameOfLife(board1);
gameOfLife(board2);

console.log(board1);
console.log(board2);
