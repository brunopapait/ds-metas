package br.com.papait.bruno.dsmeta.controllers;

import br.com.papait.bruno.dsmeta.entities.Sale;
import br.com.papait.bruno.dsmeta.services.SaleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/salles")
public class SaleController {

	private SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping
	public List<Sale> findSales () {
		return saleService.findSales();
	}
}
