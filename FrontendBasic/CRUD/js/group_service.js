var DATA_URL = "https://61ed284cf3011500174d230b.mockapi.io/api/v1/groups";
// var DATA_URL = "/data/groups.json";

function getGroups(renderer) {
    $.ajax({
        async: false,
        url: DATA_URL,
        type: "GET",
        success: (result) => renderer(result)
    });
}

function postGroup(group) {
    $.ajax({
        async: false,
        url: DATA_URL,
        type: "POST",
        data: {
            groupName: group.name,
            creator: group.creator,
            createDate: group.createDate
        },
    });
}

function updateGroup(group) {
    $.ajax({
        async: false,
        url: DATA_URL + "/" + group.id,
        type: "PUT",
        data: {
            groupName: group.name,
            member: group.member,
            // creator: group.creator,
            // createDate: group.createDate
        }
    });
}

function deleteGroup(id) {
    $.ajax({
        async: false,
        url: DATA_URL + "/" + id,
        type: "DELETE"
    });
}

function searchGroup(field, word, renderer) {
    $.ajax({
        async: false,
        url: DATA_URL + "?" + field + "=" + word,
        type: "GET",
        success: (result) => renderer(result)
    });
}