package TeamFresh.voc.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeliveryCheckRequest {
    private Long id;
    private boolean deliveryCheck;
}
