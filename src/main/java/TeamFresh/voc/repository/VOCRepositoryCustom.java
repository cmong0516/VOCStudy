package TeamFresh.voc.repository;

import TeamFresh.voc.entity.VOC;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VOCRepositoryCustom {
    List<VOC> findAllFetchJoin();
}
