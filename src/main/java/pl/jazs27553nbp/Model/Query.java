package pl.jazs27553nbp.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Query {
    private String table;
    private String currency;
    private String code;

    @JsonProperty("rates")
    private List<Rate> rates;

    public Query(String table, String currency, String code, List<Rate> rates) {
        this.table = table;
        this.currency = currency;
        this.code = code;
        this.rates = rates;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Rate> getRates() {
        return rates;
    }

    public void setRates(List<Rate> rates) {
        this.rates = rates;
    }
}
