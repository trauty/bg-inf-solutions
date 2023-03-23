CREATE TABLE mitarbeiter (
	PersNr INT NOT NULL AUTO_INCREMENT,
	Anrede TEXT NULL DEFAULT NULL,
	Nachname TEXT NULL DEFAULT NULL,
	Vorname TEXT NULL DEFAULT NULL,
	AbtNr INT(11) NULL DEFAULT NULL,
	Geburtsdatum DATE NULL DEFAULT NULL,
	Eintrittsdatum DATE NULL DEFAULT NULL,
	Krankenkasse TEXT NULL DEFAULT NULL,
	Gehalt DECIMAL NULL DEFAULT NULL,
	VorgNr INT(11) NULL DEFAULT NULL,
	Telefon TEXT NULL DEFAULT NULL,
	PRIMARY KEY(PersNr)
);

INSERT INTO mitarbeiter
VALUES(null, 'Herr', 'Jakob', 'Michael', 1, '1982-09-10', '2012-09-10', 'AOK', 2000, 2, '069-45678');
INSERT INTO mitarbeiter
VALUES(null, 'Frau', 'Vogel', 'Melanie', 1, '1979-09-05', '2003-07-18', 'Techniker', 4500, 4, '06151-62479');
INSERT INTO mitarbeiter
VALUES(null, 'Herr', 'Vogel', 'Ernst', 1, '1977-09-19', '2003-07-18', 'Techniker', 2500, 2, NULL);
INSERT INTO mitarbeiter
VALUES(null, 'Herr', 'Peters', 'Steffen', 5, '1960-04-25', '1983-07-18', 'Debeka', 7500, NULL, '069-568341');
INSERT INTO mitarbeiter
VALUES(null, 'Frau', 'Meyer', 'Stefanie', 4, '1967-03-14', '1984-09-15', 'AOK', 3000, 4, '0694-4723894');