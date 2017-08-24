package Livraria;

import Utilidade.Util;
import java.util.ArrayList;
import java.util.List;

public class Livraria {

    private final int limiteLivros = 500;
    
    List <Livro> livroList = new ArrayList<Livro>();
    
/**
 * ============================== Construtor ===================================
 * @throws InterruptedException 
 */    
        public Livraria() throws InterruptedException, Exception {
        
        List <Livro> livroList = new ArrayList<Livro>();
        menu();
    }

/**
 * =================================== toString ================================
 * @return 
 */
    @Override
    public String toString() {
        return String.format("Livraria:\nLista de livros: %d\n",livroList);
    }

/**
 * ==================== Método que executa o menu de funções ===================
 */
        
    private void menu() throws Exception{
        
        int escolha = 0;
        
        try{
        while (true) {
        System.out.println("+==================================================================+");
        System.out.println("+            Livraria Java - seu pesadelo começa aqui...           +");
        System.out.println("+------------------------------------------------------------------+");
        System.out.println("+ 1. Cadastrar novo livro                                          +");
        System.out.println("+ 2. Remover livro do acervo                                       +");
        System.out.println("+ 3. Listar acervo                                                 +");
        System.out.println("+ 4. Resetar livraria                                              +");
        System.out.println("+ 5. Modificar Livro do acervo                                     +");
        System.out.println("+ 6. Listar capítulos de livro                                     +");
        System.out.println("+ 9. Sair                                                          +");
        System.out.println("+==================================================================+");
        escolha = Util.leInt("Escolha uma opção: ");
        
        MENU:
            switch (escolha) {
                case 1:
                    cadastrarLivro();
                    break;
                case 2:
                    removerLivro();
                    break;
                case 3:
                    listarAcervo();
                    break;
                case 4:
                    resetarLivraria();
                    break;
                case 5:
                    modificarLivro();
                    break;
                case 6:
                    listarCapitulos();
                    break;
                case 9:
                    sair();
                    break MENU;
                default:
                    break;
            }
        }
        } catch (Exception ex) {
                System.err.println(ex.getMessage());
                Thread.sleep(1000);
            }
    }
/**
 * ======================== Método que cadastra o livro ========================
 * @param livro
 * @param numAutores
 * @return
 * @throws Exception 
 */    
    private int cadastrarLivro() throws Exception {

    while(true){   
        try{       
         String titulo = Util.leString("Digite o Título do livro: ");
         int isbn = Util.leInt("Digite o ISBN: ");                
         
         Livro livro = new Livro(titulo, isbn);
        
         System.out.println("+-------------------------------------------------------------------+");

         int numAutores = Util.leInt("Digite o número de autores a cadastrar: ");
            adicionarAutor(livro);
         
         int numeroDeCapitulos = Util.leInt("Digite o número de capítulos a cadastrar: ");
         adicionarCapitulo(livro, numeroDeCapitulos);
         
         livroList.add(livro);    
            System.out.println();
            System.out.println(livro.getTitulo() + " foi cadastrado com sucesso!");
            System.out.println();
         return livroList.indexOf(livro);
         
            }catch(Exception e){
                System.err.println("Erro.../nTente novamente.");
                return -1;
            }
        }
    }

/**
 * ======================== Adiciona o autor do livro ==========================
 * @param livro
 * @throws Exception 
 */    
    private void adicionarAutor(Livro livro) throws Exception {
        Autor autor = new Autor(Util.leString("Digite o nome do autor: "));
        autor.setDataNascimento(Util.leLocalDate("Digite a data de nascimento (dd/mm/aaaa): "));
        livro.adicionarAutor(autor);
    }


/**
 * ============================ Adiciona capitulo ao livro =====================
 * @param livro
 * @param numCapitulo 
 */    
    private void adicionarCapitulo(Livro livro, int numCapitulo) {
        System.out.println("+------------------------------------------------------------------+");
        
        for (int i = 0; i < numCapitulo; i++) {
            System.out.printf("Cadastro de capitulo(%d/%d )\n", (i+1), numCapitulo);
        }
        
        String titulo = Util.leString("Digite o titulo capítulo do Livro: ");
        String texto = Util.leString("Digite a frase do capítulo: ");
        
        livro.adicionarCapitulo(titulo, texto);
    }

   /**
    * ======================= Remove um livro do acervo ========================
    * @throws Exception 
    */ 
    private void removerLivro() throws Exception {
        listarAcervo();
        
        int num = Util.leInt("Digite o nº do livro que deseja remover: ");
                try {
            livroList.remove(num);
        } catch (Exception ex) {
            throw new Exception("Não foi possível remover este livro");
        }
    }

/**
 * ========================== Lista os livros do acervo ========================
 */    
        private void listarAcervo(){
            for (int i = 0; i < livroList.size(); i++) {
                if (!livroList.isEmpty()) {
                    System.out.printf("%d - %s \n", i, livroList.get(i));
                }
            }
            
        }
        
/**
 * ========================= Lista os capitulos do livro =======================
 */        
        
        private void listarCapitulos(Livro livro){
            
            for(Capitulo capitulo : livro.getCapitulosList()){
              
                System.out.println(livro.getCapitulosList().indexOf(capitulo) + "." + capitulo.toString());
            }
            System.out.println("+------------------------------------------------------------------+");
        }
        
        private void listarCapitulos() throws Exception {
        listarAcervo();
        int id = Util.leInt("Digite id do livro que deseja ver os capítulos: ");
        listarCapitulos(livroList.get(id));
    }
/**
 * ============================= Reseta a livraria =============================
 */        
        private void resetarLivraria(){
            for (int i = 0; i < livroList.size(); i++) {
                livroList.removeAll(livroList);
            }
        } 
    
/**
 * ====================== Método que permite modifiar o livro ==================
 */        
        private void modificarLivro() throws Exception{
            for (Livro livro : livroList){
                System.out.println(livroList.indexOf(livro) + 1 + "- " + livro.getTitulo());
            }
            System.out.println("+------------------------------------------------------------------+");
            
            int escolha = Util.leInt("Escolha o livro que deseja modificar: ");
            
            boolean validar = true;
            while(validar == true){
                
                String editarLivro = Util.leString("Digite o que você gostaria de modificar: ");
                
                if ("ISBN".equalsIgnoreCase(editarLivro)) {
                    int atualizarISBN = Util.leInt("Digite a nova ISBN: ");
                    livroList.get(escolha - 1).setISBN(atualizarISBN);
                }else if ("titulo".equalsIgnoreCase(editarLivro)) {
                    String atualizarTitulo = Util.leString("Digite o novo Titulo: ");
                    livroList.get(escolha - 1).setTitulo(atualizarTitulo);
                }else{
                    System.err.println("Opção invalida.");
                }
                String sair = Util.leString("Deseja modificar o livro novamente? (S/N)");
                if ("N".equalsIgnoreCase(sair)) {
                    validar = false;
                }
            }
        }
//==============================================================================    
    private void sair(){
        System.out.println();
        System.out.println("Patrick Porto");
        System.out.println("Análise e Desenvolvimento de Sistemas");
        System.out.println("2017-2");
        
    }
}
