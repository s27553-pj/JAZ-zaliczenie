package pl.jazs27553nbp.Model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import org.springframework.web.service.annotation.GetExchange;

@Entity
@Table(name="nbp")
public class Exchange {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Unique identifier", example="1")
    private Long id;
    @Schema(description = "value name", example="eur")

    private String name;
    @Schema(description = "start date", example="16.04.2024")

    private String startDate;
    @Schema(description = "end date", example="26.04.2024")

    private String endDate;
    @Schema(description = "average", example="4.5")

    private double average;
    @Schema(description = "query date", example="")

    private String query;

    public Exchange() {
    }

    public Exchange(String name, String startDate, String endDate, double average, String query) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.average = average;
        this.query = query;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getAverage() {
        return average;
    }

    public void setAverage(double average) {
        this.average = average;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
