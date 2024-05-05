package leetcode;


import java.util.ArrayList;

public class SimpleLRUCache {
    public static void main(String[] args) {
        LRUCache myCache = new LRUCache(2);
        System.out.println("null");
        myCache.put(1,1);
        System.out.println("null");
        myCache.put(2,2);
        System.out.println("null");
        System.out.println(myCache.get(1));
        myCache.put(3,3);
        System.out.println("null");
        System.out.println(myCache.get(2));
        myCache.put(4,4);
        System.out.println("null");
        System.out.println(myCache.get(1));
        System.out.println(myCache.get(3));
        System.out.println(myCache.get(4));

    }
}



class LRUCache {
    public Integer capacity;
    ArrayList<ItemInt> items;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<ItemInt>();
    }

    public int get(int key) {
        for (int i = 0; i < items.size(); i++) {
            int currentKey = items.get(i).itemKey;
            //System.out.println(currentKey + " | " + key);

            if(currentKey == key) {
                //System.out.println("MATCH FOUND " + currentKey + " " + key);
                ItemInt replaceItem = items.get(i);
                items.remove(i);
                items.add(replaceItem);
                return replaceItem.itemValue;
            }
        }
        return -1;
    }

    public void put(int key, int value) {
        Integer currentSize = items.size();
        ItemInt newItem = new ItemInt(key, value);

        if(currentSize >= this.capacity) {
            items.remove(0);
            items.add(newItem);
        } else {
            items.add(newItem);
        }
    }

    public void displayItems() {
        System.out.println("Display Items");
        for (ItemInt item : items) {
            System.out.println(item.itemKey + ": " + item.itemValue);
        }
    }
}

class ItemInt {
    public int itemKey;
    public int itemValue;

    public ItemInt(int itemKey, int itemValue) {
        this.itemKey = itemKey;
        this.itemValue = itemValue;
    }
}


/*
    Input
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1],         [3, 3], [2], [4, 4], [1], [3], [4]]
    Output
    [null, null, null, 1, null, -1, null, -1, 3, 4]

     */
    /*

    myCache.put(3,3);


    //myCache.get("B");
    myCache.displayItems();
    int justGot = myCache.get(2);
    myCache.displayItems();
    System.out.println("GET " + justGot);
    myCache.put(4, 4);
    myCache.displayItems();
*/

