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

INSERT INTO host_family
(descricao,email,nome,senha,verificado,localidade_id_localidade)
VALUES
('Familia muito severa na bebida','severo@gmail.com','Familia Severo','$2a$10$uwy3.uHaPkaJ3IEP74LDAujLWW81ioO3ratjq1OqkCcPSxSYsAQZW','true','2');

INSERT INTO acomodacao
(descricao,fim_disponibilidade,inicio_disponibilidade,regras,valor_diaria,host_id_host_family)
VALUES
('temos um quarto disponivel','2023-06-25','2023-06-03','não respirar',80.0,1);

INSERT INTO reserva
(entrada,forma_pagamento,saida,acomodacao,estudante_id_estudante,host_id_host_family)
VALUES
('2023-06-03','boleto','2023-06-25',1,2,1);

