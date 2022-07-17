package br.com.papait.bruno.dsmeta.repositories;

import br.com.papait.bruno.dsmeta.entities.Sale;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	@Query("SELECT sale FROM Sale sale WHERE sale.date BETWEEN :min AND :max ORDER BY sale.amount DESC")
	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
