
-- Right join pessoa e contato
SELECT *
FROM Pessoa p
RIGHT JOIN Contato c ON p.id_pessoa = c.id_pessoa;

-- Right join pessoa, pessoa_x_pessoa_endereco
SELECT *
FROM Pessoa p
RIGHT JOIN Pessoa_x_Pessoa_Endereco pxpe ON p.id_pessoa = pxpe.id_pessoa
RIGHT JOIN Endereco_Pessoa ep ON pxpe.id_endereco = ep.id_endereco

--Right join todas as tabelas
SELECT * 
FROM PESSOA p 
RIGHT JOIN Contato c ON p.id_pessoa = c.id_pessoa
RIGHT JOIN Pessoa_x_Pessoa_Endereco pxpe ON p.id_pessoa = pxpe.id_pessoa
RIGHT JOIN Endereco_Pessoa ep ON pxpe.id_endereco = ep.id_endereco

-- Full join pessoa e contato
SELECT *
FROM Pessoa p
FULL JOIN Contato c ON p.id_pessoa = c.id_pessoa;

-- Right join pessoa, pessoa_x_pessoa_endereco
SELECT *
FROM Pessoa p
FULL JOIN Pessoa_X_Pessoa_Endereco pxpe ON p.id_pessoa = pxpe.id_pessoa
FULL JOIN Endereco_Pessoa ep ON pxpe.id_endereco = ep.id_endereco

-- Full join todas as tabelas
SELECT *
FROM Pessoa p
FULL JOIN Contato c ON p.id_pessoa = c.id_pessoa
FULL JOIN Pessoa_X_Pessoa_Endereco pxpe ON p.id_pessoa = pxpe.id_pessoa
FULL JOIN Endereco_Pessoa ep ON pxpe.id_endereco = ep.id_endereco

-- Utilizando EXISTS para selecionar as pessoas que tem endereço
SELECT * 
FROM PESSOA p 
WHERE EXISTS ( SELECT * 
		FROM PESSOA_X_PESSOA_ENDERECO pxpe
		WHERE pxpe.id_pessoa = p.id_pessoa
)

-- Selecionando o id, nome da tabela pessoa junto com id, logradouro da tabela endereco
SELECT p.id_pessoa, p.nome
FROM PESSOA p
UNION
SELECT ep.id_endereco, ep.logradouro
FROM ENDERECO_PESSOA ep;


