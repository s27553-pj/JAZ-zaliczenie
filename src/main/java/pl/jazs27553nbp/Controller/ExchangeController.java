package pl.jazs27553nbp.Controller;

import org.springframework.stereotype.Controller;

import pl.jazs27553nbp.Service.ExchangeService;

@Controller
public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
}
