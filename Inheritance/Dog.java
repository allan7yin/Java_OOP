public class Dog extends Animal {

    private String earShape;
    private String tailShape;

    public Dog() {
        super("Mutt", "Big", 50); // super constructor must be the first statement in the child class constructor
    }

    public Dog(String type, double weight) {
        this(type, weight, "Perky", "curled"); // this calls the other defined constructor in this class, creates
                                               // default parameters as well
    }

    public Dog(String type, double weight, String earShape, String tailShape) {
        // super(type, size, weight); we can acctually create a size here
        super(type, weight < 15 ? "small" : (weight < 35 ? "medium" : "large"), weight);
        this.earShape = earShape;
        this.tailShape = tailShape;
    }

    // to make the soString method, we will need to call the super classes toString
    @Override
    public String toString() {
        return "Dog{" +
                "earShape='" + earShape + '\'' + ", tailShape='" + tailShape + '\'' + "} " + super.toString(); // need
                                                                                                               // super.toString()
    }

    // this method is also in
    public void makeNoise() {

    }

    @Override // this is a signature, not needed, but is much clearer code.
    public void move(String speed) {
        super.move(speed); // calling super class method
        // do other stuff here, since you're overriding this method
    }
}