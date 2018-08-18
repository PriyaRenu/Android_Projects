package com.example.priya.remaider_alarm;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Remain {
    String medicineName;
    String morngTime;
    String aftnTime;
    String eveTime;
    String ni8Time;
    public Remain() {
    }
   public Remain(String medicineName, String morngTime, String aftnTime,
                 String eveTime, String ni8Time)
    {
       // medicineName="Dola";
        System.out.println(medicineName);
       this.medicineName=medicineName;
       this.morngTime=morngTime;
       this.aftnTime=aftnTime;
       this.eveTime=eveTime;
       this.ni8Time=ni8Time;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineNamme) {
        this.medicineName = medicineNamme;
    }

    public String getMorngTime() {
        return morngTime ;
    }

    public void setMorngTime(String morngTime ) {
        this.morngTime = morngTime;
    }


    public String getAftnTime() {
        return aftnTime;
    }

    public void setAftnTime(String aftnTime) {
        this.aftnTime = aftnTime;
    }

    public String getEveTime() {
        return eveTime;
    }

    public void setEveTime(String eveTime) {
        this.eveTime = eveTime;
    }
    public String getNi8Time() {
        return ni8Time;
    }

    public void setNi8Time(String ni8Time) {
        this.ni8Time = ni8Time;
    }
    @Exclude
    public Map<String,Object> toMap()
    {
        HashMap<String, Object> result = new HashMap<>();
        result.put("Medicine_Name", medicineName);
        result.put("Morning",morngTime );
        result.put("Afternoon", aftnTime);
        result.put("Evening",eveTime);
        result.put("Night",ni8Time);
        return result;
    }
}
