#a)
SELECT m.Name, arb.Gehalt FROM mitarbeiter m
JOIN Arbeitsvertrag arb ON m.M-Id = arb.M-Id
WHERE arb.Gehalt BETWEEN 3500 AND 3800
ORDER BY arb.Gehalt ASC;

#b)
