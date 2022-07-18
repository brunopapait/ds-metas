package br.com.papait.bruno.dsmeta.controllers;

import br.com.papait.bruno.dsmeta.entities.Sale;
import br.com.papait.bruno.dsmeta.services.SaleService;
import br.com.papait.bruno.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService saleService;

	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Sale> findSales(
					@RequestParam(value = "minDate", defaultValue = "") String minDate,
					@RequestParam(value = "maxDate", defaultValue = "") String maxDate,
					Pageable pageable) {
		return saleService.findSales(minDate, maxDate, pageable);
	}

	@GetMapping(value = "/{id}/notification")
	public void notifySms(@PathVariable Long id) throws Exception {
		Optional<Sale> sale = saleService.findSaleById(id);

		if (sale.isEmpty()) {
			throw new Exception("Sale of id: " + id + " not found");
		}

		this.smsService.sendSms(sale.get());
	}
}
