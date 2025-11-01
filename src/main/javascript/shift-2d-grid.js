/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number[][]}
 */
var shiftGrid = function (grid, k) {
  let result = [];
  for (let i = 0; i < grid.length; i++) {
    result[i] = [];
    for (let j = 0; j < grid[i].length; j++) {
      result[i].push(0);
    }
  }
  for (let i = 0; i < grid.length; i++) {
    for (let j = 0; j < grid[i].length; j++) {
      let newI = i;
      let newJ = j;
      let kCopy = k;
      while (kCopy > 0) {
        newJ++;
        if (newJ === grid[i].length) {
          newJ = 0;
          newI++;
          if (newI === grid.length) {
            newI = 0;
          }
        }
        kCopy--;
      }
      result[newI][newJ] = grid[i][j];
    }
  }
  return result;
};

console.log(
  shiftGrid(
    [
      [1, 2, 3],
      [4, 5, 6],
      [7, 8, 9],
    ],
    1,
  ),
);
console.log(
  shiftGrid(
    [
      [3, 8, 1, 9],
      [19, 7, 2, 5],
      [4, 6, 11, 10],
      [12, 0, 21, 13],
    ],
    4,
  ),
);
console.log(
  shiftGrid(
    [
      [1, 2, 3],
      [4, 5, 6],
      [7, 8, 9],
    ],
    9,
  ),
);
