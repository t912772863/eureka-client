package com.tian.dao.entity;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2018/8/3 0003.
 */
public class TestEntity implements Serializable{
    private static final long serialVersionUID = 4099876366836499710L;
    private int intValue;
    private String stringValue;
    private List<String> listValue;

    public int getIntValue() {
        return intValue;
    }

    public void setIntValue(int intValue) {
        this.intValue = intValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public List<String> getListValue() {
        return listValue;
    }

    public void setListValue(List<String> listValue) {
        this.listValue = listValue;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                ", listValue=" + listValue +
                '}';
    }
}
