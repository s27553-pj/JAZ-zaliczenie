package pl.jazs27553nbp.Service;

import org.springframework.stereotype.Service;
import pl.jazs27553nbp.Repository.ExchangeRepository;

@Service
public class ExchangeService {
    private final ExchangeRepository exchangeRepository;

    public ExchangeService(ExchangeRepository exchangeRepository) {
        this.exchangeRepository = exchangeRepository;
    }
}
