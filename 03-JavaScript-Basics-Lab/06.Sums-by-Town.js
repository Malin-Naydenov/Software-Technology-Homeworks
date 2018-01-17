function solve(lines) {
    let towns = lines.map(JSON.parse);
    let townsSum = {};

    for (let town of towns) {
        if (town.town in townsSum) {
            townsSum[town.town] += town.income;
        } else {
            townsSum[town.town] = town.income;
        }
    }

    let sortedTowns = Object.keys(townsSum).sort();

    for (let town of sortedTowns) {
        console.log(`${town} -> ${townsSum[town]}`);
    }
}