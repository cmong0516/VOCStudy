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
@ToString
@RequiredArgsConstructor
public class VOC extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 귀책 당사자
    @NotNull
    private Negligence negligence;
    // 귀책 사유
    @NotNull
    private String reason;
    // 발급된 패널티
    @OneToOne
    @JoinColumn(name = "penalty_id")
    @JsonManagedReference
    private Penalty penalty;
    // 이의제기 여부
    private boolean objection;
    // 발급된 배상정보
    @OneToOne
    @JoinColumn(name = "reparation_id")
    @JsonManagedReference
    private Reparation reparation;
    // 배송기사 정보
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    @JsonManagedReference
    private Delivery delivery;
    // 고객사 정보
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
        penalty.setVOC(this);
    }

    public void changeReparation(Reparation reparation) {
        this.reparation = reparation;
        reparation.setVOC(this);
    }

    public void changeObjection(boolean objection) {
        this.objection = objection;
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
