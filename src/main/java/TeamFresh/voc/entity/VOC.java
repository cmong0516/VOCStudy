package TeamFresh.voc.entity;

import TeamFresh.voc.dto.Negligence;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class VOC extends BaseEntity{
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private Negligence negligence;
    @NotNull
    private String reason;
    @OneToOne
    @JoinColumn(name = "penalty_id")
    private Penalty penalty;
    private boolean deliverCheck;
    private boolean objection;
    @OneToOne
    @JoinColumn(name = "reparation_id")
    private Reparation reparation;

    public void changePenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public void changeReparation(Reparation reparation) {
        this.reparation = reparation;
    }

}
