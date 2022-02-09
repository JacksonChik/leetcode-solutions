function nextVersion(oldVer) {
  // const newVer = (parseInt(oldVer.replace(/\./g, '')) + 1)
  // // I was planning to use replaceAll() instead of replace() because regex statements
  // // are hard to read and maintain, but i remembered that replaceAll() isn't supported
  // // by every browser, so it wouldn't work in all cases.
  //   .toString()
  //   .split('')
  //   .join('.');
  const splitted = oldVer.split(".");
  const splittedLastIndex = splitted.length - 1;
  splitted[splittedLastIndex] = (
    parseInt(splitted[splittedLastIndex]) + 1
  ).toString();

  for (let i = splittedLastIndex; i > 0; i--) {
    if (splitted[i] > 9) {
      splitted[i] = (parseInt(splitted[i]) - 10).toString();
      splitted[i - 1] = (parseInt(splitted[i - 1]) + 1).toString();
    }
  }

  const newVer = splitted.join(".");
  return newVer;
}

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
