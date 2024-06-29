package pl.jazs27553nbp.Service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.jazs27553nbp.Config.ExchangeConfig;
import pl.jazs27553nbp.Exception.ExchangeNotFound;
import pl.jazs27553nbp.Model.Query;
import pl.jazs27553nbp.Model.Rate;
import pl.jazs27553nbp.Repository.ExchangeRepository;

@Service
public class ExchangeService {
    private RestTemplate restTemplate;
    private final ExchangeRepository exchangeRepository;

    public ExchangeService(ExchangeRepository exchangeRepository,  RestTemplate restTemplate) {
        this.exchangeRepository = exchangeRepository;
        this.restTemplate = restTemplate;
    }
    public double getAvarage(String name, String startDate, String endDate){
        try {
            Query ApiNbp= restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/" + name + "/" + startDate + "/" + endDate + "/", Query.class);
            return ApiNbp.getRates()
                    .stream()
                    .mapToDouble(Rate::getMid)
                    .average()
                    .orElseThrow();
        } catch (HttpClientErrorException e ) {
            throw new ExchangeNotFound("Exchange has not been found");
        }
    }

}
