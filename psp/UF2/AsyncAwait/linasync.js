async function f(){

    let mysql = require("mysql");
    
    const configConnexio = {
    host: "localhost",
    user: "root",
    password: "",
    database: "async_await"
};
    
    connection.connect(function(err){
        if(err){
            throw err;
        }
        else{
            console.log("Conectado");
        }
    });
    
    console.log("1");
    
    console.log("2");

    const categorias = "SELECT * FROM `material`;"
    connection.query(categorias,function(error,lista){
        if(error){
            throw error;
        }
        else{
            console.log(lista);
        }
    })
    
    connection.end();
    }
    
    f();





async function f() {
    let mysql = require("mysql");

    let connection = mysql.createConnection({
        host: "localhost",
        database: "async_await",
        user: "root",
        password: ""
    });

    try {
        await new Promise((resolve, reject) => {
            connection.connect((err) => {
                if (err) {
                    reject(err);
                } else {
                    console.log("Conectado");
                    resolve();
                }
            });
        });

        console.log("1");

        const categorias = "SELECT * FROM `material`;";
        const lista = await new Promise((resolve, reject) => {
            connection.query(categorias, (error, results) => {
                if (error) {
                    reject(error);
                } else {
                    resolve(results);
                }
            });
        });

        console.log(lista);

        console.log("2");

        connection.end();
    } catch (error) {
        console.error("Error:", error);
        connection.end();
    }
}

f();
