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
    @GeneratedValue
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
    private Deliveryc deliveryc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

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

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
        penalty.setVOC(this);
    }

}
