#a)
SELECT a.anlagen_ID FROM anlagen a
JOIN ertrag e ON a.anlagen_ID = e.anlagen_ID
JOIN sonnenstd s ON a.plz = s.plz
WHERE e.datum = '2007-11-11' AND (s.sonnenstunden * a.maxertrag * 0.8) > e.tagesertrag;

#b)
SELECT anlagen_ID, SUM(tagesertrag) FROM ertrag
WHERE datum BETWEEN '2007-10-01' AND '2007-10-31'
GROUP BY anlagen_ID;

#c)
SELECT e.anlagen_ID FROM ertrag e
JOIN anlage a ON e.anlagen_ID = a.anlagen_ID
WHERE a.plz = '51491' AND e.datum = '2007-11-11' AND e.tagesertrag < SELECT AVG(tagesertrag) FROM ertrag;