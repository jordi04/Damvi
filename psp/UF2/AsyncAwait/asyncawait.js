const mysql = require("mysql");

const configConnexio = {
    host: "localhost",
    user: "root",
    password: "",
    database: "async_await"
};

const consultaCreacioTaula = `
    CREATE TABLE IF NOT EXISTS la_vostra_taula (
        id INT AUTO_INCREMENT PRIMARY KEY,
        nom VARCHAR(255),
        descripcio TEXT
    );
`;

function peticioAsincrona(callback) {
    const connexio = mysql.createConnection(configConnexio);

    console.log("1");

    connexio.connect((err) => {
        if (err) {
            callback(err, null);
            return;
        }

        const consulta = "SELECT * FROM la_vostra_taula;";
        connexio.query(consulta, (error, resultats) => {
            connexio.end();
            console.log("2");
            if (error) {
                callback(error, null);
            } else {
                callback(null, resultats);
            }
        });
    });
}

async function peticioSincrona() {
    const connexio = mysql.createConnection(configConnexio);

    console.log("1");

    try {
        await new Promise((resol, rebutja) => {
            connexio.connect((err) => {
                if (err) {
                    rebutja(err);
                } else {
                    console.log("Connectat");
                    resol();
                }
            });
        });

        const consulta = "SELECT * FROM la_vostra_taula;";
        const resultats = await new Promise((resol, rebutja) => {
            connexio.query(consulta, (error, dades) => {
                connexio.end();
                console.log("Dades de la sincrona:", dades);
                if (error) {
                    rebutja(error);
                } else {
                    resol(dades);
                }
            });
        });

        console.log("2");

        return resultats;
    } catch (error) {
        console.error("Error:", error);
        return null;
    }
}

const connexioCreacioTaula = mysql.createConnection(configConnexio);

connexioCreacioTaula.connect((err) => {
    if (err) {
        console.error("Error de connexió:", err);
        return;
    }

    console.log("Connectat a la base de dades per a la creació de la taula");

    connexioCreacioTaula.query(consultaCreacioTaula, (error) => {
        if (error) {
            console.error("Error en la creació de la taula:", error);
        } else {
            console.log("Taula creada amb èxit");

            connexioCreacioTaula.end();

            peticioAsincrona((error, dades) => {
                if (error) {
                    console.error("Error en la petició asíncrona:", error);
                } else {
                    console.log("Dades de la petició asíncrona:", dades);
                }

                peticioSincrona();
            });
        }
    });
});
