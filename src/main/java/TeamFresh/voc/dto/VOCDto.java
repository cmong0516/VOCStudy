package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Client;
import TeamFresh.voc.entity.Penalty;
import TeamFresh.voc.entity.Reparation;
import TeamFresh.voc.entity.VOC;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class VOCDto {
    @NotNull
    private Enum<Negligence> negligence;
    @NotNull
    private String reason;
    private Penalty penalty;
    private boolean deliverCheck;
    private boolean objection;
    private Reparation reparation;
    private Client client;

    public VOCDto(VOC voc) {
        this.negligence = voc.getNegligence();
        this.reason = voc.getReason();
        this.penalty = voc.getPenalty();
        this.reparation = voc.getReparation();
        this.client = voc.getClient();
    }

    @Getter
    @AllArgsConstructor
    public static class UpdateDeliveryCheck{
        private Long id;
        private boolean deliveryCheck;

    }

    public VOCDto() {
    }
}
