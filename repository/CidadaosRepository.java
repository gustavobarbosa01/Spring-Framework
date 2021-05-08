package br.com.cadastro.gustavo.demo.repository;

import br.com.cadastro.gustavo.demo.model.Cidadaos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadaosRepository extends JpaRepository<Cidadaos, Long>{

}
