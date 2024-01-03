package br.edu.ifrn.provadois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.provadois.domain.medico.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long>{
    
}
