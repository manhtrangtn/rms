package com.t1809e.rms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.t1809e.rms.entity.Menu;

import java.util.List;

public class CommonResponse {

    @JsonProperty("menu")
    private List<Menu> menuList;
    @JsonProperty("data")
    private Object data;

    public CommonResponse() {
    }

    public CommonResponse(List<Menu> menuList, Object data) {
        this.menuList = menuList;
        this.data = data;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CommonResponse{" +
                "menuList=" + menuList +
                ", data=" + data +
                '}';
    }
}
