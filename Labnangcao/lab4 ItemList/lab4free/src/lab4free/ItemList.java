/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4free;

import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author Admin
 */


abstract class Item{
    protected int value;
    protected String creator;

    public Item() {
    }

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public abstract String input();
 
    public abstract String print();
}


class Vase extends Item{
    private int height;
    private String material;

    public Vase() {
    }

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String input() {
       return String.format("Add vase: {value=%d, creator=%s, height=%d, material=%s}",  this.value, this.creator
       , this.height, this.material);
    }

    @Override
    public String print() {
        return String.format("Vase: {value=%d, creator=%s, height=%d, material=%s}",
                this.value, this.creator, this.height, this.material);
    }
    
}


class Statue extends Item{

    private int weight;
    private String colour;

    public Statue() {
    }

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String input() {
       return String.format("Add statue: {value=%d, creator=%s, weight=%d, colour=%s}",
               this.value, this.creator, this.weight, this.colour);
    }

    @Override
    public String print() {
       return String.format("Statue: {value=%d, creator=%s, weight=%d, colour=%s}",
               this.value, this.creator, this.weight, this.colour);
    }
    
    
    
}
public class ItemList{
    public ArrayList<Item> list = new ArrayList<>();
    
    
    
    public boolean isEmpty(){
        return list.isEmpty();
    }
    
    public boolean addItem(Item item){
        if(item == null){
            return false;
        }else{
            list.add(item);
            return true;
        }
    }
    
    public String displayAll(){
        if(list.isEmpty()){
            return "Empty\n";
        }
        String result = "";
        
        for(Item item : list){
            result += item.print() + "\n";
        }
        return result;
    }
    
    public Item findItem(String creator){
        for(Item item : list){
            if(item.getCreator().equalsIgnoreCase(creator)){
                return item;
            }
        }
        return null;
    }
    
    public Item removeItem(int index){
        if(index <0 || index < list.size()){
            return null;
        }
        return list.remove(index);
    }
    
    
    public void sortItem(){
        list.sort(Comparator.comparing(Item:: getValue));
    }
   
}