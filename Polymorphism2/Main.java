import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Movie theMovie = Movie.getMovie("Science", "Star Wars");
        // theMovie.watchMovie();

        // Scanner s = new Scanner(System.in);
        // while (true) {
        // System.out.print("Enter Type (A for Adventure, C for Comedy, " +
        // "S for Science Fiction, or Q to quit): ");
        // String type = s.nextLine();

        // if ("Qq".contains(type)) {
        // break;
        // }

        // System.out.print("Enter Movie Title: ");
        // String title = s.nextLine();
        // Movie movie = Movie.getMovie(type, title); // this method of the Movie class
        // then creates an object of the
        // // type parameter, and returns it, kind of similar to the factory
        // // design pattern
        // movie.watchMovie(); // this then, at runtime, JVM is able to discern that
        // this is actually an action
        // // object, which inherits from Movie, and calls it's overriden method
        // }

        Adventure jaws = (Adventure) Movie.getMovie("A", "Jaws");
        jaws.watchMovie();
        Adventure jaws2 = (Adventure) Movie.getMovie("C", "Jaws2");
        jaws2.watchMovie();

    }
}
