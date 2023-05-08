SELECT * FROM mitarbeiter;

SELECT PersNr, Vorname, Nachname FROM mitarbeiter;

SELECT * FROM mitarbeiter
WHERE Telefon LIKE '069-%';

SELECT Vorname, Nachname FROM mitarbeiter
WHERE Geburtsdatum=(SELECT MIN(Geburtsdatum) FROM mitarbeiter);

SELECT mitarbeiter.Nachname, abteilung.AbtName FROM mitarbeiter
JOIN abteilung ON mitarbeiter.AbtNr=abteilung.AbtNr; 

SELECT Gehalt FROM mitarbeiter
WHERE Vorname='Michael' AND Nachname='Jakob';

UPDATE mitarbeiter 
SET Nachname='Meier'
WHERE PersNr=5;

ALTER TABLE abteilung
ADD Budget INT;

UPDATE abteilung
SET Budget = 300000
WHERE AbtNr = 1;

UPDATE abteilung
SET Budget = 200000
WHERE AbtNr = 2;

UPDATE abteilung
SET Budget = 500000
WHERE AbtNr = 3;

UPDATE abteilung
SET Budget = 50000
WHERE AbtNr = 4;

UPDATE abteilung
SET Budget = 800000
WHERE AbtNr = 5;

ALTER TABLE mitarbeiter
ADD Jahresgehalt DECIMAL;

UPDATE mitarbeiter 
SET Jahresgehalt = mitarbeiter.Gehalt * 12;

SELECT AVG(Jahresgehalt)
FROM mitarbeiter; 

SELECT AVG(Gehalt)
FROM mitarbeiter
GROUP BY AbtNr;

SELECT COUNT(PersNr)
FROM mitarbeiter
GROUP BY AbtNr
ORDER BY AbtNr;

SELECT Nachname, Gehalt FROM mitarbeiter 
WHERE Gehalt > (SELECT AVG(Gehalt) FROM mitarbeiter);

SELECT m.vorname AS "Mitarbeiter",
v.vorname AS "Vorgesetzter"
FROM mitarbeiter m 
LEFT OUTER JOIN mitarbeiter v
ON m.VorgNr = v.PersNr;