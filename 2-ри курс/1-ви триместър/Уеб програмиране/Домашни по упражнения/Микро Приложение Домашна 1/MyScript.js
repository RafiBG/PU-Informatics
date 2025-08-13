document.addEventListener("DOMContentLoaded", function () {
    const student = document.getElementById("student");
    const sortedStudentName = document.getElementById("sortName");
    const sortedStudentInfoNumber = document.getElementById("sortNumber");
    const studentData = [];

    student.addEventListener("submit", function (event) {
        event.preventDefault();

        const facultyNumber = document.getElementById("facultyNumber").value;
        const firstName = document.getElementById("firstName").value;
        const lastName = document.getElementById("lastName").value;
        const email = document.getElementById("email").value;
        const phoneNumber = document.getElementById("phoneNumber").value;

        const fullName = `${firstName} ${lastName}`;
        const studentInfo = {facultyNumber, fullName, email, phoneNumber};

        studentData.push(studentInfo);
        const sortedByName = [...studentData].sort((a, b) => a.fullName.localeCompare(b.fullName));
        updateList(sortedStudentName, sortedByName);
        const sortedByFacultyNumber = [...studentData].sort((a, b) => a.facultyNumber.localeCompare(b.facultyNumber));
        updateList(sortedStudentInfoNumber, sortedByFacultyNumber);

        student.reset();
    });

    function updateList(listElement, data) {
        listElement.innerHTML = '';
        data.forEach((student) => {
            const listItem = document.createElement('li');
            listItem.textContent = listElement === sortedStudentName
                ? `Name: ${student.fullName}, Faculty Number: ${student.facultyNumber}, 
                Email: ${student.email}, Phone Number: ${student.phoneNumber}`
                : `Faculty Number: ${student.facultyNumber}, Name: ${student.fullName},
                 Email: ${student.email}, Phone Number: ${student.phoneNumber}`;
            listElement.appendChild(listItem);
        });
    }
});