package pl.jazs27553nbp.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.jazs27553nbp.Model.Exchange;
import pl.jazs27553nbp.Service.ExchangeService;

@RestController
@RequestMapping("/jaz-s27553-nbp")

public class ExchangeController {
    private final ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {
        this.exchangeService = exchangeService;
    }
    @GetMapping("/averageExchange/{name}/{startDate}/{endDate}")
    @Operation(summary = "Get exchange from NBP API", description = "")
    @ApiResponse(responseCode = "200", description = "Successfully saved")
    @ApiResponse(responseCode = "404", description = "Invalid number",  content = @Content)
    @ApiResponse(responseCode = "400", description = "Bad request", content = @Content)
    public ResponseEntity<Exchange> getAvarage(@PathVariable String name, @PathVariable String startDate, @PathVariable String endDate){
        return ResponseEntity.ok(exchangeService.save(name, startDate,endDate));
    }
}
