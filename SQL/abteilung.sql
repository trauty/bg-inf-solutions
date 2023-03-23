CREATE TABLE abteilung (
	AbtNr INT NOT NULL AUTO_INCREMENT,
	AbtName TEXT NULL DEFAULT NULL,
	PRIMARY KEY(AbtNr)
);

INSERT INTO abteilung
VALUES(NULL, 'Forschung und Entwicklung');
INSERT INTO abteilung
VALUES(NULL, 'Produktion');
INSERT INTO abteilung
VALUES(NULL, 'Vertrieb');
INSERT INTO abteilung
VALUES(NULL, 'Buchhaltung');
INSERT INTO abteilung
VALUES(NULL, 'Geschäftsführung');