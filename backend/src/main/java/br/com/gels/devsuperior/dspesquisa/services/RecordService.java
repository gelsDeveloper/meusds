package br.com.gels.devsuperior.dspesquisa.services;

import br.com.gels.devsuperior.dspesquisa.dto.RecordDTO;
import br.com.gels.devsuperior.dspesquisa.dto.RecordInsertDTO;
import br.com.gels.devsuperior.dspesquisa.entities.Game;
import br.com.gels.devsuperior.dspesquisa.entities.Record;
import br.com.gels.devsuperior.dspesquisa.repositories.GameRepository;
import br.com.gels.devsuperior.dspesquisa.repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public Page<RecordDTO> findByMoments(Instant minDat, Instant maxDat, PageRequest pageRequest){
        return recordRepository.findByMoments(minDat, maxDat, pageRequest).map(x-> new RecordDTO(x));
    }

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
