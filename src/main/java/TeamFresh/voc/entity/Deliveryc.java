package TeamFresh.voc.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Deliveryc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 운송사 이름
    @NotNull
    private String name;
    // 운송사에 소속된 배송기사 List
    @OneToMany(mappedBy = "deliveryc")
    @JsonManagedReference
    private List<Delivery> deliveryList = new ArrayList<>();


    public Deliveryc(String name) {
        this.name = name;
    }
}
