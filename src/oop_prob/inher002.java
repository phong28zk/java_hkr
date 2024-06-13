import java.io.*;
import java.lang.*;
import java.util.*;
import java.math.*;

class Item {
    String name;
    int weight;
    
    Item(String name) {
        this.name = name;
    }
    
    Item(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return this.name;
    }
    
    public int getWeight() {
        return this.weight;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setWeight(int weight) {
        this.weight = weight;
    }
    
    @Override
    public boolean equals(Object o) {
        if(o == this) return true;
        if(!(o instanceof Item)) return false;
        Item tmp = (Item) o;
        return (tmp.name == this.name);
    }
    
}

abstract class Box {
    abstract void add(Item item);
    abstract boolean isInBox(Item item);
}

class BoxWithMaxWeight extends Box {
    private List<Item> items = new ArrayList<Item>();
    private int maxWeight = 0;
    BoxWithMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }
    
    @Override
    public void add(Item item) {
        int totalWeight = 0;
        for(Item i : items) {
            totalWeight += i.getWeight();
        }
        if (totalWeight + item.getWeight() > maxWeight)
            return;
        items.add(item);
    }
    
    @Override
    public boolean isInBox(Item item) {
        return items.contains(item);
    }
}

public class inher002 {
    public static void main(String args[]) {
        BoxWithMaxWeight box = new BoxWithMaxWeight(10);
        box.add(new Item("Saludo", 5));
        box.add(new Item("Pirkka", 5));
        box.add(new Item("Kopi Luwak", 5));
        System.out.println(box.isInBox(new Item("Saludo")));
        System.out.println(box.isInBox(new Item("Pirkka")));
        System.out.println(box.isInBox(new Item("Kopi Luwak")));
        
    }
}