package br.edu.ifrn.provadois.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifrn.provadois.domain.consulta.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long>{
    
}
