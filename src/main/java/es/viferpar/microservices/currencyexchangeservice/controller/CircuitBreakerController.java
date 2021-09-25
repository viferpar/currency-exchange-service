package es.viferpar.microservices.currencyexchangeservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CircuitBreakerController {

  @GetMapping("/sample-api")
  // @Retry(name = "sample-api", fallbackMethod = "harcodedResponse")
  // @CircuitBreaker(name = "default", fallbackMethod = "harcodedResponse")
  // @RateLimiter(name = "default")
  @Bulkhead(name = "sample-api")
  public String sampleApi() {

    log.info("Sample Api call received");

    // final ResponseEntity<String> forEntity =
    // new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class);
    //
    // return forEntity.getBody();

    return "sample-api";

  }

  public String harcodedResponse(Exception ex) {
    return "fallback-response";
  }

}
