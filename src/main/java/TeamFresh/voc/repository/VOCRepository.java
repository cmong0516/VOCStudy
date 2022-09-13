package TeamFresh.voc.repository;

import TeamFresh.voc.entity.VOC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VOCRepository extends JpaRepository<VOC,Long> {

}
