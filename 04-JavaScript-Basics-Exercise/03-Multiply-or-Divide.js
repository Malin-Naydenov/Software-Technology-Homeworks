function solve(nums) {
    if (nums[1] >= nums[0]) {
        console.log(nums[0] * nums[1]);
    } else {
        console.log(nums[0] / nums[1]);
    }
}

solve([2, 3]);