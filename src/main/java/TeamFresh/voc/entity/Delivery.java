package TeamFresh.voc.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Delivery{

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryc_id")
    private Deliveryc deliveryc;

    @OneToMany(mappedBy = "delivery")
    private List<VOC> vocs = new ArrayList<>();

}
