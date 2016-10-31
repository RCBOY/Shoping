package com.ztc.shop.model;

/**
 * Description：快递中转情况的封装
 * Created by ZTCJoe on 2016/10/24.
 */
public class Trace {
    private String AcceptTime;
    private String AcceptStation;
    private String Location;
    private String Action;

    public String getAcceptStation() {
        return AcceptStation;
    }

    public String getAcceptTime() {
        return AcceptTime;
    }

    public String getAction() {
        return Action;
    }

    public String getLocation() {
        return Location;
    }

    public void setAcceptStation(String acceptStation) {
        AcceptStation = acceptStation;
    }

    public void setAcceptTime(String acceptTime) {
        AcceptTime = acceptTime;
    }

    public void setAction(String action) {
        Action = action;
    }

    public void setLocation(String location) {
        Location = location;
    }
}
