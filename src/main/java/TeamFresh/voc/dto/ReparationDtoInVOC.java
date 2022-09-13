package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Reparation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReparationDtoInVOC {
    private int price;

    public ReparationDtoInVOC(Reparation reparation) {
        this.price = reparation.getPrice();
    }
}
