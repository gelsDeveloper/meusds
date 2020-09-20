package br.com.gels.devsuperior.dspesquisa.repositories;

import br.com.gels.devsuperior.dspesquisa.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
}
