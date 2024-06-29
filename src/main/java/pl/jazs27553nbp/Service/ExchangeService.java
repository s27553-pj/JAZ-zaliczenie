package pl.jazs27553nbp.Service;

import org.springframework.stereotype.Service;
import pl.jazs27553nbp.Config.ExchangeConfig;
import pl.jazs27553nbp.Repository.ExchangeRepository;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;
    private final ExchangeConfig exchangeConfig;

    public ExchangeService(ExchangeRepository exchangeRepository, ExchangeConfig exchangeConfig) {
        this.exchangeRepository = exchangeRepository;
        this.exchangeConfig = exchangeConfig;
    }

}
