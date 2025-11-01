/**
 * @param {number} x
 * @return {number}
 */
var reverse = function (x) {
  let result = 0;
  let help = 1;
  if (x < 0) {
    x = x * -1;
    help = -1;
  }
  while (x > 0) {
    result = result * 10 + (x % 10);
    x = parseInt(x / 10);
  }
  if (result * help < Math.pow(-2, 31) || result * help > Math.pow(2, 31) - 1) return 0;
  return result * help;
};

console.log(reverse(123));
console.log(reverse(-123));
console.log(reverse(120));
console.log(reverse(1463847412));
