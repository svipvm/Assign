function checkModify() {
    var old_password = document.getElementById("old_password");
    var new_password = document.getElementById("new_password");
    var re_password = document.getElementById("re_password");
    if(old_password.value === "") {
        alert("�����뵱ǰ���룡");
        old_password.focus();
        return false;
    } else if(new_password.value === "") {
        alert("�������µ����룡");
        new_password.focus();
        return false;
    } else if(re_password.value === "") {
        alert("������ȷ�����룡");
        re_password.focus();
        return false;
    }
    return true;
}
