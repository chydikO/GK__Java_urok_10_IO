package org.example;

import java.io.*;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * ObjectInputStream и ObjectOutputStream
 */
public class App006 {
    public static void main(String[] args) {
        OutputStream out = null;
        ObjectOutputStream objectOutput = null;
        try {
            out = new FileOutputStream(new File("outputApp006.txt"));
            objectOutput = new ObjectOutputStream(out);
            Car car1 = new Car("Vaz", "2010", 165);
            objectOutput.writeObject(car1);
        } catch (Exception exception) {
            Logger.getLogger(App006.class.getName()).log(Level.SEVERE, null, exception);
        } finally {
            try {
                assert out != null;
                out.close();
                assert objectOutput != null;
                objectOutput.close();
            } catch (IOException exception) {
                Logger.getLogger(App006.class.getName()).log(Level.SEVERE, null, exception);
            }
        }

        //TODO: read object from file -> outputApp006.txt
    }

    private interface CarSerializable extends Serializable {
        void writeObject(ObjectOutputStream out) throws Exception;
        void readObject(ObjectInputStream in) throws Exception;
    }

    public static class Car implements CarSerializable {
        @Serial
        private static final long serialVersionUID = 3979478643232271346L;
        private String name;
        private String year;
        private int speed;

        public Car(String name, String year, int speed) {
            this.name = name;
            this.year = year;
            this.speed = speed;
        }

        public String getName() {
            return name;
        }

        public String getYear() {
            return year;
        }

        public int getSpeed() {
            return speed;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        @Override
        public void writeObject(ObjectOutputStream out) throws Exception {
            out.writeUTF(name);
            out.writeUTF(year);
            out.writeInt(speed);
        }

        @Override
        public void readObject(ObjectInputStream in) throws Exception {
            name = in.readUTF();
            year = in.readUTF();
            speed = in.readInt();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Car other)) {
                return false;
            }
            return Objects.equals(name, other.name) &&
                    Objects.equals(year, other.year) &&
                    speed == other.speed;
        }

        @Override
        public String toString() {
            return "Car -> name=" + name + ", year= " + year + ", speed=" + speed;
        }
    }
}