package TeamFresh.voc.entity;

import TeamFresh.voc.dto.Negligence;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@AllArgsConstructor
public class VOC extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Negligence negligence;

    @NotNull
    private String reason;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "penalty_id")
    private Penalty penalty;

    private boolean deliveryCheck;

    private boolean objection;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reparation_id")
    private Reparation reparation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryc_id")
    @NotNull
    private Deliveryc deliveryc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    @NotNull
    private Delivery delivery;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @NotNull
    private Client client;

    public VOC(Negligence negligence, String reason) {
        this.negligence = negligence;
        this.reason = reason;
    }

    public void changePenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public void changeReparation(Reparation reparation) {
        this.reparation = reparation;
    }

    public void changeObjection(boolean objection) {
        this.objection  = objection;
    }

    public void changeDeliveryCheck(boolean deliveryCheck) {
        this.deliveryCheck = deliveryCheck;
    }

    public void changeClient(Client client) {
        this.client = client;
    }

    public void changeDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void changeDeliveryc(Deliveryc deliveryc) {
        this.deliveryc = deliveryc;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
        penalty.setVOC(this);
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
        reparation.setVOC(this);
    }

}
