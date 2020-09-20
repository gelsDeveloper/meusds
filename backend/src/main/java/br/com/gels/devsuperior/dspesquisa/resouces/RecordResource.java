package br.com.gels.devsuperior.dspesquisa.resouces;


import br.com.gels.devsuperior.dspesquisa.dto.GameDTO;
import br.com.gels.devsuperior.dspesquisa.dto.RecordDTO;
import br.com.gels.devsuperior.dspesquisa.dto.RecordInsertDTO;
import br.com.gels.devsuperior.dspesquisa.services.GameService;
import br.com.gels.devsuperior.dspesquisa.services.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/records")
public class RecordResource {

    @Autowired
    private RecordService recordService;


    @PostMapping
    public ResponseEntity<RecordDTO>insert( @RequestBody RecordInsertDTO dto ){
        RecordDTO newDTO = recordService.insert(dto);
        return ResponseEntity.ok().body(newDTO);
    }

}
