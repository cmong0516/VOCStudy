package TeamFresh.voc.service;

import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.repository.QueryDslRepository;
import TeamFresh.voc.repository.VOCRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class VOCService {

    private final VOCRepository vocRepository;
    private final QueryDslRepository queryDslRepository;

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
//        VOC findVOC = vocRepository.findById(id).get();
        VOC findVOC = queryDslRepository.findVOC(id);
        findVOC.changeObjection(objection);
        return findVOC;
    }

    public List<VOCDto> findVOCs() {
//        return vocRepository.findAll().stream().map(VOCDto::new).collect(Collectors.toList());
        return queryDslRepository.findAllVOC();
//                .stream().map(VOCDto::new).collect(Collectors.toList());
    }

    public VOCDto findVOC(Long id) {
//        VOC findVOC = vocRepository.findById(id).get();
//        return new VOCDto(findVOC);
        return queryDslRepository.findVOCDto(id);
    }
}
