package br.edu.ifrn.provadois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.provadois.domain.paciente.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    
}
