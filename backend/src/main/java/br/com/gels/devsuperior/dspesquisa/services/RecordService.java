package br.com.gels.devsuperior.dspesquisa.services;

import br.com.gels.devsuperior.dspesquisa.dto.GameDTO;
import br.com.gels.devsuperior.dspesquisa.dto.RecordDTO;
import br.com.gels.devsuperior.dspesquisa.dto.RecordInsertDTO;
import br.com.gels.devsuperior.dspesquisa.entities.Game;
import br.com.gels.devsuperior.dspesquisa.entities.Record;
import br.com.gels.devsuperior.dspesquisa.repositories.GameRepository;
import br.com.gels.devsuperior.dspesquisa.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;
/*
    @Transactional(readOnly = true)
    public List<GameDTO> findAll(){
        List<Game> list = gameRepository.findAll();
        return list.stream().map(x -> new GameDTO(x)).collect(Collectors.toList());
    }

 */
    @Transactional
    public RecordDTO insert(RecordInsertDTO dto){
        Record entity = new Record();
        entity.setName(dto.getName());
        entity.setAge(dto.getAge());
        entity.setMoment(Instant.now());

        Game game = gameRepository.getOne(dto.getGameId());
        entity.setGame(game);

        entity = recordRepository.save(entity);

        return new RecordDTO(entity);
    }

}
