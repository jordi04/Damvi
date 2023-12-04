var matrix = [
    [0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0],
    [0,0,0,0,0,0,0]
];
console.log(matrix);
var player1_wins = 0;
var player2_wins = 0;
var player1_turn = true;
var player1_username = "Yellow";
var player2_username = "Red";

function registerUsers() {
    var player1_username = document.getElementById('input_id').value;
    document.getElementById('alert').innerHTML = 'The user input is: ' + player1_username;
    document.getElementById("turn").innerHTML = player1_username + "'s Turn"; 
    document.getElementById("player1_wins").innerHTML = player1_username + " wins: " + player1_wins;
    document.getElementById("player2_wins").innerHTML = player2_username + " wins: " + player2_wins;
}
function check_win() {
    const ROWS = 6;
    const COLUMNS = 7;
    var count = 0;
    //CONTROLA SI ES GUANYA AMB LES HORITZONTALS
    for(let i=0; i < ROWS; i++) {
	    for(let j=0; j < COLUMNS; j++) {
            try {
                if (matrix[i][j] != 0 && matrix[i][j] == matrix[i][j+1] && matrix[i][j+1] == matrix[i][j+2] && matrix[i][j+2] == matrix[i][j+3]) {
                    var idButton = "button" + i + j;
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + i + j;
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + i + j;
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + i + j;
                    document.getElementById(idButton).className = 'wining_combination';
                    return 1;
                }
            } catch(error) {
                console.error(error);
            }
            
        }
    }
    //CONTROLA SI ES GUANYA AMB LES VERTICALS
    count = 0;
    for(let i=0; i < COLUMNS; i++) {
	    for(let j=0; j < ROWS; j++) {
            try{
                if (matrix[j][i] != 0 && matrix[j][i] == matrix[j+1][i] && matrix[j+1][i] == matrix[j+2][i] && matrix[j+2][i] == matrix[j+3][i]) {
                    var idButton = "button" + j + i;
                    //console.log("ID BUTTON bad"+idButton);
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + j + i;
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + j + i;
                    document.getElementById(idButton).className = 'wining_combination';
                    j++;
                    idButton = "button" + j + i;
                    document.getElementById(idButton).className = 'wining_combination';
                    return 1;
                }
            } catch(error) {
                console.error(error);

            }
            
        }
    }
    //CONTROLA SI ES GUANYA AMB LES DIAGONALS
    //Diagonal (bottom-left to top-right) check
    count = 0;
    for(let i=0; i < ROWS-3; i++) {
	    for(let j=0; j < COLUMNS-3; j++) {
            if (matrix[i][j] != 0 && matrix[i][j] == matrix[i+1][j+1] && matrix[i+1][j+1] == matrix[i+2][j+2] && matrix[i+2][j+2] == matrix[i+3][j+3]) {
                var idButton = "button" + i + j;
                //console.log(idButton);
                document.getElementById(idButton).className = 'wining_combination';
                i++;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                i++;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                i++;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                return 1;
            }
        }   
    }
    //Diagonal (top-left to bottom-right) check
    for(let i=3; i < ROWS; i++) {
	    for(let j=0; j < COLUMNS-3; j++) {
            if (matrix[i][j] != 0 && matrix[i][j] == matrix[i-1][j+1] && matrix[i-1][j+1] == matrix[i-2][j+2] && matrix[i-2][j+2] == matrix[i-3][j+3]) {
                var idButton = "button" + i + j;
                //console.log(idButton);
                document.getElementById(idButton).className = 'wining_combination';
                i--;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                i--;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                i--;
                j++;
                idButton = "button" + i + j;
                document.getElementById(idButton).className = 'wining_combination';
                return 1;
            }
        }   
    }
    //REVISAR SI HI HA EMPAT
    var aux_count = 0;

    for(let i=0; i < matrix.length; i++) {
        aux_count = 0;
	    for(let j=0; j < matrix.length; j++) {
            if (matrix[i][j] == 0) {
                return 0;
            }
        }
    } //SI NO TROBA CAP 0, EL CODI SEGUEIX I ESCRIU QUE ÉS UN EMPAT
    document.getElementById("title").innerHTML = "It's a Draw!!";
    document.getElementById("turn").innerHTML = "";
    return 0;
}
function buttons(b, id) { //REGISTRA A LA MATRIU QUAN ES PREM UN BOTÓ I CANIVEN DE COLOR AL COLOR CORRESPONENT
    document.getElementById("player1_wins").innerHTML = player1_username + " wins: " + player1_wins;
    document.getElementById("player2_wins").innerHTML = player2_username + " wins: " + player2_wins;
    if (!check_win()) { //COMPROVA SI JA HA GUANYAT ALGÚ
        document.getElementById("title").innerHTML = "Good Luck!";
        var j = 0;
        var done = false;
        while (!done) {  //ES REPETEIX FINS QUE EL TORN NO HAGI FINALITZAT
            if (matrix[j][b] == 0) { //SI LA CASSELLA SELECCIONADA ÉS BUIDA SEGUEIX AMB EL CODI, SI NO HO ÉS TORNA A COMENCÇAR EL WHILE SUMANT 1 A J 
                                     //AIXÍ ITERAM PER TOTES LES CASELLES DE CADA COLUMNA COMENÇANT DESDE LA MÉS ANTERIOR
                if (player1_turn) {
                    var idButton = "button" + j + b;
                    matrix[j][b] = 1; //ASSIGNA AQUESTA CASELLA AL JUGADOR 1
                    document.getElementById(idButton).className = 'player1';
                    document.getElementById("turn").innerHTML = player2_username + "'s Turn";
                    done = true;
                    player1_turn = false;
                }
                else {
                    var idButton = "button" + j + b;
                    matrix[j][b] = 2; //ASSIGNA AQUESTA CASELLA AL JUGADOR 2
                    document.getElementById(idButton).className = 'player2';
                    document.getElementById("turn").innerHTML = player1_username + "'s Turn";
                    done = true;
                    player1_turn = true;
                }
            }
            j++;
        }
        if (check_win()) { //DECIDEIX QUI HA GUNAYAT DEPENENT DEL TORN 
            if (player1_turn) {
                document.getElementById("title").innerHTML = player2_username + " Won!!";
                document.getElementById("turn").innerHTML = "";
                player2_wins++
                document.getElementById("player2_wins").innerHTML = player2_username + " wins: " + player2_wins;
            }
            else {
                document.getElementById("title").innerHTML = player1_username + " Won!!";
                document.getElementById("turn").innerHTML = "";
                player1_wins++;
                document.getElementById("player1_wins").innerHTML = player1_username + " wins: " + player1_wins;
            }
        }
    }
}
function removeColor(i, j) {
    document.getElementById('button' + i + j).className = 'no_player';
}
function restart() { //FUNCIÓ QUE BUIDA LA MATRIU I RESTABLEIX TOT ELS ELEMENTS PER COMEMÇAR UNA NOVA PARTIDA
    matrix = [
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0],
        [0,0,0,0,0,0,0]
    ];
    
    
    
    for (let i = 5; i >= 0; i--) {
        for (let j = 0; j < 7; ++j) {
            setTimeout(function (i, j) {
                removeColor(i, j);
            }, 30 * (5 - i), i, j);
        }
    }    
    player1_turn = true;
    document.getElementById("title").innerHTML = "Play again!";
    document.getElementById("turn").innerHTML = player1_username +  "'s turn";
}