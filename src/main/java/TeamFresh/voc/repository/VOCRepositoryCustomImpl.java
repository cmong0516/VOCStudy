package TeamFresh.voc.repository;

import TeamFresh.voc.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TeamFresh.voc.entity.QVOC.*;

@Repository
@RequiredArgsConstructor
public class VOCRepositoryCustomImpl implements VOCRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;
    @Override
    public List<VOC> findAllFetchJoin() {
        return jpaQueryFactory.selectFrom(vOC)
                .join(vOC.client, QClient.client)
                .join(vOC.reparation, QReparation.reparation)
                .join(vOC.penalty, QPenalty.penalty)
                .join(vOC.delivery,QDelivery.delivery)
                .fetchJoin()
                .fetch();
    }
}
