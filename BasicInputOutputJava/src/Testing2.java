import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Testing2 {
    public static void main(String[] args) throws IOException {
        char[] message  = { 'h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd', '!'};
        char[] newMessage = {'E', 'a', 'r', 't', 'h'};

        long filePointer = 7 * Character.BYTES;
        boolean EOF = false;

        // now, we need to indicate whether we want to use RandomAccessFile woth read only, or read+write
        // rw -> if the file does not exist, the file is created
        // rw -> if the file does exist, its contents are overwritten
        // r -> if the file does not exist, a FileNotFoundException is thrown
        // r -> if we try and write to the file, IOException is thrown

        try(RandomAccessFile randomFile = new RandomAccessFile("Messages.txt", "rw")) {
            for (char letter: message) {
                randomFile.writeChar(letter);
            }

            randomFile.seek(filePointer); // this looks for this particular area inside of the file

            for (char letter: newMessage) {
                randomFile.writeChar(letter);
            }

            randomFile.seek(0);

            // now that we have preformed the seek() method, we are now at the place where filePointer is, which in this case, is beginning of the file
            while (!EOF) {
                try {
                    System.out.print(randomFile.readChar()); // we are reading from the position of filePointer
                } catch (EOFException e) {
                    EOF = true;
                }
            }
        }
    }
}
