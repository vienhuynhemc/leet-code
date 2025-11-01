/**
 * @param {character[][]} board
 * @return {void} Do not return anything, modify board in-place instead.
 */
var solveSudoku = function (board) {
  let newBoard = getSolverBoard(board);
  for (let i = 0; i < board.length; i++) {
    for (let j = 0; j < board[i].length; j++) {
      board[i][j] = newBoard[i][j];
    }
  }
  console.log(board);
};

function getSolverBoard(board) {
  if (board[0][0] !== '.') {
    return solve(board, 0, 0, -1);
  } else {
    let result = null;
    for (let i = 1; i < 10; i++) {
      result = solve(board, 0, 0, i);
      if (result != null) {
        break;
      }
    }
    return result;
  }
}

function isValidSudoku(board) {
  for (let i = 0; i < board.length; i++) {
    let array = [];
    for (let j = 0; j < board[i].length; j++) {
      if (board[i][j] !== '.') {
        if (array.includes(board[i][j])) return false;
        array.push(board[i][j]);
      }
    }
  }
  for (let i = 0; i < board[0].length; i++) {
    let array = [];
    for (let j = 0; j < board.length; j++) {
      if (board[j][i] !== '.') {
        if (array.includes(board[j][i])) return false;
        array.push(board[j][i]);
      }
    }
  }
  for (let i = 0; i < 3; i++) {
    for (let j = 0; j < 3; j++) {
      let array = [];
      for (let m = 3 * i; m < 3 * i + 3; m++) {
        for (let n = 3 * j; n < 3 * j + 3; n++) {
          if (board[m][n] !== '.') {
            if (array.includes(board[m][n])) return false;
            array.push(board[m][n]);
          }
        }
      }
    }
  }
  return true;
}

function solve(board, i, j, value) {
  if (board == null) {
    return board;
  }
  if (i === 9) {
    return board;
  }
  if (value !== -1) {
    board[i][j] = value + '';
  }
  if (isValidSudoku(board)) {
    let newJ = j + 1;
    let newI = i;
    if (newJ === 9) {
      newJ = 0;
      newI = i + 1;
    }
    if (newI < 9 && newJ < 9 && board[newI][newJ] !== '.') {
      return solve(copyArray(board), newI, newJ, -1);
    } else {
      for (let m = 1; m < 10; m++) {
        let newBoard = solve(copyArray(board), newI, newJ, m);
        if (newBoard != null) {
          return newBoard;
        }
      }
      return null;
    }
  } else {
    return null;
  }
}

function copyArray(board) {
  let result = [];
  for (let i = 0; i < board.length; i++) {
    result[i] = [];
    for (let j = 0; j < board[i].length; j++) {
      result[i].push(board[i][j]);
    }
  }
  return result;
}

solveSudoku([
  ['5', '3', '.', '.', '7', '.', '.', '.', '.'],
  ['6', '.', '.', '1', '9', '5', '.', '.', '.'],
  ['.', '9', '8', '.', '.', '.', '.', '6', '.'],
  ['8', '.', '.', '.', '6', '.', '.', '.', '3'],
  ['4', '.', '.', '8', '.', '3', '.', '.', '1'],
  ['7', '.', '.', '.', '2', '.', '.', '.', '6'],
  ['.', '6', '.', '.', '.', '.', '2', '8', '.'],
  ['.', '.', '.', '4', '1', '9', '.', '.', '5'],
  ['.', '.', '.', '.', '8', '.', '.', '7', '9']
]);
