function nextVersion(oldVer) {
  const splitted = oldVer.split(".");
  // we first remove the dots as delimiters, and split the digits in the version number into a string array, where every element is a digit string
  const splittedLastIndex = splitted.length - 1;
  splitted[splittedLastIndex] = (
    parseInt(splitted[splittedLastIndex]) + 1
  ).toString();
  // when we want to update the old version number to the new version number, we must add 1 to the last digit of the old version number first,
  // and then we check for carry(for the case where the last digit is > 9)

  for (let i = splittedLastIndex; i > 0; i--) {
    // we traverse through the digit array to check for carries (e.g. 9.9.9 + 0.0.1 -> 9.9.10 -> 9.10.0 -> 10.0.0)
    if (splitted[i] > 9) {
      splitted[i] = (parseInt(splitted[i]) - 10).toString();
      splitted[i - 1] = (parseInt(splitted[i - 1]) + 1).toString();
      // since the digits in splitted[] are strings, to do calculations(+1 or -10 when carrying over) we have to first use parseInt and
      // when we are done with the calculations, we use toString to turn them back to String to store in splitted
    }
  }
  const newVer = splitted.join(".");
  // splitted array now stores the digits Strings that are ready to be joined together by dots
  return newVer;
}

// A side note: my old implementation is:
// const newVer = (parseInt(oldVer.replace(/\./g, '')) + 1)
//   .toString()
//   .split('')
//   .join('.');
// which is much more elegant, but the first element of the version number can consist of > 1 digits(see test case 5), which sadly renders this solution useless

//Given test cases:
const testCase1 = "1.2.3";
const testCase1Ans = "1.2.4";
const testCase2 = "0.9.9";
const testCase2Ans = "1.0.0";
const testCase3 = "1";
const testCase3Ans = "2";
const testCase4 = "1.2.3.4.5.6.7.8";
const testCase4Ans = "1.2.3.4.5.6.7.9";
const testCase5 = "9.9";
const testCase5Ans = "10.0";

//Additional test cases:
const addTestCase1 = "999999.9";
const addTestCase1Ans = "1000000.0";
const addTestCase2 = "0";
const addTestCase2Ans = "1";
const addTestCase3 = "9.9.9.9";
const addTestCase3Ans = "10.0.0.0";
const addTestCase4 = "0.0.0";
const addTestCase4Ans = "0.0.1";
const addTestCase5 = "9.0.0.9";
const addTestCase5Ans = "9.0.1.0";

console.log("test 1:", nextVersion(testCase1) === testCase1Ans);
console.log("test 2:", nextVersion(testCase2) === testCase2Ans);
console.log("test 3:", nextVersion(testCase3) === testCase3Ans);
console.log("test 4:", nextVersion(testCase4) === testCase4Ans);
console.log("test 5:", nextVersion(testCase5) === testCase5Ans);

console.log(
  "additional test 1:",
  nextVersion(addTestCase1) === addTestCase1Ans
);
console.log(
  "additional test 2:",
  nextVersion(addTestCase2) === addTestCase2Ans
);
console.log(
  "additional test 3:",
  nextVersion(addTestCase3) === addTestCase3Ans
);
console.log(
  "additional test 4:",
  nextVersion(addTestCase4) === addTestCase4Ans
);
console.log(
  "additional test 5:",
  nextVersion(addTestCase5) === addTestCase5Ans
);
