function sovle(lines) {
    let student = {};

    let name = lines[0].split(" -> ")[1];
    let surname = lines[1].split(" -> ")[1];
    let age = Number(lines[2].split(" -> ")[1]);
    let grade = Number(lines[3].split(" -> ")[1]);
    let date = lines[4].split(" -> ")[1];
    let town = lines[5].split(" -> ")[1];

    student.name = name;
    student.surname = surname;
    student.age = age;
    student.grade = grade;
    student.date = date;
    student.town = town;

    let result = JSON.stringify(student)
    console.log(result);
}