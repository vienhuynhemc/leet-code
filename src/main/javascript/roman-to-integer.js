/**
 * @param {string} s
 * @return {number}
 */
var romanToInt = function (s) {
  let result = 0;
  for (let i = 0; i < s.length; i++) {
    let process = false;
    if (i + 1 < s.length) {
      if (s[i] === 'I') {
        if (s[i + 1] === 'V') {
          result += 4;
          i++;
          process = true;
        } else if (s[i + 1] === 'X') {
          result += 9;
          i++;
          process = true;
        }
      } else if (s[i] === 'X') {
        if (s[i + 1] === 'L') {
          result += 40;
          i++;
          process = true;
        } else if (s[i + 1] === 'C') {
          result += 90;
          i++;
          process = true;
        }
      } else if (s[i] === 'C') {
        if (s[i + 1] === 'D') {
          result += 400;
          i++;
          process = true;
        } else if (s[i + 1] === 'M') {
          result += 900;
          i++;
          process = true;
        }
      }
    }
    if (!process) {
      if (s[i] === 'I') {
        result += 1;
      } else if (s[i] === 'V') {
        result += 5;
      } else if (s[i] === 'X') {
        result += 10;
      } else if (s[i] === 'L') {
        result += 50;
      } else if (s[i] === 'C') {
        result += 100;
      } else if (s[i] === 'D') {
        result += 500;
      } else if (s[i] === 'M') {
        result += 1000;
      }
    }
  }
  return result;
};

console.log(romanToInt('III'));
console.log(romanToInt('LVIII'));
console.log(romanToInt('MCMXCIV'));
