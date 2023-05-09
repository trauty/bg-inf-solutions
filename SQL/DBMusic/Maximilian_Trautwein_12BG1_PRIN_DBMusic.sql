#1.1.1

SELECT a.spieldauer, a.aufnahmedatum, s.name FROM aufnahme a
JOIN studio s ON a.sid = s.sid
WHERE a.mid = 4711;

#1.1.2

INSERT INTO musikstück
VALUES(NULL, 'Young at Heart', (SELECT kid FROM künstler WHERE name = 'Bob Dylan'));

#1.1.3

SELECT s.name AS 'Studioname', COUNT(a.aid) AS 'Anzahl Aufnahmen' FROM studio s
JOIN aufnahme a ON s.sid = a.sid
GROUP BY a.sid

#1.1.4

SELECT m.titel, k.name, a.spieldauer FROM aufnahme a
JOIN künstler k ON a.künstler = k.kid
JOIN musikstück m ON a.mid = m.mid
WHERE a.spieldauer > SELECT AVG(spieldauer) FROM aufnahme * 2;