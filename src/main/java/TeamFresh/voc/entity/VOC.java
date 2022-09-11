package TeamFresh.voc.entity;

import TeamFresh.voc.dto.Negligence;
import TeamFresh.voc.request.VOCRequest;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.*;

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

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "penalty_id")
    @JsonManagedReference
    private Penalty penalty;

    private boolean deliveryCheck;

    private boolean objection;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reparation_id")
    @JsonManagedReference
    private Reparation reparation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    @JsonManagedReference
    private Delivery delivery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    @NotNull
    @JsonManagedReference
    private Client client;

    public VOC(Client client, Negligence negligence, String reason, Delivery delivery) {
        this.client = client;
        this.negligence = negligence;
        this.reason = reason;
        this.delivery = delivery;
    }

    public VOC(VOCRequest vocRequest) {
        this.negligence = Negligence.valueOf(vocRequest.getNegligence());
        this.reason = vocRequest.getReason();
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

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
        penalty.setVOC(this);
    }

    public void setReparation(Reparation reparation) {
        this.reparation = reparation;
        reparation.setVOC(this);
    }

}
