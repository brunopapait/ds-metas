package br.com.papait.bruno.dsmeta.controllers;

import br.com.papait.bruno.dsmeta.entities.Sale;
import br.com.papait.bruno.dsmeta.services.SaleService;
import br.com.papait.bruno.dsmeta.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@GetMapping(value = "/notification")
	public void notifySms() {
		this.smsService.sendSms();
	}
}
