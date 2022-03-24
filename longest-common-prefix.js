/**
 * @param {string[]} strs
 * @return {string}
 */
var longestCommonPrefix = function (strs) {
  if (strs.length == 0) return "";
  if (strs.length == 1) return strs[0];
  let length = 1;
  if (strs[0].length < length) return "";
  let now = "";
  while (true) {
    let prefix = strs[0].substring(0, length);
    for (let i = 1; i < strs.length; i++) {
      if (strs[i].length < length || strs[i].substring(0, length) != prefix) {
        return now;
      }
    }
    now = prefix;
    length++;
  }
};

console.log(longestCommonPrefix(["flower", "flow", "flight"]));
console.log(longestCommonPrefix(["dog", "racecar", "car"]));
console.log(longestCommonPrefix(["a"]));
