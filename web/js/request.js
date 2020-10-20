function reMenber(value) {
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    memberFrame.src = "userMember.jsp?groupID=" + value;
}
function reAdminMenber(value) {
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    memberFrame.src = "adminMember.jsp?groupID=" + value;
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


function reAdminLogin() {
    parent.window.location.replace("AdminReLoginServlet");
}
function adminModifypw() {
    parent.window.location.replace("adminModify.jsp");
}
function adminContentRefresh(target) {
    window.location.replace("adminContent.jsp?taskID=" + target);
}
function adminTaskHalt() {
    window.location.replace("AdminTaskHaltServlet");
}
function adminAcceptFile() {
    window.location.replace("AdminAcceptServlet");
}
function adminAddGroup() {
    parent.window.location.replace("adminAddGroup.jsp");
}
// function adminManager(target) {
//     parent.window.location.replace("adminManager.jsp?groupID=" + target);
// }