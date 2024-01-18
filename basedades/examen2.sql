USE EXAMEN2;
#BASE DE DADES FP
#1
ALTER TABLE AVALUA ADD COLUMN descripcio_assistencia VARCHAR(255);


#2
ALTER TABLE AVALUA MODIFY COLUMN nota TINYINT DEFAULT 7 CHECK (nota BETWEEN 0 AND 10);

#3
CREATE TABLE FAMILIES (
    codi int PRIMARY KEY,
    nom VARCHAR(100) UNIQUE NOT NULL
);

#4
ALTER TABLE CICLE ADD COLUMN familia VARCHAR(50) NOT NULL;
ALTER TABLE CICLE ADD FOREIGN KEY (familia) REFERENCES MODUL(cod_mod) ON DELETE CASCADE ON UPDATE CASCADE;


#5
ALTER TABLE CICLE ADD COLUMN nivell ENUM('CFGM', 'CFGS') DEFAULT 'CFGS' NOT NULL;

#6
UPDATE CICLE SET cod_cic = 'CFGS' WHERE cod_cic = 'ICB0';

#7
SELECT anyo, COUNT(codicurs) AS num_courses
FROM realitzaciocurs
GROUP BY anyo;

SELECT anyo FROM realitzaciocurs WHERE COUNT cursos #i want to get the number of cursos of each anyo, 

#8
SELECT P.dni, P.cognom, P.nom
FROM persones P
JOIN profescurs PC ON P.dni = PC.professor
WHERE PC.codicurs = 100;

#9
SELECT
    R.codicurs,
    UPPER(C.nomcurs) AS nomcurs,
    C.durada,
    C.descripcio,
    R.anyo,
    R.numordre,
    CONCAT(P.nom, ' ', P.cognom) AS "Nom Cognom",
    P.nom AS coordinador
FROM
    realitzaciocurs R
JOIN cursos C ON R.codicurs = C.codicurs
JOIN persones P ON R.coordinador = P.dni;


#10
SELECT
    CONCAT(C.nomcurs, ' ', R.anyo, ' ', R.numordre) AS edicio_name,
    C.nomcurs,
    R.anyo,
    MIN(AC.assistencia) AS assistencia_minima,
    MAX(AC.assistencia) AS assistencia_maxima,
    ROUND(AVG(AC.assistencia), 2) AS assistencia_mitjana
FROM
    realitzaciocurs R
JOIN
    cursos C ON R.codicurs = C.codicurs
LEFT JOIN
    alumnescurs AC ON R.codicurs = AC.codicurs AND R.anyo = AC.anyo AND R.numordre = AC.numordre
GROUP BY
    edicio_name, C.nomcurs, R.anyo;

    
#11
SELECT DISTINCT
    P.dni,
    P.nom,
    P.cognom
FROM
    persones P
LEFT JOIN
    profescurs PC ON P.dni = PC.professor
LEFT JOIN
    realitzaciocurs R ON P.dni = R.coordinador
WHERE
    PC.codicurs IS NOT NULL OR R.codicurs IS NOT NULL;

#BASE DE DADES BIBLIOTECA
#12
CREATE VIEW socis_edat AS
SELECT
    CONCAT(nom,' ', cognoms) AS nom_soci_complert,
    EXTRACT(YEAR FROM CURRENT_DATE) - EXTRACT(YEAR FROM data_naix) AS edat
FROM
    soci;

#13
SELECT
    CONCAT(S.nom,' ', S.cognoms)AS nom_soci_complert,
    L.nom AS titol_llibre
FROM
    prestec P
JOIN
    soci S ON P.id_soc = S.id_soc
JOIN
    exemplar E ON P.id_l = E.id_l AND P.num = E.num
JOIN
    llibre L ON E.id_l = L.id_lib
WHERE
    P.data_ret IS NOT NULL;





