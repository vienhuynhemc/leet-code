/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number}
 */
var findMedianSortedArrays = function (nums1, nums2) {
    let a1 = [];
    let a2 = [];
    if (nums1[0] >= nums2[0]) {
        a1 = nums2;
        a2 = nums1;
    } else {
        a1 = nums1;
        a2 = nums2;
    }
    for (let i = 0; i < a1.length; i++) {
        if (a1[i] == a2[0]) {

            let index = i + 1;
            while (index < a1.length && a1[index] == a1[i]) {
                index++;
            }
            let left = index;

        } else if (a1[i] > a2[0]) {

        }
    }
};

console.log(findMedianSortedArrays([1, 3], [2]));
console.log(findMedianSortedArrays([1, 2], [3, 4]));