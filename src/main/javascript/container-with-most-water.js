/**
 * @param {number[]} height
 * @return {number}
 */
var maxArea = function (height) {
    let max = 0;
    let i = 0;
    let j = height.length - 1;
    while (i < j) {
        let now = 0;
        if (height[i] < height[j]) {
            now = height[i] * (j - i);
            i++;
        } else {
            now = height[j] * (j - i);
            j--;
        }
        if (now > max) {
            max = now;
        }
    }
    return max;
};

console.log(maxArea([1, 8, 6, 2, 5, 4, 8, 3, 7]));
console.log(maxArea([1, 1]));
