package br.com.gels.devsuperior.dspesquisa.repositories;

import br.com.gels.devsuperior.dspesquisa.entities.Record;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordRepository extends JpaRepository<Record, Long> {
}
