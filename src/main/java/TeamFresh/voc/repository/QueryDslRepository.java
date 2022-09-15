package TeamFresh.voc.repository;

import TeamFresh.voc.dto.PenaltyDto;
import TeamFresh.voc.dto.VOCDto;
import TeamFresh.voc.entity.*;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static TeamFresh.voc.entity.QPenalty.*;
import static TeamFresh.voc.entity.QVOC.vOC;

@Repository
@RequiredArgsConstructor
public class QueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public List<VOCDto> findAllVOC() {
        List<VOCDto> result = queryFactory.select(Projections.constructor(VOCDto.class, vOC))
                .from(vOC)
                .leftJoin(vOC.client, QClient.client)
                .leftJoin(vOC.delivery, QDelivery.delivery)
                .leftJoin(vOC.penalty, penalty)
                .leftJoin(vOC.reparation, QReparation.reparation)
                .fetchJoin()
                .fetch();
        return result;
    }

    public List<PenaltyDto> findAllPenalty() {
        List<PenaltyDto> result = queryFactory.select(Projections.constructor(PenaltyDto.class, penalty))
                .from(penalty)
                .leftJoin(penalty.voc, vOC)
                .fetchJoin()
                .fetch();

        return result;
    }

    public VOCDto findVOC(Long id) {
        return queryFactory.select(Projections.constructor(VOCDto.class, vOC))
                .from(vOC)
                .leftJoin(vOC.penalty, QPenalty.penalty)
                .leftJoin(vOC.delivery, QDelivery.delivery)
                .leftJoin(vOC.reparation, QReparation.reparation)
                .leftJoin(vOC.client, QClient.client)
                .fetchJoin()
                .where(vOC.id.eq(id))
                .fetchOne();
    }

}
