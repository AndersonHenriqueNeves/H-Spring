 
package br.com.springboot.repository;

import java.time.OffsetDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.springboot.model.Temperatura;

public interface TemperaturaRepository extends JpaRepository<Temperatura, Long> {

  @Query(value = "SELECT u from Temperatura u where created_at BETWEEN :startDate AND :endDate AND u.id_galpao = :id_galpao")
  public List<Temperatura> getAllBetweenDates(@Param("startDate")Date startDate,@Param("endDate")Date endDate, @Param("id_galpao") Long id_galpao);  
  
}