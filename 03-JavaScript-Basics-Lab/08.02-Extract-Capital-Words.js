function solve(lines) {
    let capitalWords = lines.join(' ')
        .split(/\W+/)
        .filter(w => w.length > 0)
        .filter(w=> w=== w.toUpperCase());

    console.log(capitalWords.join(', '));
}

solve(['We start by HTML, CSS, JavaScript, JSON and REST.'])