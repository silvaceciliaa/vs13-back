

CREATE TABLE ESTUDANTE(
	id_estudante NUMBER NOT NULL,
	nome VARCHAR2(200) NOT NULL,
	data_nascimento DATE NOT NULL,
	nr_matricula NUMBER(10) NOT NULL UNIQUE,
	ativo CHAR(1) NOT NULL CHECK (ativo IN ('S', 'N'))
);

CREATE SEQUENCE SEQ_ESTUDANTE
 START WITH     1
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Cecília Silva', TO_DATE('15-01-2005', 'dd-mm-yyyy'), 1000000001, 'S');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Júlia Moura', TO_DATE('03-04-2002', 'dd-mm-yyyy'), 1000000002, 'N');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Arthur Matarazo', TO_DATE('05-03-2007', 'dd-mm-yyyy'), 1000000003, 'S');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Vinicius Silva', TO_DATE('06-01-2006', 'dd-mm-yyyy'), 100000004, 'S');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Manuela Rosa', TO_DATE('20-01-2005', 'dd-mm-yyyy'), 1000000005, 'S');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Letícia Garz', TO_DATE('24-11-1999', 'dd-mm-yyyy'), 1000000006, 'N');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Eduardo Flores', TO_DATE('30-04-2005', 'dd-mm-yyyy'), 1000000007, 'S');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Evelina Soares', TO_DATE('30-10-2001', 'dd-mm-yyyy'), 1000000008, 'N');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Fátima Amaral', TO_DATE('20-05-1978', 'dd-mm-yyyy'), 1000000009, 'N');
INSERT INTO ESTUDANTE (id_estudante, nome, data_nascimento, nr_matricula, ativo) VALUES(SEQ_ESTUDANTE.nextval, 'Gabriel Zanza', TO_DATE('10-01-2000', 'dd-mm-yyyy'), 1000000010, 'N');

SELECT * FROM ESTUDANTE;

