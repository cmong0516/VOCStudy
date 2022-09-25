package TeamFresh.voc.dto;

import lombok.Data;

@Data
public class VOCSearchCondition {
    private Enum<Negligence> negligenceEnum;
    private boolean objection;
    private Long clientId;
    private Long deliveryId;
    private Long deliverycId;
}
