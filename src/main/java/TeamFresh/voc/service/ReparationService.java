package TeamFresh.voc.service;

import TeamFresh.voc.dto.ReparationDto;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.repository.ReparationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReparationService {

    private final ReparationRepository reparationRepository;

    @Transactional
    public Reparation saveReparation(Reparation reparation) {
        return reparationRepository.save(reparation);
    }

    public List<ReparationDto> findAll() {
        return reparationRepository.findAll().stream().map(ReparationDto::new).collect(Collectors.toList());
    }
}
