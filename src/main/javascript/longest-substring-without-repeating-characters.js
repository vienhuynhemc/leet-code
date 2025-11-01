/**
 * @param {string} s
 * @return {number}
 */

function isExistsInArray(array, value) {
  for (let i = 0; i < array.length; i++) {
    if (array[i] === value) {
      return true;
    }
  }
  return false;
}

function getSubStringGoodForMySelf(array, value) {
  let index = 0;
  for (let i = 0; i < array.length; i++) {
    if (array[i] === value) {
      index = i + 1;
      break;
    }
  }
  let result = "";
  for (let i = index; i < array.length; i++) {
    result += array[i];
  }
  return result;
}

var lengthOfLongestSubstring = function (s) {
  let array = [];
  let arraySubstring = [];
  for (let i = 0; i < s.length; i++) {
    if (isExistsInArray(array, s[i])) {
      arraySubstring.push(array);
      let subStringGoodForMySelf = getSubStringGoodForMySelf(array, s[i]);
      array = [];
      for (let i = 0; i < subStringGoodForMySelf.length; i++) {
        array.push(subStringGoodForMySelf[i]);
      }
    }
    array.push(s[i]);
  }
  arraySubstring.push(array);
  let result = 0;
  arraySubstring.forEach((element) => {
    if (element.length > result) {
      result = element.length;
    }
  });
  return result;
};

console.log(lengthOfLongestSubstring("abcabcbb"));
console.log(lengthOfLongestSubstring("bbbbb"));
console.log(lengthOfLongestSubstring("pwwkew"));
console.log(lengthOfLongestSubstring("dvdf"));
