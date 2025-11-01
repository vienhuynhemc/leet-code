/**
 * @param {string} s
 * @param {number} numRows
 * @return {string}
 */
var convert = function (s, numRows) {
  if (numRows > s.length) return s;
  let result = "";
  let space = getSpace(numRows);
  let index = 0;
  for (let i = 0; i < numRows; i++) {
    let j = index;
    let help = space;
    let isMinus = false;
    let helpMinus1 = -1;
    let helpMinus2 = -1;
    while (true) {
      result += s[j];
      if (i !== 0 && i !== numRows - 1) {
        if (helpMinus1 === -1) {
          helpMinus1 = getSpace(numRows - i);
          helpMinus2 = space - helpMinus1;
        }
        if (!isMinus) {
          help = helpMinus1;
          isMinus = true;
        } else {
          help = helpMinus2;
          isMinus = false;
        }
      }
      j += help;
      if (j > s.length - 1) break;
    }
    index++;
  }
  return result;
};

function getSpace(numRows) {
  if (numRows === 1) return 1;
  return (numRows - 1) * 2;
}

console.log(convert("PAYPALISHIRING", 3));
console.log(convert("PAYPALISHIRING", 4));
console.log(convert("A", 1));
