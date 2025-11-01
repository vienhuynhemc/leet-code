/**
 * @param {number} n
 * @return {number}
 */
var subtractProductAndSum = function (n) {
  let input = n + "";
  let sum = 0;
  let mul = 0;
  for (let i = 0; i < input.length; i++) {
    sum += parseInt(input[i]);
    if (i === 0) {
      mul = parseInt(input[i]);
    } else {
      mul *= parseInt(input[i]);
    }
  }
  return mul - sum;
};

console.log(subtractProductAndSum(234));
console.log(subtractProductAndSum(4421));
