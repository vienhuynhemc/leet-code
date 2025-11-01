/**
 * @param {string} s
 * @return {number}
 */
var lengthOfLastWord = function (s) {
  s = s.trim();
  while (s.includes('  ')) {
    s = s.replaceAll('  ', ' ');
  }
  let array = s.split(' ');
  return array[array.length - 1].length;
};

console.log(lengthOfLastWord('Hello World'));
console.log(lengthOfLastWord('   fly me   to   the moon  '));
console.log(lengthOfLastWord('luffy is still joyboy'));
