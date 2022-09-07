package TeamFresh.voc.dto;


import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class VOCDto {
    @NotNull
    private Negligence negligence;
    @NotNull
    private String reason;
    private Penalty penalty;
    private boolean deliverCheck;
    private boolean objection;
    private Reparation reparation;

    public VOCDto(VOC voc) {
        this.negligence = voc.getNegligence();
        this.reason = voc.getReason();
        this.penalty = voc.getPenalty();

        this.reparation = voc.getReparation();

    }
}
