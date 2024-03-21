package vw.div.currency.conversion.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;

import org.slf4j.LoggerFactory;
//import org.hibernate.query.NativeQuery.ReturnableResultNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents.UriTemplateVariables;

import ch.qos.logback.classic.Logger;
//import vw.div.currency.exchange.currencyexchangeservice.CurrencyExchangeController;


@Configuration(proxyBeanMethods = false)
class restTemplateConfiguration{
	@Bean 
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}



@RestController
public class CurrencyConversionController {

	private Logger logger =(Logger) LoggerFactory.getLogger(CurrencyConversionController.class);
	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateCurrencyConversion(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
	
		HashMap<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
	 
		logger.info("from:"+from+"to:"+to+",quatity:"+quantity);
	
	ResponseEntity<CurrencyConversion> responseEntity = restTemplate.getForEntity
			("http://localhost:8000/currency-exchange/from/{from}/to/{to}",
					CurrencyConversion.class , uriVariables);
	
	CurrencyConversion currencyConversion=responseEntity.getBody();
	BigDecimal conversionMultiple = currencyConversion.getConversionMultiple();
	BigDecimal totalCalculateAmount = quantity.multiply(conversionMultiple);
	currencyConversion.setTotalCalculatedAmount(totalCalculateAmount);
	
	logger.info("after setting calculated amt, currencyConversion;"+currencyConversion);
	
//  return currencyConversion;


  return new CurrencyConversion(currencyConversion.getId(),
          from, to, quantity,
          currencyConversion.getConversionMultiple(),
          quantity.multiply(currencyConversion.getConversionMultiple()),
          currencyConversion.getEnvironment() + " " + "rest template");
}


@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
public CurrencyConversion calculateCurrencyConversionFeign(
      @PathVariable String from,
      @PathVariable String to,
      @PathVariable BigDecimal quantity
) {
  CurrencyConversion currencyConversion = currencyExchangeProxy.retrieveExchangeValue(from, to);

  logger.info("Converstion: Feign =>" + currencyConversion);
  currencyConversion.setQuantity(quantity);
  BigDecimal conversionMultiple1 = currencyConversion.getConversionMultiple();

  BigDecimal totalCalculateAmount1 = quantity.multiply(conversionMultiple1);

  currencyConversion.setTotalCalculatedAmount(totalCalculateAmount1);

  logger.info("after setting calculated amt, currencyConversion" + currencyConversion);

  return new CurrencyConversion(currencyConversion.getId(),
          from, to, quantity,
          currencyConversion.getConversionMultiple(),
          quantity.multiply(currencyConversion.getConversionMultiple()),
          currencyConversion.getEnvironment());

}

}