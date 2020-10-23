function checkModify() {
    var old_password = document.getElementById("old_password");
    var new_password = document.getElementById("new_password");
    var re_password = document.getElementById("re_password");
    if(old_password.value === "") {
        alert("请输入当前密码！");
        old_password.focus();
        return false;
    } else if(new_password.value === "") {
        alert("请输入新的密码！");
        new_password.focus();
        return false;
    } else if(re_password.value === "") {
        alert("请输入确认密码！");
        re_password.focus();
        return false;
    }
    return true;
}
