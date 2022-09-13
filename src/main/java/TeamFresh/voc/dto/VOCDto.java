package TeamFresh.voc.dto;

import TeamFresh.voc.entity.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
public class VOCDto {
    // 귀책댕사자
    @NotNull
    private Enum<Negligence> negligence;
    // 귀책사유
    @NotNull
    private String reason;
    // 페널티 내용
    private Penalty penalty;
    // 이의제기 여부
    private boolean objection;
    // 배상 정보
    private Reparation reparation;
    // 고객 정보
    private ClientDto clientDto;
    // 배송기사 정보
    private DeliveryDto deliveryDto;
    // 운송사 정보
    private DeliverycDto deliverycDto;


    public VOCDto(VOC voc) {
        this.negligence = voc.getNegligence();
        this.reason = voc.getReason();
        this.penalty = voc.getPenalty();
        this.reparation = voc.getReparation();
        this.clientDto = new ClientDto(voc.getClient());
        this.objection = voc.isObjection();
        this.deliveryDto = new DeliveryDto(voc.getDelivery());
        this.deliverycDto = new DeliverycDto(voc.getDelivery().getDeliveryc());
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
