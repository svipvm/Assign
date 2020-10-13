function reMenber(value) {
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    memberFrame.src = "userMember.jsp?groupID=" + value;
}
function refresh() {
    parent.window.location.reload();
}
function relogin() {
    parent.window.location.replace("UserReLoginServlet");
}
function modifypw() {
    parent.window.location.replace("userModify.jsp");
}