function solve(strings) {
    let result = [];

    for (let i = 0; i < strings.length; i++) {
        let words = strings[i].split(/\W+/).filter(w => w.length > 0);

        for (let word of words) {
            if (word === word.toUpperCase()) {
                result.push(word)
            }
        }
    }

    console.log(result.join(', '))
}

solve(['We start by HTML, CSS, JavaScript, JSON and REST.'])