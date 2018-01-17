function solve(nums) {
    let negativeCounter = 0;
    for (let i = 0; i < 3; i++) {
        if (nums[i] < 0) {
            negativeCounter++;
        }
    }

    if (negativeCounter % 2 === 0) {
        console.log("Positive");
    } else {
        console.log("Negative");
    }
}

solve([2,3,-1]);