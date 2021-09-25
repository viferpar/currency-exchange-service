package es.viferpar.microservices.currencyexchangeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import es.viferpar.microservices.currencyexchangeservice.bean.CurrencyExchange;
import es.viferpar.microservices.currencyexchangeservice.repository.CurrencyExchangeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CurrencyExchangeController {

  private final Environment environment;

  private final CurrencyExchangeRepository currencyExchangeRepository;

  @GetMapping("/currency-exchange/from/{from}/to/{to}")
  public CurrencyExchange retrieveExchangeValue(@PathVariable String from,
      @PathVariable String to) {

    log.info("retrieveExchangeValue called with {} to {}", from, to);

    final CurrencyExchange exchange = currencyExchangeRepository.findByFromAndTo(from, to);
    final String port = environment.getProperty("local.server.port");
    exchange.setEnviroment(port);

    return exchange;

  }

}
