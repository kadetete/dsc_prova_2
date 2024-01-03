CREATE TABLE consulta (
    id int primary key auto_increment,
    data_consulta datetime not null,
    diagnostico varchar(100) not null,
    prescricao varchar(100) not null,
    id_medico int,
    id_paciente int,
    FOREIGN KEY (id_medico) REFERENCES medico(id),
    FOREIGN KEY (id_paciente) REFERENCES paciente(id)
);