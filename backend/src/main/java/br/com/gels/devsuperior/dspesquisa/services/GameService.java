package br.com.gels.devsuperior.dspesquisa.services;

import br.com.gels.devsuperior.dspesquisa.dto.GameDTO;
import br.com.gels.devsuperior.dspesquisa.entities.Game;
import br.com.gels.devsuperior.dspesquisa.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }
}
