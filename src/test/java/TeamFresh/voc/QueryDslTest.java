package TeamFresh.voc;

import TeamFresh.voc.entity.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static TeamFresh.voc.entity.QVOC.*;

@SpringBootTest
@Transactional
public class QueryDslTest {

    @PersistenceContext
    EntityManager em;

    JPAQueryFactory queryFactory;

    @BeforeEach
    public void before() {
        queryFactory = new JPAQueryFactory(em);
    }

    @Test
    // 9개.
    public void findVOC() {
        List<VOC> fetch = queryFactory.select(vOC)
                .from(vOC)
                .fetch();

        for (VOC voc : fetch) {
            System.out.println("voc = " + voc);
        }
    }

    @Test
    // 4개.
    public void findVOCFetchJoin() {
        List<VOC> result = queryFactory.selectFrom(vOC)
                .leftJoin(vOC.client, QClient.client)
                .leftJoin(vOC.delivery, QDelivery.delivery)
                .leftJoin(vOC.penalty, QPenalty.penalty)
                .leftJoin(vOC.reparation, QReparation.reparation)
                .fetchJoin()
                .fetch();

        for (VOC voc : result) {
            System.out.println("voc = " + voc);
        }
    }

    @Test
    public void findPenaltyFetchJoin() {
        queryFactory.selectFrom(QPenalty.penalty)
                .join(QPenalty.penalty.voc,vOC)
                .fetchJoin()
                .fetch();
    }

    @Test
    public void findReparationFetchJoin() {
        queryFactory.selectFrom(QReparation.reparation)
                .join(QReparation.reparation.voc, vOC)
                .fetchJoin()
                .fetch();
    }



// objection(이의제기) true 인것만 조회.
    @Test
    public void objectionTrue() {
        List<VOC> fetch = queryFactory.selectFrom(vOC)
                .where(vOC.objection.eq(true))
                .fetch();

        for (VOC voc : fetch) {
            System.out.println("voc = " + voc);
        }
    }

}
