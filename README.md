# VOCStudy
![ClassDiagram](https://user-images.githubusercontent.com/74821906/189953617-32141d0d-8089-4191-8877-aff246c06200.png)

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

Penalty , Reparation 
-> PenaltyDtoInVOC , ReparationDtoInVOC 두개의 새로운 DTO 를 만들어서 해결.
