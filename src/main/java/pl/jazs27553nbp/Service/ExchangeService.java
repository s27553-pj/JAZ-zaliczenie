package pl.jazs27553nbp.Service;

import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.jazs27553nbp.Config.ExchangeConfig;
import pl.jazs27553nbp.Exception.ExchangeNotFound;
import pl.jazs27553nbp.Model.Exchange;
import pl.jazs27553nbp.Model.Query;
import pl.jazs27553nbp.Model.Rate;
import pl.jazs27553nbp.Repository.ExchangeRepository;

import java.time.LocalDateTime;

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
//    public ExchangeService save(String name, String startDate, String endDate){
//        Exchange ApiNbp= restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/A/" + name + "/" + startDate + "/" + endDate + "/", Query.class);
//        exchangeRepository.save(ApiNbp);
//        return getAvarage();
//    }
public Exchange save(String name, String startDate, String endDate){
    Exchange exchange = new Exchange(name, startDate, endDate, getAvarage(name, startDate, endDate), String.valueOf(LocalDateTime.now()));
    return exchangeRepository.save(exchange);
}


}
