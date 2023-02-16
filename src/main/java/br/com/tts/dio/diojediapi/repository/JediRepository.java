package br.com.tts.dio.diojediapi.repository;

import br.com.tts.dio.diojediapi.model.Jedi;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tiago Luiz Fernandes
 */

@Repository
public class JediRepository {
    private final List<Jedi> jediList = new ArrayList<>();

    public JediRepository(){
        jediList.add(new Jedi("Luke", "Skywalker"));
    }
    public List<Jedi> getAllJedi(){
        return jediList;
    }

    public void save(Jedi jedi) {
        jediList.add(jedi);
    }
}
