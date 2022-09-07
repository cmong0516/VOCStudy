package TeamFresh.voc.service;

import TeamFresh.voc.dto.ReparationDto;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.repository.ReparationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReparationService {

    private final ReparationRepository reparationRepository;

    @Transactional
    public Long saveReparation(Reparation reparation) {
        Reparation save = reparationRepository.save(reparation);
        return save.getId();
    }

    public Optional<Reparation> findById(Long reparationId) {
        return reparationRepository.findById(reparationId);
    }

    public List<ReparationDto> findAll() {
        return reparationRepository.findAll().stream().map(ReparationDto::new).collect(Collectors.toList());
    }
}
