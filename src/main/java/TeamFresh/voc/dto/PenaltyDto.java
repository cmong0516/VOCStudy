package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Penalty;
import lombok.Data;

@Data
public class PenaltyDto {
    private boolean deliveryCheck;

    public PenaltyDto() {
    }

    public PenaltyDto(boolean deliveryCheck) {
        this.deliveryCheck = deliveryCheck;
    }

    public PenaltyDto(Penalty penalty) {

    }
}
