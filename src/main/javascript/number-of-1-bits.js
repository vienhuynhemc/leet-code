/**
 * @param {number} n - a positive integer
 * @return {number}
 */
var hammingWeight = function (n) {
    let input = n.toString(2);
    let count = 0;
    for (let i = 0; i < input.length; i++) {
        if (input[i] === "1") {
            count++;
        }
    }
    return count;
};

console.log(hammingWeight(00000000000000000000000000001011));
console.log(hammingWeight(00000000000000000000000010000000));
console.log(hammingWeight(11111111111111111111111111111101));
