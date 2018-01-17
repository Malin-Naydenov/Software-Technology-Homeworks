function solve(number) {
    let result = [];
    for (let i = 1; i <= number; i++) {
        let currNum = i.toString();

        let isPalindrome = true;
        for (let i = 0; i < currNum.length / 2; i++) {
            let left = currNum[i];
            let right = currNum[currNum.length - i - 1];

            if (left !== right) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            result.push(i);
        }
    }
    console.log(result.join(' '));
}

solve(100);