# VOCStudy
![ClassDiagram](https://user-images.githubusercontent.com/74821906/190338793-ffdf7582-2e07-47bd-a393-20d8ee6a8023.png)



![vocERD](https://user-images.githubusercontent.com/74821906/189692981-b92e953c-2ec9-4f7b-97f6-99c6c1344495.png)

<h1>Init DB</h1>

Client<br>
Client client1 = new Client("Apple", "Kim", "010-1111-2222", "apple@gmail.com");<br>
Client client2 = new Client("Samsung","Lee","010-2222-3333","samsung@naver.com");<br>
Client client3 = new Client("Lg","Koo","010-3333-4444","lg@hanmail.com");<br>

Deliveryc<br>
Deliveryc deliveryc1 = new Deliveryc("Amazone");<br>
Deliveryc deliveryc2 = new Deliveryc("Lozen");<br>
Deliveryc deliveryc3 = new Deliveryc("Hyundae");<br>

Delivery<br>
Delivery delivery1 = new Delivery("Sam", 30);<br>
delivery1.changeDeliveryc(deliveryc1);<br>
Delivery delivery2 = new Delivery("James", 40);<br>
delivery2.changeDeliveryc(deliveryc1);<br>
Delivery delivery3 = new Delivery("Luka", 32);<br>
delivery3.changeDeliveryc(deliveryc2);<br>

<h1>1. VOC 등록</h1>
POST
localhost:8080/voc/add

Request
{
    "negligence" : "Client" or "Carrier",
    "reason" : String,
    "deliveryId" : int,
    "clientId" : int,
    "price" : int
}

Response VOC_id

<h1>2. 모든 VOC 조회</h1>
GET
localhost:8080/voc/all


Response
public static class Result<T>{
        private int count;
        private T data;
    }

<h1>3. Penalty 등록</h1>
POST
localhost:8080/voc/penalty/add/{id}

Request
{
    "price" : int
}

Response VOCDto

<h1>4. 배송 기사의 패널티 확인 여부 등록</h1>
PUT
localhost:8080/voc/penalty/delivery-check/{id}

Request VOCDto

{
    "objection" : boolean
}

Response VOCDto

<h1>5. 배상 정보 등록</h1>

localhost:8080/voc/reparation/add/{id}

Request

{
    "price" : int
}

Response VOCDto

<h1>6. 모든 Penalty 조회</h1>
GET
localhost:8080/voc/penalty/all

<h1>7. 모든 배상정보 조회</h1>
GET
localhost:8080/voc/reparation/all


<h1>FIX</h1>

VOCDto 에 Penalty , Reparation , Client, Deliver 를 Entity 로 담았더니
No serializer found for class org.hibernate.proxy.pojo.bytebuddy.ByteBuddyInterceptor and no properties discovered to create BeanSerializer
에러발생<br>
Entity -> DTO 변환

Client, Delivery, Deliveryc 해결

<h1>Error</h1>

Penalty , Reparation <br>
VOC 와 @OnetoOne 관계인 두 Entity 에 대해서 DTO 로 변환하려고 할때 NPE 발생 <br>
VOC 등록시 Penalty 는 전부 Null , Reparation 은 일부 Null 이라서 생기는 문제같음.

<h1>Error FIX</h1>

VOCDTO 생성자에서 if문으로 null 체크를 한후 changePenalty , changeReparation 메서드로 해결



<h1>Todo</h1>
1. spring.jackson.serialization.FAIL_ON_EMPTY_BEANS=false <br>
2. QueryDsl 로 모든 조회 해보기 및 최적화 <br>
3. 전체 코드 정리하기 <br>
