package TeamFresh.voc.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Delivery{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // 배송기사 이름
    @NotNull
    private String name;
    // 배송기사 나이
    @NotNull
    private int age;
    // 배송기사 소속 운송사
    // cascadeAll 을 적용하면 의도와 다르게 동작할 가능성이 있다.
//    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deliveryc_id")
    @JsonBackReference
    private Deliveryc deliveryc;
    // 배송한 VOC List
    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private List<VOC> vocs = new ArrayList<>();
    // 발급한 Penalty List
    @OneToMany(mappedBy = "delivery")
    @JsonBackReference
    private List<Penalty> penaltyList = new ArrayList<>();

    public Delivery(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void changeDeliveryc(Deliveryc deliveryc) {
        this.deliveryc = deliveryc;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", deliveryc=" + deliveryc +
                '}';
    }
}
