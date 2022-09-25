package TeamFresh.voc.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@NoArgsConstructor
@AllArgsConstructor
@Getter
public class DeliveryCheckRequest {
    @NotNull
    private boolean objection;
}
