import java.io.*;

public class Testing {
    public static void main(String[] args) throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("directions.txt");
            out = new FileOutputStream("output.txt");
            int c;
            while ((c = in.read()) != -1) { // -1 means EOF, just like C
                out.write(c); // writes c to the output file
            }
        } finally {
            if (in != null) {
                in.close();
            }

            if (out != null) {

                out.close();
            }
        }
    }
}
