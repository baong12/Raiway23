$(document).ready(function(){
    loadPage('pages/manage.html');
    $("#manage").addClass("w3-blue");
    loadUser();
});

$("nav > div > a").click(function(){
    $("nav > div > a").removeClass("w3-blue");
    $(this).addClass("w3-blue");
});

function loadPage(pageUrl) {
    $("#content").load(pageUrl);
}

function loadUser() {
    $("#user-info").load("user_info.html");
}

function loadDialog(dialogUrl) {
    $("#dialog-content").load(dialogUrl);
}