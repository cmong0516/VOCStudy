# VOCStudy
![voc](https://user-images.githubusercontent.com/74821906/189686547-29f2a492-5900-48ec-8043-ae4fa534436d.png)

<h1>1. 모든 VOC 조회</h1>
localhost:8080/voc/all

<h1>2. voc 등록</h1>
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

<h1>3. Penalty 등록</h1>
localhost:8080/voc/penalty/add/{id}

Request
{
    "price" : int
}

Response VOCDto

<h1>4. 배송 기사의 패널티 확인 여부 등록</h1>

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
