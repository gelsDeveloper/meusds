package br.com.gels.devsuperior.dspesquisa.dto;

import br.com.gels.devsuperior.dspesquisa.entities.Game;
import br.com.gels.devsuperior.dspesquisa.entities.enums.Platform;

import java.io.Serializable;

public class RecordInsertDTO implements Serializable {
    private static final long serialVersionUID =1L;

    private String name;
    private Integer age;
    private Long gameId;

    public RecordInsertDTO() {
    }

    /*
    public RecordInsertDTO(Game entity) {
        id  =entity.getId();
        title = entity.getTitle();
        platform = entity.getPlatform();
    }

     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }
}
