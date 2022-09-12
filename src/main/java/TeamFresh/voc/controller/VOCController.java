package TeamFresh.voc.controller;

import TeamFresh.voc.dto.Negligence;
import TeamFresh.voc.dto.PenaltyDto;
import TeamFresh.voc.dto.ReparationDto;
import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.*;
import TeamFresh.voc.repository.ClientRepository;
import TeamFresh.voc.repository.DeliveryRepository;
import TeamFresh.voc.repository.VOCRepository;
import TeamFresh.voc.request.DeliveryCheckRequest;
import TeamFresh.voc.request.PenaltyRequest;
import TeamFresh.voc.request.ReparationRequest;
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

@RestController
@RequiredArgsConstructor
@Slf4j
public class VOCController {

    private final VOCService vocService;
    private final PenaltyService penaltyService;
    private final ReparationService reparationService;
    private final DeliveryRepository deliveryRepository;
    private final ClientRepository clientRepository;
    private final VOCRepository vocRepository;

    @PostMapping("/voc/add")
    public Long save(@RequestBody @Valid VOCRequest vocRequest) {

        VOC voc = new VOC(vocRequest);
        Delivery delivery = deliveryRepository.findById(vocRequest.getDeliveryId()).get();
        voc.changeDelivery(delivery);
        Client client = clientRepository.findById(vocRequest.getClientId()).get();
        voc.changeClient(client);

        if (voc.getNegligence() == Negligence.Carrier) {
            Reparation reparation = reparationService.saveReparation(new Reparation(vocRequest.getPrice()));
            voc.changeReparation(reparation);
        }

        return vocService.saveVOC(voc);
    }

    @PutMapping("/voc/penalty/delivery-check/{id}")
    public VOCDto deliveryCheck(@PathVariable Long id, @RequestBody @Valid DeliveryCheckRequest deliveryCheckRequest) {
        VOC voc = vocRepository.findById(id).get();
        voc.getPenalty().changeDeliveryPenaltyCheck(true);
        if (deliveryCheckRequest.isObjection()) {
            voc.changeObjection(deliveryCheckRequest.isObjection());
            vocService.saveVOC(voc);
        }
        if (!deliveryCheckRequest.isObjection()) {
            voc.changeObjection(deliveryCheckRequest.isObjection());
            vocService.saveVOC(voc);
        }
        return new VOCDto(voc);
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
    public Result penaltys() {
        List<PenaltyDto> result = penaltyService.findAll();
        return new Result(result.size(), result);
    }

    @GetMapping("/voc/reparation/all")
    public Result reparations() {
        List<ReparationDto> result = reparationService.findAll();
        return new Result(result.size(), result);
    }

    @PostMapping(value = "/voc/penalty/add/{id}")
    public VOC addPenalty(@PathVariable Long id,@RequestBody PenaltyRequest penaltyRequest) {
        Penalty penalty = new Penalty(penaltyRequest.getPrice());
        penaltyService.savePenalty(penalty);
        return vocService.updatePenalty(id, penalty);
    }

    @PostMapping(value = "/voc/reparation/add/{id}")
    public VOC addReparation(@PathVariable Long id, @RequestBody ReparationRequest reparationRequest) {
        Reparation reparation = new Reparation(reparationRequest.getPrice());
        reparationService.saveReparation(reparation);
        return vocService.updateReparation(id, reparation);
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
