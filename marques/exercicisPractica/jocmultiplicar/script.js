
novaMultiplicacio();
var num1, num2;

function novaMultiplicacio() {
    num1 = getRandomInt(1, 9);
    num2 = getRandomInt(1, 9);

    document.getElementById("multiplicacio").innerHTML = num1 + "x" + num2 + " = ";
    document.getElementById("multiplicacioInput").className = "idle";
    document.getElementById("multiplicacioInput").value = "";

}

function getRandomInt(min, max) {
    min = Math.ceil(min);
    max = Math.floor(max);
    return Math.floor(Math.random() * (max - min) + min);
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
