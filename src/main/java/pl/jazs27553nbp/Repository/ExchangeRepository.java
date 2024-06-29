package pl.jazs27553nbp.Repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.jazs27553nbp.Model.Exchange;

@Repository
public interface ExchangeRepository extends JpaRepository<Exchange,Long> {
}
