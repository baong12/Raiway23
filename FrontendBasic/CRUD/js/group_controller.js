var dataTable = document.getElementById("data-table");
var dataTableHeader = dataTable.innerHTML;

$(document).ready(function () {
    getGroups(renderTable);
});

$("#add").click(function () {
    loadDialog("/dialogs/group_add.html");
    open_modal();
});

$("#refresh").click(function () {
    getGroups(renderTable);
});

$("#delete").click(function () {
    deleteData();
});

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
    loadDialog("/dialogs/group_edit.html");
    open_modal();
    // $(document).ready(function () {
        // loadCurGroupData();
    // });
}

function loadCurGroupData() {
    $("#curId").text($(curRow).children(".id").text());
    $("#grName").val($(curRow).children(".groupName").text());
    $("#member").val($(curRow).children(".member").text());
    $("#creator").val($(curRow).children(".creator").text());
    $("#createDate").val($(curRow).children(".createDate").text().replace("Z",""));
}

function renderTable(data) {
    let content = dataTableHeader;
    data.forEach((element) => {
        content += "<tr>" +
            "<td><input type='checkbox' name='select'></td>" +
            "<td class='id'>" + element.id + "</td>" +
            "<td class='groupName'>" + element.groupName + "</td>" +
            "<td class='member'>" + element.member + "</td>" +
            "<td class='creator'>" + element.creator + "</td>" +
            "<td class='createDate'>" + element.createDate + "</td>" +
            "<td><button onclick='openEditGroupDlg(this)'>" +
                "<i class='fa fa-edit fa-fw'></i>" +
            "</button></td>" +
            "</tr>";
    });
    dataTable.innerHTML = content;
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
}

function deleteData() {
    let cells = $("tr > td > :checked");
    let idList = [];
    $(cells).each(function () {
        let id = $(this).parent().siblings(".id").text();
        idList.push(id);
    });
    idList.forEach(groupId => {
        deleteGroup(groupId);
    });
    getGroups(renderTable);
}

function updateData() {
    alert($("#createDate").val());
    // updateGroup({
    //     id: $("#curId").text(),
    //     name: $("#grName").val(),
    //     member: $("#member").val(),
    //     creator: $("#creator").val(),
    //     createDate: $("#createDate").val()
    // });
    // getGroups(renderTable);
    close_modal();
}
