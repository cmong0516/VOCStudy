package TeamFresh.voc.service;

import TeamFresh.voc.dto.Negligence;
import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import TeamFresh.voc.repository.VOCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
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
    public VOC updateVOC(Long vocId, Penalty penalty, Reparation reparation) {
        VOC findVoc = vocRepository.findById(vocId).get();
        findVoc.changePenalty(penalty);
        findVoc.changeReparation(reparation);

        return findVoc;
    }

    public List<VOCDto> findVOCs() {
        return vocRepository.findAll().stream().map(VOCDto::new).collect(Collectors.toList());
    }
}
