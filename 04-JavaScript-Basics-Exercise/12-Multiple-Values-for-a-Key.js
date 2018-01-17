function solve(args) {

    let dict = {};

    for (let i = 0; i < args.length - 1; i++) {
        let tokens = args[i].split(" ");

        let key = tokens[0];
        let value = tokens[1];

        if (key in dict) {
            dict[key].push(value);
        } else {
            dict[key] = [];
            dict[key].push(value);
        }
    }

    let filterKey = args[args.length - 1];

    if (filterKey in dict) {
        for (let val of dict[filterKey]) {
            console.log(val);
        }
    }else {
        console.log("None");
    }
}

solve(["key value",
    "key eulav",
    "test tset",
    "key"
])