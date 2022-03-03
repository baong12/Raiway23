// var dataTable = document.getElementById("data-table");
// var dataTableBody = document.getElementById("data-table-body");
// var dataTableHeader = dataTable.innerHTML;

/* Bindings ---------------- */

$(document).ready(function () {
    getAllDepartments(renderTable);
    loadDialog("dialogs/department_add_edit.html");
});

$("#add").click(function () {
    $("#dialogTitle").text("Add new Department");
    $("#idLabel").hide();
    $("#depId").text("");
    $("#depName").val("");
    $("#depAddress").val("");
    $("#depCreateDate").val(new Date(Date.now()).toISOString().slice(0, 16));
    $("#depPostBtn").show();
    $("#depUpdateBtn").hide();
    open_modal();
});

$("#refresh").click(function () {
    getAllDepartments(renderTable);
});

$("#delete").click(function () {
    deleteData();
});

/* Functions --------------- */

function selectAll() {
    let state = document.getElementById("select-all").checked;
    let all = document.querySelectorAll("tr > td > input");
    all.forEach(element => {
        element.checked = state;
    });
}

function openEditDlg(button) {
    $("#dialogTitle").text("Edit Department");
    $("#idLable").show();
    let curRow = $(button).parents("tr");
    $("#depId").text($(curRow).children(".id").text());
    $("#depName").val($(curRow).children(".name").text());
    $("#depAddress").val($(curRow).children(".address").text());
    $("#depCreateDate").val($(curRow).children(".createDate").text().replace("Z", ""));
    $("#depPostBtn").hide();
    $("#depUpdateBtn").show();
    open_modal();
}

function renderTable(data) {
    let dataTableBody = document.getElementById("data-table-body");
    dataTableBody.innerHTML = "";
    let content = "";
    data.forEach((element) => {
        content += `<tr>
                <td><input class='checkbox' type='checkbox' name='select'></td>
                <td class='id'>${element.id}</td>
                <td class='name'>${element.name}</td>
                <td class='address'>${element.address}</td>
                <td class='createDate'>${element.createDate.slice(0, 16)}</td>
                <td>
                    <button onclick='openEditDlg(this)'><i class='fa fa-pen fa-fw'></i></button>
                </td>
            </tr>`;
    });
    dataTableBody.innerHTML = content;
}

function postData() {
    let data = {
        name: $("#depName").val(),
        address: $("#depAddress").val(),
        // createDate: $("#depCreateDate").val()
    };
    console.log(data);
    console.log(JSON.stringify(data));
    createDepartment(data);
    getAllDepartments(renderTable);
    close_modal();
    alertify.success(`Tạo thành công`);
}

function deleteData() {
    const cells = $("tr > td > :checked");
    const deleteConfirm = confirm("Are you sure you want to DELETE these items?");
    if (deleteConfirm == false) {
        document.getElementById("select-all").checked = 0;
        return;
    }
    let deleteList = [];
    $(cells).each(function () {
        let d_id = $(this).parent().siblings(".id").text();
        let d_name = $(this).parent().siblings(".name").text();
        deleteList.push({
            id: d_id,
            name: d_name
        });
    });
    deleteList.forEach(department => {
        deleteDepartment(department.id);
        alertify.success(`Xóa thành công: ${department.name}`);
    });
    document.getElementById("select-all").checked = 0;
    getAllDepartments(renderTable);
}

function updateData() {
    let data = {
        id: $("#depId").text(),
        name: $("#depName").val(),
        address: $("#depAddress").val(),
        createDate: $("#depCreateDate").val()
    };
    updateDepartment(data);
    getAllDepartments(renderTable);
    close_modal();
    alertify.success(`Cập nhật thành công`);
}
