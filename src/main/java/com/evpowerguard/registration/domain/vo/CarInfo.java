package com.evpowerguard.registration.domain.vo;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import org.springframework.util.Assert;
import com.evpowerguard.registration.domain.enumeration.ChargerType;

import lombok.*;

//@Embadded //Embaded는 Embeddable안에 또 다른 임베디드를 삽입할때 씀.
//@AttributeOverride // 같은 임베디드가 두개이상 들어갈때 컬럼명이 중복되기때문에 사용.
@Embeddable
@Getter
public class CarInfo {

    //@Builder해서 By넣는 이유..?
    //@Builder(builderClassName = "ByReporterIdBuilder", builderMethodName = "ByReporterIdBuilder")
    private String carNumber;
    private String carName;
    private String chargerType;
    private String batteryCapacity;

    public CarInfo()
    {
        ;
    }


    public CarInfo(String carNumber,String carName, String chargerType, String batteryCapacity)
    {
        //Assert.notNull(id, "CarInfo 없음.");
        this.carNumber = carNumber;
        this.carName = carName;
        this.chargerType = chargerType;
        this.batteryCapacity = batteryCapacity;
    }
    
  
}
