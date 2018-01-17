function sumNumbers() {
    let firstNumAsString = document.getElementById('num1').value;
    let secondNumAsString = document.getElementById('num2').value;

    let sum = Number(firstNumAsString) + Number(secondNumAsString);
    document.getElementById('result').innerHTML = sum;
}