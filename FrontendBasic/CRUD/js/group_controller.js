var dataTable = document.getElementById("data-table");
var dataTableBody = document.getElementById("data-table-body");
var dataTableHeader = dataTable.innerHTML;

/* Bindings ---------------- */

$(document).ready(function () {
    getGroups(renderTable);
});

$("#add").click(function () {
    loadDialog("dialogs/group_add.html");
    open_modal();
});

$("#refresh").click(function () {
    getGroups(renderTable);
});

$("#delete").click(function () {
    deleteData();
});

$("#searchBox").keydown(function (event) {
    let keyCode = event.which;
    if (keyCode == 13) {
        let word = $("#searchBox").val();
        searchData("groupName", word);
    }
});

/* Functions --------------- */

function selectAll() {
    let state = document.getElementById("select-all").checked;
    let all = document.querySelectorAll("tr > td > input");
    all.forEach(element => {
        element.checked = state;
    });
}

var curRow;
function openEditGroupDlg(button) {
    curRow = $(button).parents("tr");
    loadDialog("dialogs/group_edit.html");
    open_modal();
}

function loadCurGroupData() {
    $("#curId").text($(curRow).children(".id").text());
    $("#grName").val($(curRow).children(".groupName").text());
    $("#member").val($(curRow).children(".member").text());
    $("#creator").val($(curRow).children(".creator").text());
    $("#createDate").val($(curRow).children(".createDate").text().replace("Z", ""));
}

function renderTable(data) {
    dataTableBody.innerHTML = "";
    let content = "";
    data.forEach((element) => {
        content += `<tr>
                <td><input type='checkbox' name='select'></td>
                <td class='id'>${element.id}</td>
                <td class='groupName'>${element.groupName}</td>
                <td class='member'>${element.member}</td>
                <td class='creator'>${element.creator}</td>
                <td class='createDate'>${element.createDate.slice(0, 16)}</td>
                <td>
                    <button onclick='openEditGroupDlg(this)'><i class='fa fa-pen fa-fw'></i></button>
                </td>
            </tr>`;
    });
    dataTableBody.innerHTML = content;
}

function postData() {
    data = {
        name: $("#grName").val(),
        creator: "Admin",
        createDate: new Date(Date.now()).toISOString()
    };
    postGroup(data);
    getGroups(renderTable);
    close_modal();
    alertify.success(`Tạo thành công`);
}

function deleteData() {
    let cells = $("tr > td > :checked");
    let deleteList = [];
    $(cells).each(function () {
        let d_id = $(this).parent().siblings(".id").text();
        let d_groupName = $(this).parent().siblings(".groupName").text();
        deleteList.push({
            id: d_id,
            groupName: d_groupName
        });
    });
    deleteList.forEach(group => {
        deleteGroup(group.id);
        alertify.success(`Xóa thành công: ${group.groupName}`);
    });
    document.getElementById("select-all").checked = 0;
    getGroups(renderTable);
}

function updateData() {
    updateGroup({
        id: $("#curId").text(),
        name: $("#grName").val(),
        member: $("#member").val(),
        creator: $("#creator").val(),
        createDate: $("#createDate").val()
    });
    getGroups(renderTable);
    close_modal();
    alertify.success(`Cập nhật thành công`);
}

function searchData(field, word) {
    searchGroup(field, word, renderTable);
}