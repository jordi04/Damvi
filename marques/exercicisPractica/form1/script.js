
function validar() {
    document.getElementById("title").className = "validat";
    if (document.forms[0].password.value.search(/[A-Z]/) < 0 ||
        document.forms[0].password.value.search(/[0-9]/) < 0 ||
        document.forms[0].password.value.search(/[a-z]/) < 0 ) {
        return false;
    }
    var bodyChange = "<div class='final'> Hola " + document.forms[0].name.value + 
        " <br> benvingut, tranquil,<br> no compartirem la teva contrasenya " +
        document.forms[0].password.value + " pots estar tranquil";

    document.body.innerHTML = bodyChange + "</div>";
    return true;
    
}
function showPasswd() {
    var x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
