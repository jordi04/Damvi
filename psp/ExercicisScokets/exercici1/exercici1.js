// Importem el mòdul ws per crear un servidor webSocket
const http = require('http');
const WebSocket = require('ws');

// Definim el port on escoltarà el servidor
const port = 3000;

// Creem una instància del servidor webSocket
const server = new WebSocket.Server({ port: port });

// Creem un array per guardar els usuaris connectats
let users = [];

// Definim una funció per enviar un missatge a tots els usuaris excepte el que l'envia
function broadcast(message, sender) {
  // Recorrem l'array d'usuaris
  for (let user of users) {
    // Si l'usuari no és el que envia el missatge, li enviem el missatge
    if (user !== sender) {
      user.send(message);
    }
  }
}

// Definim una funció per gestionar les connexions al servidor
function handleConnection(socket) {
  // Afegim el socket a l'array d'usuaris
  users.push(socket);

  // Enviem un missatge de benvinguda al socket
  socket.send('Hello World');

  // Enviem un missatge als altres usuaris informant que un usuari s'ha connectat
  broadcast('Un usuari s\'ha connectat', socket);

  // Definim una funció per gestionar els missatges que rep el socket
  function handleMessage(message) {
    // Podem fer el que vulguem amb el missatge, per exemple, imprimir-lo per consola
    console.log(message);
  }

  // Definim una funció per gestionar les desconnexions del socket
  function handleClose() {
    // Eliminem el socket de l'array d'usuaris
    users = users.filter(user => user !== socket);

    // Enviem un missatge als altres usuaris informant que un usuari s'ha desconnectat
    broadcast('Un usuari s\'ha desconnectat', socket);
  }

  // Registrem els esdeveniments de missatge i tancament del socket
  socket.on('message', handleMessage);
  socket.on('close', handleClose);
}

// Registrem l'esdeveniment de connexió del servidor
server.on('connection', handleConnection);

// Imprimim per consola que el servidor està escoltant
console.log('Servidor webSocket escoltant al port ' + port);
