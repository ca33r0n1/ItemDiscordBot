package net.projectrefresh.Items;

import lombok.Getter;
import lombok.Setter;

public enum DnDItems {
    //Pending Item
            ;

    @Getter
    private final String lable;

    @Getter
    private final String url;

    @Getter
    @Setter
    private boolean claimed;

    DnDItems(String Name, String url) {
        this.lable = Name;
        this.url = url;
    }
}
