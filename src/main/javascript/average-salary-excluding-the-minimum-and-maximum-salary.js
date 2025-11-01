/**
 * @param {number[]} salary
 * @return {number}
 */
var average = function (salary) {
  let max = salary[0];
  let min = salary[0];
  for (let i = 0; i < salary.length; i++) {
    if (salary[i] > max) max = salary[i];
    if (salary[i] < min) min = salary[i];
  }
  let sum = 0;
  let count = 0;
  for (let i = 0; i < salary.length; i++) {
    if (salary[i] !== min && salary[i] !== max) {
      sum += salary[i];
      count++;
    }
  }
  return sum / count;
};

console.log(average([4000, 3000, 1000, 2000]));
console.log(average([1000, 2000, 3000]));
