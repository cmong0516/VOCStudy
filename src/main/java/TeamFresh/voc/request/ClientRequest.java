package TeamFresh.voc.request;

import TeamFresh.voc.entity.Client;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientRequest {
    private String email;
    private String manager;
    private String name;
    private String phone;
}
