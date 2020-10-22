function reMenber(value) {
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    memberFrame.src = "userMember.jsp?groupID=" + value;
}
function reAdminContent(value) {
    var memberFrame = parent.document.getElementsByName('frame-content')[0];
    memberFrame.src = "adminContent.jsp?taskID=" + value;
    // memberFrame.src = "adminMember.jsp?groupID=" + value;
}
function reAdminMember(value) {
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    // memberFrame.src = "adminContent.jsp?taskID=" + value;
    memberFrame.src = "adminMember.jsp?taskID=" + value;
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
    // window.location.replace("adminContent.jsp?taskID=" + target);
    var memberFrame = parent.document.getElementsByName('frame-member')[0];
    memberFrame.src = "adminMember.jsp?taskID=" + target;
}
function adminTaskHalt(target) {
    window.location.replace("AdminTaskHaltServlet");
    // var taskFrame = parent.document.getElementsByName('frame-task')[0];
    // taskFrame.src = "adminTask.jsp?groupID=" + target;
    // var taskPoint = parent.document.getElementsByClassName("task-state-point")[0];
    // taskPoint.
}
function adminAcceptFile() {
    window.location.replace("AdminAcceptServlet");
}
function adminAddGroup() {
    parent.window.location.replace("adminAddGroup.jsp");
}
function adminAddTask() {
    parent.window.location.replace("adminAddTask.jsp");
}
function adminDelTask(target) {
    window.location.replace("AdminDelTaskServlet");
}
// function adminManager(target) {
//     parent.window.location.replace("adminManager.jsp?groupID=" + target);
// }