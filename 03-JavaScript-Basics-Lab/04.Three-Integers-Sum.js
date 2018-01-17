function solve(input) {
   let nums = input[0].split(' ').map(Number);

    let firstNum = nums[0];
    let secondNum = nums[1];
    let thirdNum = nums[2];

    if (firstNum + secondNum == thirdNum) {
        console.log(`${Math.min(firstNum, secondNum)} + ${Math.max(firstNum, secondNum)} = ${thirdNum}`)
    } else if (firstNum + thirdNum == secondNum) {
        console.log(`${Math.min(firstNum, thirdNum)} + ${Math.max(firstNum, thirdNum)} = ${secondNum}`)
    } else if (secondNum + thirdNum == firstNum) {
        console.log(`${Math.min(secondNum, thirdNum)} + ${Math.max(secondNum, thirdNum)} = ${firstNum}`)
    } else {
        console.log('No')
    }
}

solve(['8 15 7']);