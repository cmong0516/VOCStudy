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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VOCController {

    private final VOCService vocService;
    private final PenaltyService penaltyService;
    private final ReparationService reparationService;

    @PostMapping("/voc/add")
    public Long save(VOC voc) {
        return vocService.saveVOC(voc);
    }

    @GetMapping("/voc/all")
    public Result vocs() {
        List<VOCDto> result = vocService.findVOCs();
        return new Result(result.size(), result);
    }

    @GetMapping("/voc/{id}")
    public VOCDto findVOC(@PathVariable Long id) {
        return vocService.findVOC(id);
    }

    @GetMapping("/voc/penalty/all")
    public List<PenaltyDto> penaltys() {
        return penaltyService.findAll();

    }

    @GetMapping("/voc/reparation/all")
    public List<ReparationDto> reparations() {
        return reparationService.findAll();

    }


    @Data
    @AllArgsConstructor
    public static class Result<T>{
        private int count;
        private T data;

        public Result() {
        }
    }
}
