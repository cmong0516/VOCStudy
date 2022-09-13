package TeamFresh.voc.entity;

import TeamFresh.voc.request.ClientRequest;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 고객사 이름
    @NotNull
    private String name;
    // 고객사 담당자
    private String manager;
    // 고객사 담당자 연락처
    private String phone;
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<VOC> vocs = new ArrayList<>();

    public Client(String name, String manager, String phone, String email) {
        this.name = name;
        this.manager = manager;
        this.phone = phone;
        this.email = email;
    }

    public Client(ClientRequest clientRequest) {
        this.name = clientRequest.getName();
        this.manager = clientRequest.getManager();
        this.email = clientRequest.getEmail();
        this.phone = clientRequest.getPhone();
    }
}
