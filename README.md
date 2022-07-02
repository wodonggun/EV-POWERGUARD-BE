# 로그인 서비스(계정 관리)

## 유틸리티 설치(httpie)
- `httpie` : 콘솔창에서 http명령어를 통해서 api호출 가능. ex) http localhost:8080/users
```
pip install httpie
```


## Service 기동

- 새로운 터미널을 열어 Registration(계정관리 서비스) 서비스를 기동한다. (8080)
```
cd EV-POWERGUARD-BE
mvn clean
mvn install
mvn spring-boot:run
```
- 새로운 터미널을 열어 유저를 등록합니다.




## 스크립트 명령
- `조회` : http localhost:8080/users
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
![image](https://user-images.githubusercontent.com/35188271/176984572-e9303f8f-d367-481f-b8f9-81464dc17d68.png)



## Service 기동

- 새로운 터미널을 열어 Registration(계정관리 서비스) 서비스를 기동한다. (8080)
```
cd EV-POWERGUARD-BE
mvn clean
mvn install
mvn spring-boot:run
```
- 새로운 터미널을 열어 유저를 등록합니다.
```
http PUT "http://localhost:8080 (아래 json형태를 각 터미널환경에 맞게 매개변수로 넘겨야함. 또는 POSTMAN을 활용해서 아래의 JSON을 던지는게 편함)
{
"id" :"wodonggun@naver.com", "password":"123456789" ,
"email":"wodonggun@naver.com",
"name":"우동근",
"memberType":"MANAGER",
"phoneNumber": "01037928643",
"accessType" : "CUSTOMER",

"carInfo": {"carName":"소나타",
			"carNumber":"111하1111",
			"chargerType":"NORMAL",
			"batteryCapacity":50
	}
}
```

```javasciprt
//회원정보 전체 조회
http http://localhost:8080/api/users
```

```javasciprt
//회원정보 조회
http http://localhost:8080/api/users/wodonggun@naver.com
```


```javascript
http localhost:8083/customers id="park@naver.com" address:='{"zipcode":"123", "detail":"용인"}'
```


