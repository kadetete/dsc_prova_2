package br.edu.ifrn.provadois.domain.consulta;

import java.time.LocalDateTime;

import br.edu.ifrn.provadois.domain.medico.Medico;
import br.edu.ifrn.provadois.domain.paciente.Paciente;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "consulta")    //JPQL
@Table(name = "consulta")     //SQL
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "data_consulta")
    private LocalDateTime dataConsulta;
    @Column(name = "diagnostico")
    private String diagnostico;
    @Column(name = "prescricao")
    private String prescricao;
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;
}
