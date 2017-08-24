
package Livraria;

public class Capitulo {

    
    private String titulo;
    private int ISBN;
    private String texto;

/**
 *================================ Construtores ================================ 
 * @param titulo
 * @param texto 
 */    
    public Capitulo(String titulo, String texto) {
        this.titulo = titulo;
        this.texto = texto;
    }

    public Capitulo() {
    }
/**
 * =================================== toString ================================
 * @return 
 */  
    @Override
    public String toString() {
        return String.format("Capitulo:\nTitulo: %s\nISBN: %d\nTexto: %s\n", this.titulo, this.ISBN, this.texto);
    }
    
/**
 *=============================== Getters & Setters ============================  
 */    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
