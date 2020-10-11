package com.t1809e.rms.dto;

import com.t1809e.rms.entity.Menu;

import java.util.List;

public class MenuDto {
    private Menu menu;
    private List<String> roleNames;

    public MenuDto() {
    }

    public MenuDto(Menu menu, List<String> roleNames) {
        this.menu = menu;
        this.roleNames = roleNames;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
