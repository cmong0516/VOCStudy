package TeamFresh.voc.repository;

import TeamFresh.voc.dto.*;
import TeamFresh.voc.entity.*;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;

import static TeamFresh.voc.entity.QClient.*;
import static TeamFresh.voc.entity.QDelivery.*;
import static TeamFresh.voc.entity.QPenalty.*;
import static TeamFresh.voc.entity.QReparation.*;
import static TeamFresh.voc.entity.QVOC.vOC;

@Repository
@RequiredArgsConstructor
public class QueryDslRepository {

    private final JPAQueryFactory queryFactory;

    public List<VOCDto> findAllVOC() {
        List<VOCDto> result = queryFactory.select(Projections.constructor(VOCDto.class, vOC))
                .from(vOC)
                .leftJoin(vOC.client, client)
                .leftJoin(vOC.delivery, delivery)
                .leftJoin(vOC.penalty, penalty)
                .leftJoin(vOC.reparation, reparation)
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

    public VOCDto findVOCDto(Long id) {
        return queryFactory.select(Projections.constructor(VOCDto.class, vOC))
                .from(vOC)
                .leftJoin(vOC.penalty, QPenalty.penalty)
                .leftJoin(vOC.delivery, delivery)
                .leftJoin(vOC.reparation, reparation)
                .leftJoin(vOC.client, client)
                .fetchJoin()
                .where(vOC.id.eq(id))
                .fetchOne();
    }

    public VOC findVOC(Long id) {
        return queryFactory.select(vOC)
                .from(vOC)
                .leftJoin(vOC.penalty, QPenalty.penalty)
                .leftJoin(vOC.delivery, delivery)
                .leftJoin(vOC.reparation, reparation)
                .leftJoin(vOC.client, client)
                .fetchJoin()
                .where(vOC.id.eq(id))
                .fetchOne();
    }

    public Delivery findDelivery(Long id) {
        return queryFactory.selectFrom(delivery)
                .leftJoin(delivery.deliveryc,QDeliveryc.deliveryc)
                .fetchJoin()
                .where(delivery.id.eq(id))
                .fetchOne();
    }

//    public List<VOCDto> search(VOCSearchCondition condition) {
//        return queryFactory
//                .select(new QVOCDto(
//                        vOC
//                        ))
//                .from(vOC)
//                .leftJoin(vOC.reparation, reparation)
//                .leftJoin(vOC.penalty, penalty)
//                .leftJoin(vOC.client, client)
//                .leftJoin(vOC.delivery, delivery)
//                .where(negligenceEq(condition.getNegligenceEnum()),
//                        clientEq(condition.getClientId()),
//                        deliveryEq(condition.getDeliveryId()),
//                        deliverycEq(condition.getDeliverycId())
//                        )
//
//
//    }

    private BooleanExpression negligenceEq(Enum<Negligence> negligenceEnum) {
        return StringUtils.hasText(String.valueOf(negligenceEnum)) ? vOC.negligence.eq((Negligence) negligenceEnum) : null;
    }

}
