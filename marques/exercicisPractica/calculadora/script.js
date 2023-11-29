
function borra() {
    document.getElementById("num1").value = "";
    document.getElementById("num2").value = "";
    document.getElementById("operador").value = "";
}

function calcular() {
    if (num1 * num2 == document.forms[0].multiplicacio.value) {
        document.getElementById("multiplicacioInput").className = "correcte";
        var bodyChange = "";  
        //document.body.innerHTML = bodyChange + "</div>";
    }
    else {
        document.getElementById("multiplicacioInput").className = "incorrecte";
    }
}
function showPasswd() {
    var x = document.getElementById("password");
    if (x.type === "password") {
        x.type = "text";
    } else {
        x.type = "password";
    }
}
