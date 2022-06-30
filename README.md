# 로그인 서비스(계정 관리)

## 유틸리티 설치(httpie)
```
pip install httpie
```

## 스크립트 명령

- `조회` : http localhost:8080/users/wodonggun

- `등록` : http localhost:8080/users id="wodonggun" password="12345" name="우동근" phoneNumber="01037928643" memberType="CUSTOMER" carName="모하비" carNumber="123누1234" chargerType="FAST" batteryCapacity=100

- `포스트맨` : 
```
{
"id" :"wodonggun1", "password":"123123" ,
"name":"우동근",
"phoneNumber": "01037928643",
"accessType" : "MANAGER",

"carInfo": {"carName":"모하비",
			"carNumber":"123누1234",
			"chargerType":"FAST",
			"batteryCapacity":100
    }
}
```



## Pet Service 기동

- 새로운 터미널을 열어 Pet 서비스를 기동한다. (8080)
```
cd pet-domain
mvn install
mvn spring-boot:run
```
- 새로운 터미널을 열어 pet을 한 마리 등록해 줍니다.

```javasciprt
http :8080/cats name="몽이" energy=1
```

- Pet 에 먹이를 한번 줘봅니다.
```javascript
http PUT "http://localhost:8080/cats/1/feed"
```

- Pet 의 에너지가 상승함을 확인합니다.
```javascript
http "http://localhost:8080/cats/1"
```

- Pet 의 털도 한번 가꿔봅니다:
```javascript
http PUT "http://localhost:8080/cats/1/groom"
```


- Pet 의 외모지수가 상승함을 확인합니다.
```javascript
http "http://localhost:8080/cats/1"
```
<br>

## Store Service 기동

- 또 다른 터미널을 열어서 Store 서비스를 기동합니다. (8083)
```
cd store-domain
mvn spring-boot:run
```
- 유저를 한 명 등록해 줍니다.

```javascript
http localhost:8083/customers id="park@naver.com" address:='{"zipcode":"123", "detail":"용인"}'
```
![8083 유저 등록](https://user-images.githubusercontent.com/59447401/147196678-eab14a04-e885-4922-8b9c-9d8f3fdb6a9c.png)

<br>

## 입양하기
- items 에 Pet 도메인에서 등록된 애완동물들이 동기화 되어 있는 것을 확인한다:
```javascript
http :8083/items
```
- 자동으로 등록이 안되었다면 수동으로 등록을 해줘야 한다 (두마리를 등록해본다):
```javascript
http "http://localhost:8083/items" apperance=1 health=2 price:='{"currency": "KR_WON", "amount":100000}'
http "http://localhost:8083/items" apperance=2 health=1 price:='{"currency": "EURO", "amount":200}'
```

- 아까 등록한 두마리를 입양해본다. 이때는 한번의 Aggregate 이므로 한번에 등록이 되어야 한다. 
```javascript
http :8083/cartItems customer="http://localhost:8083/customers/park@naver.com" items:='["http://localhost:8083/items/1", "http://localhost:8083/items/2"]'
```
![8083 입양](https://user-images.githubusercontent.com/59447401/147196784-6281b8a0-822a-47cb-9ef1-7632b2d509be.png)

