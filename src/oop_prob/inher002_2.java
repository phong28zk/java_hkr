import java.io.*;
import java.lang.*;
import java.math.*;
import java.util.*;

class Item {
    private String name;
    private int weight;
    
    Item(String name) {
        this.name = name;
    }
    
    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName(){
        return this.name;
    }
    public void setName(String name) {
		this.name = name;
    }
    public int getWeight() {
        return this.weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Item)) return false;
        Item tmp = (Item) o;
        return (tmp.name == this.name);
    }
}

abstract class Box {
    public abstract void add(Item item);
    public abstract boolean isInBox(Item item);
}

class BoxWithMaxWeight extends Box {
    private List<Item> items = new ArrayList<Item>();
    private int maxWeight = 0;
    
    public BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Override
    public void add(Item item) {
        int totalWeight = 0;
        for(Item i : items) {
            totalWeight += i.getWeight();
        }
        // System.out.println(this.maxWeight);
        if(totalWeight + item.getWeight() > this.maxWeight)
            return;
        items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }   
}

public class inher002_2 {
    public static void main(String[] args) {
        BoxWithMaxWeight box = new BoxWithMaxWeight(10);
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));
        box.add(new Item("Kopi Luwak", 5));
        // for(Item i : box.items) {
        //     System.out.println(i.getName());
        // }
        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));
        System.out.println(box.isInBox(new Item("Kopi Luwak")));
    }
}
