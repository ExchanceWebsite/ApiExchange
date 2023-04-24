INSERT INTO localidade
(pais,cidade,endereco,cep)
VALUES
('Japão', 'Tokyo','Rua das Marguaridas', '04848160'),
('Coreia do Sul', 'Seul','Rua dos Rashis', '5555134');


INSERT INTO estudante
(nome,idade,descricao,email,senha,telefone,cpf,localidade_id_localidade)
VALUES
('Ana', 25,'Estudiosa e inteligente','ana@gmail.com','12345678','011954337632','46949092822',1),
('José', 20,'Curioso','jose@gmail.com','jose1234567','011954327632','46949092821',2);

