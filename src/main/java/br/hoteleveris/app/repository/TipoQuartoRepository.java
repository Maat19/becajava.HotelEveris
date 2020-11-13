package br.hoteleveris.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;

@Repository
public interface TipoQuartoRepository extends JpaRepository<TipoQuarto, Long> {

}


