package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Reparation;
import lombok.Data;

@Data
public class ReparationDtoInVOC {
    private int price;

    public ReparationDtoInVOC(Reparation reparation) {
        this.price = reparation.getPrice();
    }
}
