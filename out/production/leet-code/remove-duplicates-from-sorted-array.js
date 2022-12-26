/**
 * @param {number[]} nums
 * @return {number}
 */
var removeDuplicates = function (nums) {
    let array = [];
    let now = null;
    for (let i = 0; i < nums.length; i++) {
        if (nums[i] !== now) {
            now = nums[i];
            array.push(nums[i]);
        }
    }
    let k = array.length;
    while (k > 0) {
        nums.shift();
        k--;
    }
    for (let i = array.length - 1; i >= 0; i--) {
        nums.unshift(array[i]);
    }
    return array.length;
};

console.log(removeDuplicates([1, 1, 2]));
console.log(removeDuplicates([0, 0, 1, 1, 1, 2, 2, 3, 3, 4]));
