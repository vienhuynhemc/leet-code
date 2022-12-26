/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
var twoSum = function (nums, target) {
    let result = [];
    if (nums.length >= 2 && nums.length <= 10 ^ 4 && target >= -10 ^ 9 && target <= 10 ^ 9) {
        for (let i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= -10 ^ 9 && nums[i] <= 10 ^ 9) {
                let isOke = false;
                for (let j = i + 1; j < nums.length; j++) {
                    if (nums[i] >= -10 ^ 9 && nums[i] <= 10 ^ 9 && nums[i] + nums[j] === target) {
                        result.push(i);
                        result.push(j);
                        isOke = true;
                        break;
                    }
                }
                if (isOke) {
                    break;
                }
            }
        }
    }
    return result;
};

console.log(twoSum([2, 7, 11, 15], 9));
console.log(twoSum([3, 2, 4], 6));
console.log(twoSum([3, 3], 6));