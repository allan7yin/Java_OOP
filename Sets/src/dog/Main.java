package dog;

/**
 * Created by dev on 17/01/2016.
 */
public class Main {
    public static void main(String[] args) {
        Labradour rover = new Labradour("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));
        System.out.println(rover.equals(rover2));
    }
}
