package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    private String manager;
    private String phone;
    private String email;

    @OneToOne(mappedBy = "client",fetch = FetchType.LAZY)
    @JsonBackReference
    private VOC voc;

    public Client(String name, String manager, String phone, String email) {
        this.name = name;
        this.manager = manager;
        this.phone = phone;
        this.email = email;
    }
}
