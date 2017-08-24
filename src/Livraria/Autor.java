package Livraria;

import java.time.LocalDate;

public class Autor {

    private String nome;
    private LocalDate dataNascimento;
/**
 *================================ Construtor ==================================
 */
    
    public Autor(String nome) {
        this.nome = nome;
    }
    
/**
 * =================================== toString ================================
 * @return 
 */
    @Override
    public String toString() {
        return String.format("Autor:\nNome: %s\nData de nascimento: %s\n", this.nome, this.dataNascimento);
    }
    
/**
 *============================ Getters & Setters =============================== 
 */    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
        
}
