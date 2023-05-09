#a)
SELECT Mitarbeiter.Name, Arbeitsvertrag.Gehalt FROM Mitarbeiter
JOIN Arbeitsvertrag ON Mitarbeiter.M-Id = Arbeitsvertrag.M-Id
WHERE Arbeitsvertrag.Gehalt BETWEEN 3500 AND 3800
ORDER BY Arbeitsvertrag.Gehalt ASC;

#b)
SELECT Mitarbeiter.Name, Arbeitsvertrag.Gehalt FROM Mitarbeiter
JOIN Arbeitsvertrag ON Mitarbeiter.M-Id = Arbeitsvertrag.M-Id
WHERE Arbeitsvertrag.Gehalt < AVG(SELECT Gehalt FROM Arbeitsvertrag)

#c)
SELECT Mitarbeiter.Name, Arbeitsvertrag.Funktion, Teilnahme.Projektstunden FROM Mitarbeiter 
JOIN Arbeitsvertrag ON Mitarbeiter.M-Id = Arbeitsvertrag.M-Id 
JOIN Teilnahme ON Mitarbeiter.M-Id = Teilnahme.M-Id 
JOIN Projekt ON Projekt.P-Id = Teilnahme.P-Id 
WHERE Projekt.name = "J-Kis";

#d)
SELECT Mitarbeiter.Name, Teilnahme.Projektstunden FROM Mitarbeiter
JOIN Arbeitsvertrag ON Mitarbeiter.M-Id = Arbeitsvertrag.M-Id 
JOIN Teilnahme ON Mitarbeiter.M-Id = Teilnahme.M-Id 
JOIN Projekt ON Projekt.P-Id = Teilnahme.P-Id
ORDER BY Mitarbeiter.Name

#e)
UPDATE Arbeitsvertrag SET Gehalt = Gehalt * 1.05 
WHERE M-Id = (SELECT M-Id from Teilnahme WHERE P-Id = "3");

#f)
UPDATE Teilnahme SET Projektstunden = 0 
WHERE P-Id = (SELECT P-Id FROM Projekt WHERE Name = "J-Kis")