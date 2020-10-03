function login_check() {
    var username_elem = document.getElementById("username");
    var password_elem = document.getElementById("password");
    if(username_elem.value === "") {
        alert("请输入账号！");
        username_elem.focus();
        return false;
    } else if(password_elem.value === "") {
        alert("请输入密码！")
        password_elem.focus();
        return false;
    }
    return true;
}