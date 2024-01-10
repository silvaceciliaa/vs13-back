CREATE TABLE VEM_SER.PAIS(
	id_pais NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	
	CONSTRAINT PK_PAIS PRIMARY KEY(id_pais)
);

CREATE TABLE VEM_SER.ESTADO(
	id_estado NUMBER(38) NOT NULL,
	id_pais NUMBER(38) NOT NULL,
	nome VARCHAR2(50) NOT NULL,
	
	CONSTRAINT PK_ESTADO PRIMARY KEY(id_estado),
	CONSTRAINT FK_ESTADO_ID_PAIS FOREIGN KEY(id_pais) REFERENCES VEM_SER.PAIS(id_pais)
);

CREATE TABLE VEM_SER.CIDADE(
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	
	CONSTRAINT PK_CIDADE_ESTADO PRIMARY KEY(id_cidade, id_estado),
	CONSTRAINT FK_CIDADE_ID_ESTADO FOREIGN KEY(id_estado) REFERENCES VEM_SER.ESTADO(id_estado)
);


CREATE TABLE VEM_SER.BAIRRO(
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	id_estado NUMBER(38) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	
	 CONSTRAINT PK_BAIRRO_CIDADE PRIMARY KEY (id_bairro, id_cidade),
	CONSTRAINT FK_BAIRRO_ID_CIDADE_ESTADO FOREIGN KEY (id_cidade, id_estado) REFERENCES VEM_SER.CIDADE(id_cidade, id_estado)
);

CREATE TABLE VEM_SER.ENDERECO(
	id_endereco NUMBER(38) NOT NULL,
	id_bairro NUMBER(38) NOT NULL,
	id_cidade NUMBER(38) NOT NULL,
	logradouro VARCHAR2(255) NOT NULL,
	numero NUMBER(38) NOT NULL,
	complemento VARCHAR2(100),
	cep CHAR(9),
	
	
	CONSTRAINT PK_ENDERECO PRIMARY KEY (id_endereco),
	CONSTRAINT FK_ENDERECO_ID_BAIRRO_CIDADE FOREIGN KEY (id_bairro, id_cidade) REFERENCES VEM_SER.BAIRRO(id_bairro, id_cidade)
);

CREATE SEQUENCE VEM_SER.SEQ_PAIS
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;
	
CREATE SEQUENCE VEM_SER.SEQ_ESTADO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_CIDADE
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_BAIRRO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;

CREATE SEQUENCE VEM_SER.SEQ_ENDERECO
	START WITH 1
	INCREMENT BY 1
	NOCACHE NOCYCLE;
	
INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES (VEM_SER.SEQ_PAIS.NEXTVAL, 'Brasil');
INSERT INTO VEM_SER.PAIS (id_pais, nome) VALUES (VEM_SER.SEQ_PAIS.NEXTVAL, 'Canada');



SELECT * FROM VEM_SER.PAIS p ;

INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_ESTADO.NEXTVAL, 1, 'Santa Catarina');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_ESTADO.NEXTVAL, 1, 'Pernambuco');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_ESTADO.NEXTVAL, 2, 'Alberta');
INSERT INTO VEM_SER.ESTADO (id_estado, id_pais, nome) VALUES (VEM_SER.SEQ_ESTADO.NEXTVAL, 2, 'Manitoba');

SELECT * FROM VEM_SER.ESTADO e  ;

INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 1, 'Florianópolis');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 1, 'Blumenau');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 2, 'Recife');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 2, 'Gravatá');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 3, 'Calgary');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 3, 'Edmonton');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 4, 'Winnipeg');
INSERT INTO VEM_SER.CIDADE (id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_CIDADE.NEXTVAL, 4, 'Brandon');

INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 1, 1, 'Saco Grande');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 1, 1, 'Santa Mônica');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 2, 1, 'Velha Central');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 2, 1, 'Itoupava Seca');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 3, 2, 'Afogados');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 3, 2, 'Aflitos');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 4, 2, 'COHAB II');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 4, 2, 'Bairro Novo');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 5, 3, 'Kesignton');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 5, 3, 'Little Italy');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 6, 3, 'Chinatown');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 6, 3, 'Mount Royal');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 7, 4, 'Corydon District');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 7, 4, 'Osborne Village');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 8, 4, 'Larkhill');
INSERT INTO VEM_SER.BAIRRO b (id_bairro, id_cidade, id_estado, nome) VALUES (VEM_SER.SEQ_BAIRRO.NEXTVAL, 8, 4, 'Centennial');

INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 1, 1, 'Rua A - Bairro A', 123, 'Apartamento 1', '12345-678');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 1, 1, 'Rua B - Bairro A', 456, 'Casa 2', '56789-012');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 2, 1, 'Avenida X - Bairro B', 789, NULL, '34567-890');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 2, 1, 'Avenida Y - Bairro B', 101, 'Loja 3', '90123-456');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 3, 2, 'Main Street - Bairro A', 222, 'Suite 5', '23456-789');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 3, 2, 'Broadway - Bairro B', 333, 'Penthouse', '45678-901');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 4, 2, '5th Avenue - Bairro A', 444, 'Floor 10', '56789-012');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 4, 2, 'Park Avenue - Bairro B', 555, 'Apartment 20', '67890-123');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 5, 3, 'Bank Avenue - Bairro F', 1024, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 5, 3, 'Tree Stree - Bairro I', 1234, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 6, 3, 'Avenida A - Bairro H', 876, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 6, 3, 'Avenida B- Bairro P', 999, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 7, 4, 'Avenida P - Bairro X', 000, NULL, '100-09');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 7, 4, 'Avenida J- Bairro Y', 111, 'Condomínio', NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 8, 4, 'Avenida ALL TOO WELL', 161, 'Apartment 21', '09827-0');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 8, 4, 'Avenida RED', 444, 'New', '4521');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 9, 5, 'Avenida love affair', 085, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 9, 5, 'Avenida i was there', 9712, 'Condomínio em frente ao mar', NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 10, 5, 'Avenida it was rare', 1245, 'Apartamento 231', NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 10, 5, 'Avenida down', 2903, 'Parte superior', '1099');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 11, 6, 'Avenida stay stay stau', 0709, 'Casa Azul', '09072008');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 11, 6, 'Avenida last kiss', 0982, 'Apartamento', '12134');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 12, 6, 'Avenida I DO', 135, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 12, 6, 'Avenida for you', 0921, 'Parte de trás', '109099');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 13, 7, 'Avenida i watch', 9212, NULL, '9078621');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 13, 7, 'Avenida old friends', 918028, 'Casa Amarela', NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 14, 7, 'Avenida reminds', 1441, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 14, 7, 'Avenida change your mind', 0019, 'Banco na frente', '99018');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 15, 8, 'Avenida never thought', 124, 'Casa Roxa', NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 15, 8, 'Avenida lips', 136, NULL, '097867');
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 16, 8, 'Rua forever the name', 721, NULL, NULL);
INSERT INTO VEM_SER.ENDERECO (id_endereco, id_bairro, id_cidade, logradouro, numero, complemento, cep) VALUES (VEM_SER.SEQ_ENDERECO.NEXTVAL, 16, 8, 'Rua haunted', 0987, 'Parte de cima', '090918');
