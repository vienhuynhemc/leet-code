/**
 * Forward declaration of guess API.
 * @param {number} num   your guess
 * @return         -1 if num is higher than the picked number
 *                  1 if num is lower than the picked number
 *               otherwise return 0
 * var guess = function(num) {}
 */

/**
 * @param {number} n
 * @return {number}
 */

var guess = function (num) {
  if (num === 6) return 0;
  return num < 6 ? 1 : -1;
};

var guessNumber = function (n) {
  let low = 1;
  let high = n;
  let mid = parseInt((low + high) / 2);
  while (low <= high) {
    let result = guess(mid);
    if (result === 0) return mid;
    else if (result === 1) {
      low = mid + 1;
    } else {
      high = mid - 1;
    }
    mid = parseInt((low + high) / 2);
  }
  return -1;
};

console.log(guessNumber(10));
