package TeamFresh.voc.dto;

import TeamFresh.voc.entity.Delivery;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(of= {"name"})
public class DeliveryDto {
    private int age;
    private String name;
    private DeliverycDto deliveryc;

    public DeliveryDto(Delivery delivery) {
        this.age = delivery.getAge();
        this.name = delivery.getName();
        this.deliveryc = new DeliverycDto(delivery.getDeliveryc());
    }
}
