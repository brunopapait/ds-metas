package br.com.papait.bruno.dsmeta.controllers;

import br.com.papait.bruno.dsmeta.entities.Sale;
import br.com.papait.bruno.dsmeta.services.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	private SaleService saleService;

	public SaleController(SaleService saleService) {
		this.saleService = saleService;
	}

	@GetMapping
	public Page<Sale> findSales (
					@RequestParam(value = "minDate", defaultValue = "") String minDate,
					@RequestParam(value = "minDate", defaultValue = "") String maxDate,
					Pageable pageable) {
		return saleService.findSales(minDate, maxDate, pageable);
	}
}
