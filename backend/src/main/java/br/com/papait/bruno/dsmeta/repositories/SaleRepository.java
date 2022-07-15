package br.com.papait.bruno.dsmeta.repositories;

import br.com.papait.bruno.dsmeta.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

//	@Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min AND :max ORDER BY obj.amount DESC")
//	Page<Sale> findSales(LocalDate min, LocalDate max, Pageable pageable);
}
