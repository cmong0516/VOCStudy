package TeamFresh.voc;

import TeamFresh.voc.dto.Negligence;
import TeamFresh.voc.entity.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    private final InitService initService;

    @PostConstruct
    public void init() {
        initService.init();
    }

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService {

        private final EntityManager em;

        public void init() {

            Client client1 = new Client("Apple", "Kim", "010-1111-2222", "apple@gmail.com");
            Client client2 = new Client("Samsung","Lee","010-2222-3333","samsung@naver.com");
            Client client3 = new Client("Lg","Koo","010-3333-4444","lg@hanmail.com");

            em.persist(client1);
            em.persist(client2);
            em.persist(client3);

            Deliveryc deliveryc1 = new Deliveryc("Amazone");
            Deliveryc deliveryc2 = new Deliveryc("Lozen");
            Deliveryc deliveryc3 = new Deliveryc("Hyundae");

            em.persist(deliveryc1);
            em.persist(deliveryc2);
            em.persist(deliveryc3);

            Delivery delivery1 = new Delivery("Sam", 30);
            delivery1.changeDeliveryc(deliveryc1);
            Delivery delivery2 = new Delivery("James", 40);
            delivery2.changeDeliveryc(deliveryc1);
            Delivery delivery3 = new Delivery("Luka", 32);
            delivery3.changeDeliveryc(deliveryc2);

            em.persist(delivery1);
            em.persist(delivery2);
            em.persist(delivery3);

            VOC voc1 = new VOC(client1,Negligence.CARRIER,"배송 지연",delivery1);
            VOC voc2 = new VOC(client1,Negligence.CLIENT, "제품 누락",delivery1);
            VOC voc3 = new VOC(client2,Negligence.CARRIER, "제품 파손",delivery2);
            VOC voc4 = new VOC(client3,Negligence.CLIENT, "잘못된 제품 배송",delivery3);

            Penalty penalty1 = new Penalty(true);
            Penalty penalty2 = new Penalty(true);

            voc1.changePenalty(penalty1);
            voc2.changePenalty(penalty2);

            em.persist(penalty1);
            em.persist(penalty2);

            em.persist(voc1);
            em.persist(voc2);
            em.persist(voc3);
            em.persist(voc4);


        }

    }

}
