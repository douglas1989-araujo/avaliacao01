package aplicativos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;


import classes.Piloto;

public class AppPilotos {
    public static void main(String[] args) throws InterruptedException, IOException {
        final int MAX_ELEMENTOS = 2;
        final int MAX_ERROS = 3;
        int opcao, qtdCadastrados = 0;
        int qtd=0;
      //  boolean continuar;
        int tamanho;
        Piloto[] pilotos = new Piloto[MAX_ELEMENTOS];
        Scanner in = new Scanner(System.in);

        do {
            System.out.println("\n****\nMENU\n****\n");
            System.out.println("1 - Cadastrar piloto");
            System.out.println("2 - Listar pilotos cadastrados");
            System.out.println("3 - Localizar piloto pelo CPF");
            System.out.println("4 - Aumentar espaço de armazenamento");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");

            opcao = in.nextInt();
            in.nextLine(); // Tira o ENTER que ficou na entrada na instrução anterior

            if (opcao == 1) {
                // Se não tem mais espaço no vetor, caio fora
                tamanho = pilotos.length;
                System.out.println("espaço vetor" + tamanho);
               if (qtdCadastrados == tamanho ) {
                   System.out.println("\nNão há espaço para cadastrar novos pilotos.");
                   voltarMenu(in);
                  continue; 
                
                }
            
                  //Cadastre seu piloto aqui
                  Piloto pil = new Piloto();
                  System.out.println("Nome:....");
                  pil.setNome(in.nextLine());
                  System.out.println("Habilitação:...");
                  pil.setHabilitacao(in.nextLine());
                
                  int numErros = 0;
                do{
                    try {
                    System.out.println("CPF:...");
                    pil.setCpf(in.nextLine());
                   }catch(InputMismatchException ex){
                     System.out.println(ex.getMessage() + "Tente novamente.");
                     numErros +=1;
                   } 
                  }while (pil.getCpf()== null &&  numErros< MAX_ERROS ) ;
                      
                  if (pil.getCpf() == null) {
                    System.out.printf("Voce errou o cpf %d vezes. O programa sera encerrado. ", numErros);  
                    return;
                  }
                    pilotos[qtdCadastrados]= pil;
                    qtdCadastrados = qtdCadastrados + 1;
                    System.out.println("\nPiloto cadastrado com sucesso." + qtdCadastrados);
                    if(pilotos.length == qtdCadastrados){
                    System.out.println("aumente o espaço de armazenamento para continuar cadastrando");
                    voltarMenu(in);
                    
                }else
                   voltarMenu(in);
            } else if (opcao == 2) {
                // Se não tem ninguém cadastrado no vetor, caio fora
                if (qtdCadastrados == 0) {
                    System.out.println("\nNão há motoristas cadastrados para exibir.");
                    voltarMenu(in);
                    continue;
                }

                // Exiba os pilotos aqui
                  System.out.println("Pilotos cadastrados");
                  System.out.println("===================");
                for (int i = 0; i < qtdCadastrados; i++) {
                  System.out.printf("\nPiloto: %d: %s\n", (i + 1), pilotos[i].getNome());
                  System.out.printf("CPF: %s\n", pilotos[i].getCpf());
                  System.out.printf("Habilitação: %s\n", pilotos[i].getHabilitacao());                    
                }
                 voltarMenu(in);
            } else if (opcao == 3) {
                System.out.println("Digite o cpf do piloto ");
                String buscaCpf = in.nextLine();
                boolean achou = false;
                Piloto cpfEncontrado = null;
              for(int i =0; !achou && i<qtdCadastrados; i++){
                 achou = buscaCpf.equals(pilotos[i].getCpf());
                 cpfEncontrado = pilotos[i];
               }
                if(achou){
                  System.out.printf("Piloto %s , %s , %s\n", cpfEncontrado.getNome()  ,"CPF:  " +  buscaCpf  ,  "Habilitação:  " +  cpfEncontrado.getHabilitacao());
                }else{
                  System.out.println("Piloto não encontrado");
                }
                
                 voltarMenu(in);
                 continue;
            } else if (opcao == 4) {
            
                System.out.println("Digite a quantidade de pilotos a serem cadastrados");
                qtd = in.nextInt();
                System.out.println(qtd);
                Piloto[] pilotos2= new Piloto[pilotos.length + qtd];
                for (int i =0; i < pilotos.length; i++) {
                    pilotos2[i]= pilotos[i];
                }
                    pilotos = pilotos2;
                }
             
                
                
                
            
            else if (opcao != 0) {
                System.out.println("\nOpção inválida!");
            }
        } while (opcao != 0);

        System.out.println("Fim do programa!");

        in.close();
    }

    private static void voltarMenu(Scanner in) throws InterruptedException, IOException {
        System.out.println("\nPressione ENTER para voltar ao menu.");
        in.nextLine();

        // Limpa toda a tela, deixando novamente apenas o menu
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            System.out.print("\033[H\033[2J");
        
        System.out.flush();
    }
}