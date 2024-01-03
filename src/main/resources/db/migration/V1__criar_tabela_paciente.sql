CREATE TABLE paciente (
    id int primary key auto_increment,
    nome varchar(150) not null,
    cpf varchar(14) not null,
    historico_medico varchar(200) not null
);