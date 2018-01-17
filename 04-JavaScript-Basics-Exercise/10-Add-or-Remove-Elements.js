function solve(args) {
    let arr = [];

    for (let i = 0; i < args.length; i++) {
        let tokens = args[i].split(" ");

        let cmd = tokens[0];

        if (cmd === "add") {
            let num = Number(tokens[1]);
            arr.push(num);
        } else {
            let index = Number(tokens[1]);
            arr.splice(index, 1);
        }
    }

    for (let num of arr) {
        console.log(num);
    }
}

solve(["add 3", "add 5", "add 7", "remove 1"]);