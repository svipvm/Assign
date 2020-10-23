function login_check() {
    var account_elem = document.getElementById("account");
    var password_elem = document.getElementById("password");
    if(account_elem.value === "") {
        alert("请输入账号！");
        account_elem.focus();
        return false;
    } else if(password_elem.value === "") {
        alert("请输入密码！")
        password_elem.focus();
        return false;
    }
    return true;
}

function userCheckCode() {
    var groupCode = document.getElementById("groupCode");
    if(groupCode.value === "") {
        alert("请输入邀请码！");
        account_elem.focus();
        return false;
    } else if(groupCode.length !== 8){
        alert("请输入8位邀请码！");
        account_elem.focus();
        return false;
    }
    return true;
}