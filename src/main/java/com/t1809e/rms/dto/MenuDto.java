package com.t1809e.rms.dto;

import com.t1809e.rms.entity.Menu;

import java.util.List;

public class MenuDto {
    private Menu menu;
    private List<Menu> sub_menus;
    private List<String> roleNames;

    public MenuDto() {
    }

    public MenuDto(Menu menu, List<Menu> sub_menus, List<String> roleNames) {
        this.menu = menu;
        this.sub_menus = sub_menus;
        this.roleNames = roleNames;
    }


    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public List<Menu> getSub_menus() {
        return sub_menus;
    }

    public void setSub_menus(List<Menu> sub_menus) {
        this.sub_menus = sub_menus;
    }

    public List<String> getRoleNames() {
        return roleNames;
    }

    public void setRoleNames(List<String> roleNames) {
        this.roleNames = roleNames;
    }
}
