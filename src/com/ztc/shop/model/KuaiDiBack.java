package com.ztc.shop.model;

import java.util.List;

/**
 * Description：用来封装快递返回的数据
 * Created by ZTCJoe on 2016/10/24.
 */
public class KuaiDiBack {
    private  String EBusinessID;
    private  String ShipperCode;
    private  Integer OrderCode;
    private  String Success;
    private  String LogisticCode;
    private  String State;
    private  String Reason;
    private  List<Trace> traces;

    public Integer getOrderCode() {
        return OrderCode;
    }

    public void setOrderCode(Integer orderCode) {
        OrderCode = orderCode;
    }

    public String getReason() {
        return Reason;
    }

    public void setReason(String reason) {
        Reason = reason;
    }

    public String getEBusinessID() {
        return EBusinessID;
    }

    public String getLogisticCode() {
        return LogisticCode;
    }

    public String getShipperCode() {
        return ShipperCode;
    }

    public String getState() {
        return State;
    }

    public String getSuccess() {
        return Success;
    }

    public void setEBusinessID(String EBusinessID) {
        this.EBusinessID = EBusinessID;
    }

    public void setLogisticCode(String logisticCode) {
        LogisticCode = logisticCode;
    }

    public void setShipperCode(String shipperCode) {
        ShipperCode = shipperCode;
    }

    public void setState(String state) {
        State = state;
    }

    public void setSuccess(String success) {
        Success = success;
    }

    public List<Trace> getTraces() {
        return traces;
    }

    public void setTraces(List<Trace> traces) {
        this.traces = traces;
    }
}
