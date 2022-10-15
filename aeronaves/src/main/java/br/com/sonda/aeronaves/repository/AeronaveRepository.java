package br.com.sonda.aeronaves.repository;

import br.com.sonda.aeronaves.model.Aeronave;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeronaveRepository extends JpaRepository<Aeronave, Long> {

}
