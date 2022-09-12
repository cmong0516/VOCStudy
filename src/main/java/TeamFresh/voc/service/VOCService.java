package TeamFresh.voc.service;

import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.repository.VOCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VOCService {

    private final VOCRepository vocRepository;


    @Transactional
    public Long saveVOC(VOC voc) {
        VOC saved = vocRepository.save(voc);
        return saved.getId();
    }

    @Transactional
    public VOC updatePenalty(Long id,Penalty penalty) {
        VOC findVOC = vocRepository.findById(id).get();
        penalty.changeDelivery(findVOC.getDelivery());
        findVOC.changePenalty(penalty);
        return findVOC;
    }

    @Transactional
    public VOC updateDeliveryCheck(Long id) {
        VOC findVOC = vocRepository.findById(id).get();
        findVOC.changeDeliveryCheck(true);
        return findVOC;
    }

    @Transactional
    public VOC updateReparation(Long id,Reparation reparation) {
        VOC findVOC = vocRepository.findById(id).get();
        findVOC.changeReparation(reparation);
        return findVOC;
    }

    @Transactional
    public VOC updateObjection(Long id, boolean objection) {
        VOC findVOC = vocRepository.findById(id).get();
        findVOC.changeObjection(objection);
        return findVOC;
    }

    public List<VOCDto> findVOCs() {
        return vocRepository.findAll().stream().map(VOCDto::new).collect(Collectors.toList());
    }

    public VOCDto findVOC(Long id) {
        VOC findVOC = vocRepository.findById(id).get();
        return new VOCDto(findVOC);
    }
}
