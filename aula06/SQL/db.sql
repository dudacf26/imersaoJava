CREATE DATABASE TARGETBANK;
USE TARGETBANK;

CREATE TABLE correntista ( 
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	NOME VARCHAR(200) NOT NULL, 
	CONTAID INT NOT NULL
    
) ENGINE = INNODB;

CREATE TABLE CONTA ( 
	ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
	AGENCIA INT NOT NULL, 
	NUMERO INT NOT NULL, 
	SALDO DOUBLE NULL 
)  ENGINE = INNODB;

CREATE TABLE MOVIMENTO (
    ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    TIPO CHAR NOT NULL,
    VALOR DOUBLE(18,2) NOT NULL,
    DESCRICAO VARCHAR(250) NOT NULL,
    CONTAFK INT NOT NULL
) ENGINE = INNODB;

-- CONTA RIGUEL
INSERT INTO conta (AGENCIA, NUMERO, SALDO) VALUES (1234,654321,100000.00);
INSERT INTO correntista (NOME, CONTAID)
VALUES('RIGUEL FIGUEIRO', (SELECT IFNULL(MAX(ID), 1) FROM CONTA ));

-- CONTA MARIA
INSERT INTO conta (AGENCIA, NUMERO, SALDO) VALUES (1234,54812, 50.00);
INSERT INTO correntista (NOME, CONTAID) 
VALUES('MARIA DO BAIRRO', (SELECT IFNULL(MAX(ID), 1) FROM CONTA ));

-- EXEMPLO
SELECT * FROM correntista C INNER JOIN conta CT ON C.CONTAID = CT.ID;

ALTER TABLE CORRENTISTA 
ADD CONSTRAINT FK_CORRENTISTACONTA 
FOREIGN KEY (CONTAID) REFERENCES conta(ID);

ALTER TABLE MOVIMENTO
ADD CONSTRAINT FK_MOVIEMNTOCONTA
FOREIGN KEY (CONTAFK) REFERENCES conta(ID);

INSERT INTO movimento (TIPO, VALOR, DESCRICAO, CONTAFK) VALUES (
    'C', 
    100.00, 
    'RECEBIMENTO CINEMA', 
    (SELECT ID FROM CONTA WHERE NUMERO = 54812 AND AGENCIA = 1234 )
);

INSERT INTO movimento (TIPO, VALOR, DESCRICAO, CONTAFK) VALUES (
    'D', 
    50.00, 
    'PAGAMENTO LUZ', 
    (SELECT ID FROM CONTA WHERE NUMERO = 54812 AND AGENCIA = 1234 )
);

INSERT INTO movimento (TIPO, VALOR, DESCRICAO, CONTAFK) VALUES (
    'C', 
    100.00, 
    'SALARIO TARGET TRUST', 
    (SELECT ID FROM CONTA WHERE NUMERO = 654321 AND AGENCIA = 1234 )
);





