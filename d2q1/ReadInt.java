
import java.io.*;

public class ReadInt {
    static public int getInt(String str) {
        System.out.print(str);
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            return Integer.parseInt(in.readLine());
        }
        catch (Exception e) {
            System.out.println("Erreur de lecture " + e.getMessage());
            System.exit(-1);
        }
        return 0; 
    } 
}


