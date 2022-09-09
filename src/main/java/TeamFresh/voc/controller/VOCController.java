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
import org.springframework.web.bind.annotation.*;

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

    @PutMapping("/voc/delivery-check/update")
    public VOC updateDeliveryCheck(Long id,boolean deliveryCheck) {
        return vocService.updateDeliveryCheck(id, deliveryCheck);
    }

    @PutMapping("/voc/objection/update")
    public VOC updateObjection(Long id, boolean objection) {
        return vocService.updateObjection(id, objection);
    }

    @PutMapping("/voc/penalty/update")
    public VOC updatePenalty(Long id, Penalty penalty) {
        return vocService.updatePenalty(id, penalty);
    }

    @PutMapping("/voc/reparation/update")
    public VOC updateReparation(Long id,Reparation reparation) {
        return vocService.updateReparation(id, reparation);
    }

}
