/**
 * @param {number[]} stones
 * @return {number}
 */
var lastStoneWeight = function (stones) {
  while (stones.length > 1) {
    let max = -1;
    let indexOfMax = -1;
    for (let i = 0; i < stones.length; i++) {
      if (stones[i] > max) {
        max = stones[i];
        indexOfMax = i;
      }
    }
    let lessThanMax = -1;
    let indexOfLessThanMax = -1;
    for (let i = 0; i < stones.length; i++) {
      if (stones[i] <= max && stones[i] > lessThanMax && i != indexOfMax) {
        lessThanMax = stones[i];
        indexOfLessThanMax = i;
      }
    }
    if (max == lessThanMax) {
      if (indexOfMax > indexOfLessThanMax) {
        stones.splice(indexOfMax, 1);
        stones.splice(indexOfLessThanMax, 1);
      } else {
        stones.splice(indexOfLessThanMax, 1);
        stones.splice(indexOfMax, 1);
      }
    } else {
      stones[indexOfMax] = stones[indexOfMax] - stones[indexOfLessThanMax];
      stones.splice(indexOfLessThanMax, 1);
    }
  }
  if (stones.length == 0) return 0;
  return stones[0];
};

console.log(lastStoneWeight([2, 7, 4, 1, 8, 1]));
console.log(lastStoneWeight([1]));
