function solve(args) {

    let dict = {};
    for (let i = 0; i < args.length - 1; i++) {
        let tokens = args[i].split(" ");
        let key = tokens[0];
        let value = tokens[1];

        dict[key] = value;
    }

    let filterKey = args[args.length - 1];

    if (filterKey in dict) {
        console.log(dict[filterKey]);
    } else {
        console.log("None");
    }
}

solve(["key value",
    "key eulav",
    "test tset",
    "key"
])