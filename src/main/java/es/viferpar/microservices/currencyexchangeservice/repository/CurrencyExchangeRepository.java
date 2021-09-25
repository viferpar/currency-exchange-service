package es.viferpar.microservices.currencyexchangeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.viferpar.microservices.currencyexchangeservice.bean.CurrencyExchange;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

  CurrencyExchange findByFromAndTo(String from, String to);

}
