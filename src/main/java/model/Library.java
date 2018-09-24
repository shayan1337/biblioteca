package model;

import java.util.ArrayList;
import java.util.Collection;

public class Library {

    private Collection<Item> checkedOutItems;
    private Collection<Item> availableItems;

    public Library(Collection<Item> availableItems) {
        this.checkedOutItems = new ArrayList<>();
        this.availableItems = availableItems;
    }

    public Collection<String> getDetails(final ItemType itemType) {
        Collection<String> itemDetails = new ArrayList<>();

        for (Item item : availableItems) {
            if (item.getItemType() == itemType) {
                itemDetails.add(item.toString());
            }
        }
        return itemDetails;
    }

    public Item checkoutItem(String title, ItemType itemType) {
        Item checkedOutItem = null;

        for (Item item : availableItems) {
            if (item.getItemType() == itemType && item.hasTitle(title)) {
                checkedOutItem = item;
            }
        }
        checkedOutItems.add(checkedOutItem);
        availableItems.remove(checkedOutItem);
        return checkedOutItem;
    }

    public boolean returnItem(String title, ItemType itemType) {

        for (Item item : checkedOutItems) {
            if (item.getItemType() == itemType && item.hasTitle(title) && !availableItems.contains(item)) {
                availableItems.add(item);
                checkedOutItems.remove(item);
                return true;
            }
        }
        return false;
    }
}
