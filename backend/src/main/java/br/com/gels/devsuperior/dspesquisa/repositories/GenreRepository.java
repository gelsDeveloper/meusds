package br.com.gels.devsuperior.dspesquisa.repositories;

import br.com.gels.devsuperior.dspesquisa.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}
