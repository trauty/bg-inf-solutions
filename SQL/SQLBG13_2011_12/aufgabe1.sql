#b)
SELECT COUNT(Kundennummer) FROM kunden

SELECT AVG(Umsatz) FROM kunden

SELECT SUM(Umsatz) FROM kunden

SELECT MAX(Umsatz) FROM kunden

#c)
SELECT Kundennummer, Firma, Postleitzahl, Ort FROM kunden
WHERE PLZ LIKE '34%'
ORDER BY Firma ASC