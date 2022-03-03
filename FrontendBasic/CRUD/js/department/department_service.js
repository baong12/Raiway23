var DATA_URL = "http://localhost:8080/api/v1/departments";

function getAllDepartments(renderer) {
    $.ajax({
        async: false,
        url: DATA_URL,
        type: "GET",
        success: (result) => renderer(result)
    });
}

function createDepartment(department) {
    $.ajax({
        async: false,
        url: DATA_URL,
        type: "POST",
        data: JSON.stringify(department),
        contentType: "application/json"
    });
}

function updateDepartment(department) {
    $.ajax({
        async: false,
        url: DATA_URL + "/" + department.id,
        type: "PUT",
        data: JSON.stringify(department),
        contentType: "application/json"
    });
}

function deleteDepartment(id) {
    $.ajax({
        async: false,
        url: DATA_URL + "/" + id,
        type: "DELETE"
    });
}