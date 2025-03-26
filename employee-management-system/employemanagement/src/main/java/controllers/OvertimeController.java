package controllers;
import entity.HeuresSup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repositories.HeuresSupRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/overtime")
public class OvertimeController {
    @Autowired
    private HeuresSupRepository heuresSupRepository;

    @PostMapping
    public float calculateOvertime(@RequestParam int employeId, @RequestParam Date startDate, @RequestParam Date endDate) {
        List<HeuresSup> heures = heuresSupRepository.findByEmployeIdAndDateBetween(employeId, startDate, endDate);
        return heures.stream().map(HeuresSup::getNbHeures).reduce(0f, Float::sum);
    }
}
