#a)
SELECT Ferienhaus_ID FROM mietvertrag
WHERE tage = (SELECT MAX(tage) FROM mietvertrag)

#b)
SELECT k.Name FROM kunde k
JOIN mietvertrag m ON k.Kunde_ID = m.Kunde_ID
WHERE k.Kunde_ID != m.Kunde_ID AND YEAR(m.Beginn) != YEAR(GETDATE())

#c)
SELECT ferien.Ferienhaus_ID, COUNT(mie.Mietvertrag_ID) AS 'Anzahl Buchungen', COUNT(mae.Maengelanzeige_ID) AS 'Anzahl Mängel', COUNT(mae.Mangelanzeige_ID) / COUNT(mie.Mietvertrag_ID) AS Maengelquote FROM ferienhaus ferien
LEFT JOIN mietvertrag mie ON ferien.Ferienhaus_ID = mie.Ferienhaus_ID
LEFT JOIN maengelanzeige mae ON mie.Ferienhaus_ID = mae.Ferienhaus_ID
GROUP BY ferien.Ferienhaus_ID
ORDER BY Maengelquote ASC;

#d)
SELECT f.Ferienhaus_ID FROM ferienhaus f
JOIN mietvertrag m ON f.Ferienhaus_ID = m.Ferienhaus_ID
ORDER BY m.Tage DESC;

#e)
SELECT f.Ferienhaus_ID FROM ferienhaus f
JOIN mietvertrag m ON f.Ferienhaus_ID = m.Ferienhaus_ID
WHERE m.Tage < (SELECT AVG(Tage) FROM mietvertrag)
ORDER BY m.Tage DESC;