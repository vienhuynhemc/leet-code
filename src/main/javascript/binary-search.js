/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function (nums, target) {
    let first = 0;
    let last = nums.length - 1;
    let mid = parseInt((first + last) / 2);
    while (first <= last) {
        if (nums[mid] < target) {
            first = mid + 1;
        } else if (nums[mid] === target) {
            return mid;
        } else {
            last = mid - 1;
        }
        mid = parseInt((first + last) / 2);
    }
    return -1;
};

console.log(search([-1, 0, 3, 5, 9, 12], 9));
console.log(search([-1, 0, 3, 5, 9, 12], 2));
