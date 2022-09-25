package TeamFresh.voc.dto;

import TeamFresh.voc.entity.*;
import com.querydsl.core.annotations.QueryProjection;
import com.sun.istack.NotNull;
import lombok.*;


@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class VOCDto {
    // 귀책댕사자
    @NotNull
    private Enum<Negligence> negligence;
    // 귀책사유
    @NotNull
    private String reason;
    // 페널티 내용
    private PenaltyDtoInVOC penalty;
    // 이의제기 여부
    private boolean objection;
    // 배상 정보
    private ReparationDtoInVOC reparation;
    // 고객 정보
    private ClientDto client;
    // 배송기사 정보
    private DeliveryDto delivery;
    // 운송사 정보
    // 배송기사에 포함
//    private DeliverycDto deliverycDto;

    @QueryProjection
    public VOCDto(VOC voc) {
        this.negligence = voc.getNegligence();
        this.reason = voc.getReason();
        this.client = new ClientDto(voc.getClient());
        this.objection = voc.isObjection();
        this.delivery = new DeliveryDto(voc.getDelivery());
//        this.deliverycDto = new DeliverycDto(voc.getDelivery().getDeliveryc());
        if (voc.getPenalty() != null) {
            changePenalty(voc.getPenalty());
        }
        if (voc.getReparation() != null) {
            chagneReparation(voc.getReparation());
        }
    }

    @Getter
    @AllArgsConstructor
    public static class UpdateDeliveryCheck {
        private Long id;
        private boolean deliveryCheck;
    }

    public void changePenalty(Penalty penalty) {
        this.penalty = new PenaltyDtoInVOC(penalty);
    }

    public void chagneReparation(Reparation reparation) {
        this.reparation = new ReparationDtoInVOC(reparation);
    }

}
