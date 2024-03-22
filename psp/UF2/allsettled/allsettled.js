function crearPromesa(id) {
    const tempsAleatori = Math.floor(Math.random() * (8 - 4 + 1)) + 4;

    return new Promise((resol, rebutja) => {
        setTimeout(() => {
            const resultat = `Promesa ${id} resolta en ${tempsAleatori} segons`;
            resol(resultat);
        }, tempsAleatori * 1000);
    });
}

async function execucioSeqencial() {
    const resultats = [];

    for (let i = 1; i <= 5; i++) {
        const resultat = await crearPromesa(i);
        resultats.push(resultat);
    }

    console.log("Resultats de l'execució seqüencial:", resultats);
}

async function execucioParalela() {
    const promeses = [];

    for (let i = 1; i <= 5; i++) {
        const promesa = crearPromesa(i);
        promeses.push(promesa);
    }

    const resultats = await Promise.allSettled(promeses);

    console.log("Resultats de l'execució paral·lela:");
    resultats.forEach((resultat, index) => {
        if (resultat.status === "fulfilled") {
            console.log(`Promesa ${index + 1}: ${resultat.value}`);
        } else {
            console.log(`Promesa ${index + 1} ha estat rebutjada amb error: ${resultat.reason}`);
        }
    });
}

//Promeses seqüencialment
execucioSeqencial();

//Promeses paral·lelament
execucioParalela();
