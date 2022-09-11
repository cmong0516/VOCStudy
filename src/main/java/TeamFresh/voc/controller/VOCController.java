package TeamFresh.voc.controller;

import TeamFresh.voc.dto.PenaltyDto;
import TeamFresh.voc.dto.ReparationDto;
import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Client;
import TeamFresh.voc.entity.Delivery;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.repository.ClientRepository;
import TeamFresh.voc.repository.DeliveryRepository;
import TeamFresh.voc.request.PenaltyRequest;
import TeamFresh.voc.request.VOCRequest;
import TeamFresh.voc.service.PenaltyService;
import TeamFresh.voc.service.ReparationService;
import TeamFresh.voc.service.VOCService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
public class VOCController {

    private final VOCService vocService;
    private final PenaltyService penaltyService;
    private final ReparationService reparationService;
    private final DeliveryRepository deliveryRepository;
    private final ClientRepository clientRepository;

    @PostMapping("/voc/add")
    public Long save(@RequestBody @Valid VOCRequest vocRequest) {

        VOC voc = new VOC(vocRequest);
        Delivery delivery = deliveryRepository.findById(vocRequest.getDeliveryId()).get();
        voc.changeDelivery(delivery);
        Client client = clientRepository.findById(vocRequest.getClientId()).get();
        voc.changeClient(client);

        return vocService.saveVOC(voc);
    }

    @GetMapping("/voc/{id}")
    public VOCDto findVOC(@PathVariable Long id) {
        return vocService.findVOC(id);
    }

    @GetMapping("/voc/all")
    public Result vocs() {
        List<VOCDto> result = vocService.findVOCs();
        return new Result(result.size(), result);
    }

    @GetMapping("/voc/penalty/all")
    public List<PenaltyDto> penaltys() {
        return penaltyService.findAll();
    }

    @GetMapping("/voc/reparation/all")
    public List<ReparationDto> reparations() {
        return reparationService.findAll();
    }

    @PostMapping(value = "/voc/penalty/add")
    public VOC addPenalty(@RequestBody PenaltyRequest penaltyRequest) {
        return vocService.updatePenalty(penaltyRequest.getId(), penaltyRequest.getPenalty());
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
