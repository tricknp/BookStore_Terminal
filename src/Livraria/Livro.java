
package Livraria;

import java.util.ArrayList;
import java.util.List;

public class Livro {

    private String titulo;
    private int ISBN;


    private final int limiteCap = 100; //limite dos capitulos
    private final int limiteAutores = 6; // limite de autores       
    
    List <Capitulo> capitulosList = new ArrayList<Capitulo>();
    List <Autor> autoresList = new ArrayList<Autor>();
    
/**
 *================================ Construtor ================================== 
 * @param titulo
 * @param ISBN 
 */
    public Livro(String titulo, int ISBN) {
        this.titulo = titulo;
        this.ISBN = ISBN;
    }
    
/**
 * =================================== toString ================================
 * @return 
 */    
    @Override
    public String toString() {
        return String.format("Livro:\nTitulo: %s\nISBN: %s\n", this.titulo, this.ISBN);
    }
/**
 *======================= Método para adicionar o capitulo =====================
 *  Se o tamanho da lista de capitulos for maior ou igual ao limite de capitulos 
 * ele retorna -1 
 */    
        
  public int adicionarCapitulo(String titulo, String texto){
      if (capitulosList.size() >= limiteCap) {
          return -1;
      }
      
      Capitulo capitulo = new Capitulo();
      capitulosList.add(capitulo);
      
      return capitulosList.lastIndexOf(capitulo);
  }   
  
    /**
 *========================= Método para remover capitulo =======================
 *  Se o capitulo não existir ele retorna -1, se não, ele remove o capitulo da 
 * lista de capitulos
 */  
    
    public int removerCapitulo(Capitulo capitulo){
        int x = 0;
        
        if (capitulosList.contains(capitulo)) {
            for (int i = 0; i < capitulosList.size(); i++) {
                if (capitulosList.get(i).equals(capitulo)) {
                    capitulosList.remove(i);
                    x = i;
                }
            }   
            return x;
        }else{
            return -1;
        }    
    }

/**
 *========================== Método para remover o autor =======================
 *  Se não existir o autor na lista de autores ele retorna -1,caso contrario,
 * remove o autor
 */    
    
    public int removerAutor(Autor autor){
        int x = 0;
        if (autoresList.contains(autor)) {
            for (int i = 0; i < autoresList.size(); i++) {
                if (autoresList.get(i).equals(autor)) {
                    autoresList.remove(autor);
                    x = i;
                }
            }
            return x;
        }else{
            return -1;
        }
        
    }
/**
 *========================= Método para adicionar o autor ======================
 *  Verifica se a lista de autores não esta cheia, se estiver cheia retorna -1.
 * Se a lista de autores ja conter o autor selecionado ele também retorna -1, 
 * caso contrario, ele adiciona o autor e retorna a posição dele.
 */    
    
     public int adicionarAutor(Autor autor){
         if (autoresList.size() >= limiteAutores) {                
            return -1;
         } 
         
         for (int i = 0; i < autoresList.size(); i++) {
             if (autoresList.get(i).getNome().equals(autor.getNome())) {
                 return -1;
             }else{
                 autoresList.add(autor);
                 return autoresList.lastIndexOf(autor);
             }
         }
        return 0; //---
    }


     
/**
 *============================= Getters & Setters ============================== 
 */    
     
    public List<Capitulo> getCapitulosList() {
        return capitulosList;
    }

    public void setCapitulosList(List<Capitulo> capitulosList) {
        this.capitulosList = capitulosList;
    }

    public List<Autor> getAutoresList() {
        return autoresList;
    }

    public void setAutoresList(List<Autor> autoresList) {
        this.autoresList = autoresList;
    }
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    
    
    
}
