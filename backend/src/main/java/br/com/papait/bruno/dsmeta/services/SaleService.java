package br.com.papait.bruno.dsmeta.services;

import br.com.papait.bruno.dsmeta.entities.Sale;
import br.com.papait.bruno.dsmeta.repositories.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService {
	private SaleRepository saleRepository;

	public SaleService(SaleRepository saleRepository) {
		this.saleRepository = saleRepository;
	}

	public List<Sale> findSales() {
		return saleRepository.findAll();
	}
}
