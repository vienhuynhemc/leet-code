/**
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function (haystack, needle) {
  let isStart = false;
  let count = 0;
  let index = -1;
  let i = 0;
  while (i < haystack.length) {
    if (!isStart) {
      if (haystack[i] == needle[count]) {
        isStart = true;
        index = i;
        count++;
        if (count == needle.length) {
          return index;
        }
      }
    } else {
      if (haystack[i] == needle[count]) {
        count++;
        if (count == needle.length) {
          return index;
        }
      } else {
        i = i - count;
        count = 0;
        isStart = false;
      }
    }
    i++;
  }
  if (count < needle.length) return -1;
  return index;
};

console.log(strStr("hello", "ll"));
console.log(strStr("aaaaa", "bba"));
console.log(strStr("aaaa", "aaaaa"));
console.log(strStr("mississippi", "issip"));
