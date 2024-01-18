const mysql = require("mysql");

const connection = mysql.createConnection({
    host: "localhost",
    user: "root",
    password: "",
    database: "async_await" // Make sure to use the correct database name
});

console.log("1");

// Asynchronous database query using callbacks
function fetchDataAsync(callback) {
    const query = "SELECT * FROM material";
    connection.query(query, function (error, result) {
        if (error) {
            throw error;
        }

        callback(result);
    });
}

fetchDataAsync(function (data) {
    console.log("2");
    console.log(data);

    // Synchronous database query using async/await
    async function fetchDataSync() {
        const query = "SELECT * FROM material";

        try {
            const result = await queryAsync(query);
            console.log(result);
        } catch (error) {
            throw error;
        } finally {
            console.log("3");
            connection.end();
        }
    }

    function queryAsync(query) {
        return new Promise((resolve, reject) => {
            connection.query(query, function (error, result) {
                if (error) {
                    reject(error);
                } else {
                    resolve(result);
                }
            });
        });
    }

    fetchDataSync();
});
