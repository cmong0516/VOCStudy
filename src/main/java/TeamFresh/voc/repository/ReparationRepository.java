package TeamFresh.voc.repository;

import TeamFresh.voc.entity.Reparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReparationRepository extends JpaRepository<Reparation,Long> {
}
