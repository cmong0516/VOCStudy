package TeamFresh.voc.service;

import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.repository.VOCRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.build.Plugin;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class VOCService {

    private final VOCRepository vocRepository;

    @Transactional
    public Long saveVOC(VOC voc) {
        VOC saved = vocRepository.save(voc);
        return saved.getId();
    }

    @Transactional
    public VOCDto updatePenalty(Long id, Penalty penalty) {
        VOC findVOC = vocRepository.findById(id).get();
        penalty.changeDelivery(findVOC.getDelivery());
        findVOC.changePenalty(penalty);
        return new VOCDto(findVOC);
    }


    @Transactional
    public VOCDto updateReparation(Long id, Reparation reparation) {
        VOC findVOC = vocRepository.findById(id).get();
        findVOC.changeReparation(reparation);
        return new VOCDto(findVOC);
    }

    @Transactional
    public VOC updateObjection(Long id, boolean objection) {
        VOC findVOC = vocRepository.findById(id).get();
        findVOC.changeObjection(objection);
        return findVOC;
    }

    public List<VOCDto> findVOCs() {
        List<VOC> result = vocRepository.findAll();
        return result.stream().map(VOCDto::new).collect(Collectors.toList());
    }

    public VOCDto findVOC(Long id) {
        VOC findVOC = vocRepository.findById(id).get();
        return new VOCDto(findVOC);
    }

    public Penalty penaltyNullCheck(VOC voc) {
        if (voc.getPenalty() == null) {
            return null;
        }
        return voc.getPenalty();
    }

    public Reparation reparationNullCheck(VOC voc) {
        if (voc.getReparation() == null) {
            return null;
        }
        return voc.getReparation();
    }
}
