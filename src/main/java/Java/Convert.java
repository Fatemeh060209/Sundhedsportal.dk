package Java;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Convert {

// Eksempel program til konvertering af et html dokument til en samling println() kald
// usage: java Convert <html file>
// opretter en .out fil indeholdende java kodestump

    private static BufferedReader in = null;
    private static String filename = "HTML";
    private static PrintWriter out = null;

    public static void main(String[] args) {
      /*  if (args.length > 0) filename = args[0];
        else System.exit(0);
       */
        try {
            in = new BufferedReader(new FileReader("/Users/fatemeh/IdeaProjects/Sundhedsportal.dk/" +
                    "src/main/java/HTML/Kalender.html"));
            out = new PrintWriter(new FileWriter(filename + ".out"));
            String l = in.readLine();
            while (l != null) {
                out.print("System.out.println(\"");
                for (int i = 0; i < l.length(); i++) {
                    char c = l.charAt(i);
                    if (c == '"') out.print("\\");
                    out.print(c);
                }
                out.println("\");");
                l = in.readLine();
            }
            out.close();
            in.close();
        } catch (Exception e) {
        }
    }
}
     