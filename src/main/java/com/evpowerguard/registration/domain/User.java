package com.evpowerguard.registration.domain;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import com.evpowerguard.registration.domain.enumeration.ChargerType;
import com.evpowerguard.registration.domain.enumeration.LoginType;
import com.evpowerguard.registration.domain.enumeration.MemberType;
import com.evpowerguard.registration.domain.vo.CarInfo;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import lombok.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@RestController
@RequestMapping("*")
@Setter
@Getter
@Entity
@Table(name = "ev_user_mas")
public class User {     // Entity. Domain Class.

    public User()
    {
        //setPassword(this.password);
    }

   

    @Id 
    //@GeneratedValue(strategy=GenerationType.IDENTITY)  // 기본키 생성을 데이터베이스에 위임.(SEQUENCE:시퀀스를 사용해서 기본키 할당, TABLE:키 생성 테이블을 사용함, AUTO : 데이터베이스를 변경해도 코드 수정없이 자동으로 해줌.)
    //@GenericGenerator(name="USER_GENERATOR",strategy="uuid")    //기본적으로 ID는 integer로 생성하는데 String으로 지정하려면 
    @Column(nullable=false, name = "id", length = 30)
    String id;    

    //password
    @Column(nullable=false ,name = "password")
    String password; 

    //email
    String email;

    //name
    String name;

    //phoneNumber
    String phoneNumber;

    //MemberType (customer, manager)
    @Enumerated(EnumType.STRING)    //EnumType.ORDINAL절대 사용금지(순서에 따라 버그가 발생함)
    MemberType memberType; 

    //CreateTime
    @Column(updatable=false)
    @CreationTimestamp  //생성시간 자동생성
    Date CreateTime;

    //UpdateTime
    @UpdateTimestamp  //수정시간 자동생성
    Date UpdateTime;


    //LoginTime
    @Temporal(TemporalType.TIMESTAMP)
    Date loginTime;


    //LoginFailedCount
    int loginFailedCount;


    //LoginType (Google, naver, Kakao)
    LoginType loginType;    


    //CarInfo (차량 정보 객체)
    @Embedded
    CarInfo carInfo = new CarInfo();

 
    
    @Override
    public String toString() {
        
        return "<a href='./"+this.getClass().getSimpleName().toLowerCase()+"'" + ">" + this.getClass().getSimpleName() + "</a>";
    }

    @PrePersist
    public void prePersist()
    {
        this.loginFailedCount = (this.loginFailedCount== 0 ? 0: this.loginFailedCount);    //Fail카운트값은 기본 0으로
        this.loginType = (this.loginType==null? LoginType.DEFAULT: this.loginType);        //로그인타입이 null일때는 기본 디폴트값으로.
        //this.loginTime = new Date();
    }

    
    
}
