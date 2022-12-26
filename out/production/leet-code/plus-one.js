/**
 * @param {number[]} digits
 * @return {number[]}
 */
var plusOne = function (digits) {
    let plusToLastValue = digits[digits.length - 1] + 1;
    if (plusToLastValue > 9) {
        digits[digits.length - 1] = plusToLastValue - 9;
        digits.push(plusToLastValue - 10);
    } else {
        digits[digits.length - 1] = plusToLastValue;
    }
    return digits;
};

console.log(plusOne([1, 2, 3]));
console.log(plusOne([4, 3, 2, 1]));
console.log(plusOne([9]));