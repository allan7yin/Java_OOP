public class Car {
    boolean engine;
    int cylinders;
    String name;
    int wheels;

    public Car(int cylinders, String name) {
        this.cylinders = cylinders;
        this.name = name;
        this.wheels = 4;
        this.engine = true;
    }

    public int getCylinders() {
        return cylinders;
    }

    public String getName() {
        return name;
    }

    public String startEngine() {
        return ("The " + this.getClass().getSimpleName() + "'s engine is starting");
    }

    public String accelerate() {
        return ("The " + this.getClass().getSimpleName() + " is accelerating");
    }

    public String brake() {
        return ("The " + this.getClass().getSimpleName() + " is braking");
    }
}
