package model;

import java.util.Collection;

public interface Item {

    Collection<String> getDetails();

    ItemType getItemType();

    boolean hasTitle(String title);
}
