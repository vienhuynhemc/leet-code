/**
 * @param {number} x
 * @return {boolean}
 */
var isPalindrome = function (x) {
  let s = x + "";
  if (s.length === 1) return true;
  if (x < 0) return false;
  let s2 = "";
  for (let i = s.length - 1; i >= 0; i--) {
    s2 += s[i];
  }
  return s2 === s;
};

console.log(isPalindrome(121));
console.log(isPalindrome(-121));
console.log(isPalindrome(10));
