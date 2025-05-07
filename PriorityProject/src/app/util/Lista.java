package app.util;

import java.util.ArrayList;
import java.util.Scanner;

public class Lista {
    private final Scanner scn = new Scanner(System.in);
    private final ArrayList<String> lowPriority = new ArrayList<>();
    private final ArrayList<String> mediumPriority = new ArrayList<>();
    private final ArrayList<String> highPriority = new ArrayList<>();

    boolean running = true;

    public void priorityList(){

         System.out.println("\n---- LISTA DE PRIORIDADES ----");

         while (running){
            showMenu();

            if (!lowPriority.isEmpty() && !mediumPriority.isEmpty() && !highPriority.isEmpty()){
                System.out.println("\nVocê cadastrou pelo menos uma tarefa em cada prioridade!");
                System.out.printf("\n%-17s | %s\n", "PRIORIDADE", "TAREFA");
                showTasks();
                running = false;
            }
         }

    }

    private int getOption(){
        while (!scn.hasNextInt()){
            System.out.println("Digite um número válido!");
            scn.nextLine();
        }
        int opcao = scn.nextInt();
        scn.nextLine();

        return opcao;
    }

    public void showMenu(){
        System.out.println("Digite uma tarefa: ");
        String newTask = scn.nextLine();
        System.out.println("Digite o valor correspondente à qual prioridade essa tarefa tem:");
        System.out.println("1 - Alta");
        System.out.println("2 - Média");
        System.out.println("3 - Baixa");
        System.out.println("4 - Fechar programa");

        switch (getOption()){
            case 1:
                highPriority.add(newTask);
                break;
            case 2:
                mediumPriority.add(newTask);
                break;
            case 3:
                lowPriority.add(newTask);
                break;
            case 4:
                running = false;
                System.out.println("Encerrando programa...");
                scn.close();
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }

    }

    public void showTasks(){
        for (String showTask : highPriority){
            System.out.printf("\n%-17s | %s\n", "Alta Prioridade" ,showTask.trim());
        }

        for (String showTask : mediumPriority){
            System.out.printf("%-17s | %s\n", "Média Prioridade" ,showTask.trim());
        }

        for (String showTask : lowPriority){
            System.out.printf("%-17s | %s\n", "Baixa Prioridade" ,showTask.trim());
        }
    }
}
