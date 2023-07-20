package org.example;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class FishEx implements Externalizable {
    private String name;
    private double weight;
    private double price;

    public FishEx() {
    }

    public FishEx(String name, double weight, double price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(this.name);
        out.writeDouble(this.weight);
        out.writeDouble(this.price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.name=in.readUTF();
        this.weight=in.readDouble();
        this.price=in.readDouble();
    }

    @Override
    public String toString() {
        return "FishEx ->  name= " + name + ", weight=" + weight + ", price=" + price;
    }
}
