/**
 * @param {number} num
 * @return {string}
 */
var intToRoman = function (num) {
  let result = "";
  let nowAccess = "";
  let count = 0;
  let lastCount = 0;
  while (num > 99) {
    num -= 100;
    count++;
    if (count == 1) {
      nowAccess = "C";
      lastCount = 1;
    } else if (count == 4) {
      nowAccess = "CD";
      lastCount = 4;
    } else if (count == 5) {
      nowAccess = "D";
      lastCount = 5;
    } else if (count == 9) {
      nowAccess = "CM";
      lastCount = 9;
    } else if (count == 10) {
      nowAccess = "M";
      lastCount = 10;
    } else if (count == 11) {
      count = 1;
      lastCount = 1;
      result += nowAccess;
      nowAccess = "C";
    }
  }
  count -= lastCount;
  result += nowAccess;
  nowAccess = "";
  for (let i = 0; i < count; i++) {
    result += "C";
  }
  count = 0;
  lastCount = 0;
  while (num > 9) {
    num -= 10;
    count++;
    if (count == 1) {
      nowAccess = "X";
      lastCount = 1;
    } else if (count == 4) {
      nowAccess = "XL";
      lastCount = 4;
    } else if (count == 5) {
      nowAccess = "L";
      lastCount = 5;
    } else if (count == 9) {
      nowAccess = "XC";
      lastCount = 9;
    } else if (count == 10) {
      nowAccess = "C";
      lastCount = 10;
    } else if (count == 11) {
      count = 1;
      lastCount = 1;
      result += nowAccess;
      nowAccess = "X";
    }
  }
  count -= lastCount;
  result += nowAccess;
  nowAccess = "";
  for (let i = 0; i < count; i++) {
    result += "X";
  }
  count = 0;
  lastCount = 0;
  while (num > 0) {
    num -= 1;
    count++;
    if (count == 1) {
      nowAccess = "I";
      lastCount = 1;
    } else if (count == 4) {
      nowAccess = "IV";
      lastCount = 4;
    } else if (count == 5) {
      nowAccess = "V";
      lastCount = 5;
    } else if (count == 9) {
      nowAccess = "IX";
      lastCount = 9;
    } else if (count == 10) {
      nowAccess = "X";
      lastCount = 10;
    } else if (count == 11) {
      lastCount = 1;
      count = 1;
      result += nowAccess;
      nowAccess = "I";
    }
  }
  count -= lastCount;
  result += nowAccess;
  for (let i = 0; i < count; i++) {
    result += "I";
  }
  return result;
};

console.log(intToRoman(3));
console.log(intToRoman(58));
console.log(intToRoman(1994));
console.log(intToRoman(11));
console.log(intToRoman(21));
console.log(intToRoman(40));
console.log(intToRoman(1100));
