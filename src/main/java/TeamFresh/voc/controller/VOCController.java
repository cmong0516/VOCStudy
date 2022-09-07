package TeamFresh.voc.controller;

import TeamFresh.voc.dto.PenaltyDto;
import TeamFresh.voc.dto.ReparationDto;
import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.service.PenaltyService;
import TeamFresh.voc.service.ReparationService;
import TeamFresh.voc.service.VOCService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VOCController {

    private final VOCService vocService;
    private final PenaltyService penaltyService;
    private final ReparationService reparationService;

    @PostMapping("/voc/add")
    public Long save(VOC voc) {
        return vocService.saveVOC(voc);
    }

    @PostMapping("/voc/update")
    public VOC update(Long vocId, Penalty penalty, Reparation reparation) {
        return vocService.updateVOC(vocId, penalty, reparation);
    }

    @GetMapping("/voc/all")
    public List<VOCDto> vocs() {
        return vocService.findVOCs();
    }

    @GetMapping("/voc/penalty/all")
    public List<PenaltyDto> penaltys() {
        return penaltyService.findAll();
    }

    @GetMapping("/voc/reparation/all")
    public List<ReparationDto> reparations() {
        return reparationService.findAll();
    }

}
