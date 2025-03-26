package repositories;
import entity.HeuresSup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface HeuresSupRepository extends JpaRepository<HeuresSup, Integer> {
    List<HeuresSup> findByEmployeIdAndDateBetween(int employeId, Date startDate, Date endDate);
}