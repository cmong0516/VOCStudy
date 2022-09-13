package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Deliveryc;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(of={"name"})
public class DeliverycDto {
    private String name;

    public DeliverycDto(Deliveryc deliveryc) {
        this.name = deliveryc.getName();
    }
}
