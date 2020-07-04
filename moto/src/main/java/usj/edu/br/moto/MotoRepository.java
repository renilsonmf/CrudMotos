package usj.edu.br.moto;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface MotoRepository extends CrudRepository <Moto, Long> {
    List<Moto> findAll();
}