package Utilidade;

import java.io.IOException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

   private static final Scanner input = new Scanner(System.in);

   
/**
 * ========================== Método para ler uma String =======================
     * @param mensagem
     * @return 
 */   
    public static String leString(String mensagem) {
        String x;
        
        Scanner in = new Scanner(System.in);
        System.out.print(mensagem);
        x = in.nextLine();
        
        return x;
    }
    
/**
 * ========================= Método para ler um int ============================ 
     * @param mensagem
     * @return 
     * @throws java.lang.Exception
 */    
    public static int leInt(String mensagem) throws Exception {
        int x = 0;
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(mensagem);
            x = input.nextInt();
        } catch (InputMismatchException ex) {
            throw new IOException("entrada inválida");
        }
        return x;
    }
    
/**
 * ========================= Método para ler um double =========================
 */    
    public static double leDouble(String texto){
        input.nextLine();
        System.out.print(texto);
        return input.nextDouble();
    }
/**
 * ========================= Método para ler o LocalDate =======================
 */
    public static LocalDate leLocalDate(String mensagem) throws Exception {    
        try {
            String[] partesData = leString(mensagem).split("/");
            return LocalDate.of(Integer.parseInt(partesData[2]), Integer.parseInt(partesData[1]), Integer.parseInt(partesData[0]));
        } catch (Exception ex) {
            throw new Exception("Formato inválido para Data. Use dd/mm/aaaa");
        }
    }
    
}
