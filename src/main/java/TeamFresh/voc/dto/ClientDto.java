package TeamFresh.voc.dto;


import TeamFresh.voc.entity.Client;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(of={"emial","manager","name","phone"})
public class ClientDto {
    private String email;
    private String manager;
    private String name;
    private String phone;

    public ClientDto(Client client) {
        this.email = client.getEmail();
        this.manager = client.getManager();
        this.name = client.getName();
        this.phone = client.getPhone();
    }
}
