import java.io.*;
import java.util.Arrays;

public class Main {

    
    public static void main(String[] args) {
    
        // lendo da entrada padrao
        try {
            BufferedReader reader = new BufferedReader(
                                        new InputStreamReader(System.in));
            String line = "";
            while ((line = reader.readLine()) != null) {   
                String[] entrada = line.split(" ");
                long start = System.nanoTime();

                //TODO: incluir chamada aqui
                
                long end = System.nanoTime();
                long time = end - start;
                    

                System.out.println("metodo " + time + " " + entrada.length);
           }

       } catch (Exception e) {}
    }  
    
}
