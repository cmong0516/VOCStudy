package TeamFresh.voc.entity;

import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Client {

    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    private String name;
    private String manager;
    private String phone;
    private String email;

    public Client(String name, String manager, String phone, String email) {
        this.name = name;
        this.manager = manager;
        this.phone = phone;
        this.email = email;
    }
}
