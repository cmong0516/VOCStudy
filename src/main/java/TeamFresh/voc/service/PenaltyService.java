package TeamFresh.voc.service;

import TeamFresh.voc.dto.PenaltyDto;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.repository.PenaltyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PenaltyService {

    private final PenaltyRepository penaltyRepository;

    @Transactional
    public Penalty savePenalty(Penalty penalty) {
        return penaltyRepository.save(penalty);

    }

    public List<PenaltyDto> findAll() {
        List<Penalty> all = penaltyRepository.findAll();
        return all.stream().map(PenaltyDto::new).collect(Collectors.toList());
    }
}
