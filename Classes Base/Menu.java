package trazAqui;

import java.util.*;
import java.util.stream.Collectors;

import trazAqui.Exceptions.*;

import java.time.format.DateTimeParseException;

public class Menu
{

    private BaseDados b_dados;

    public Menu(BaseDados base_dados){
        b_dados = base_dados;
        menuInicial();
    }

    public void verLojas() {
        Scanner s = new Scanner(System.in); String opcao = "";
        try{
            do{
                System.out.println(displayLojas(lojasOrdemAlfabetica()));

                System.out.println("0 - Retroceder");

                opcao = s.nextLine();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        verLojas();
                        break;
                    case 2:
                        consultaHistoricoCl(nif);
                        break;
                    case 3:
                        consultaClassCl(nif);
                        break;
                    case 4:

                        consultaTop10V();
                        break;
                    case 5:
                        localizacaoCliente(nif);
                        break;
                    case 6:
                        mudarLocalizacaoCliente(nif);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuCliente(nif);

        }

    }

    /**
     *Lojas por ordem alfabetica
     */
    public void displayLojas(Set<String>){
        Set<String> set = new HashSet<String>();
        for(int i=1;i<set.size();i++)
        for(String s : set){
            System.out.println(i + "-" + s);
        }
    }

    /**
     *Lojas por ordem alfabetica
     */
    public Set<String> lojasOrdemAlfabetica(){
        return b_dados.getLojas().values().stream()
                .map(a -> a.getNome())
                .collect(Collectors.toCollection(TreeSet :: new));
    }
    /**
     * Menu cliente
     * Interage com o utilizador para recolha de dados
     * @param nif Nif do cliente
     * Excepções InputMismatchException
     */
    private void menuCliente(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Ver Lojas");
                System.out.println("2 - Consultar histórico");
                System.out.println("3 - Consultar classificação");
                System.out.println("4 - Consultar Top10 de veículos");
                System.out.println("5 - Ver a minha localizacao");
                System.out.println("6 - Mudar a minha localizacao");

                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        verLojas();
                        break;
                    case 2:
                        consultaHistoricoCl(nif);
                        break;
                    case 3:
                        consultaClassCl(nif);
                        break;
                    case 4:

                        consultaTop10V();
                        break;
                    case 5:
                        localizacaoCliente(nif);
                        break;
                    case 6:
                        mudarLocalizacaoCliente(nif);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuCliente(nif);

        }
    }

    /**
     * Login de cliente
     * Interage com o utilizador para recolha de dados
     * Excepções InputMismatchException
     * Compara mail e pass para verificar se fazem match
     */
    private void loginCliente(){
        Scanner s = new Scanner(System.in); int contador = 0;
        String username,pass,k;
        try{
            do{
                System.out.println("Introduza o seu username");
                username= s.nextLine();
                System.out.println("Introduza a sua password");
                pass = s.nextLine();
                contador++;
                k = b_dados.checkUserPassUtilizador(username,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuCliente();
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            //menuInicial();
            return;

        }
    }

    /**
     * Menu Cliente
     * São apresentadas as primeiras opções ao cliente
     */
    private void submenuCliente(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        loginCliente();
                        break;
                    case 2:
                        registarCliente();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();

        }
    }

    /**
     * Menu Loja
     * São apresentadas as opções de login à loja
     */
    private void submenuLoja(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        submenu();
                        break;
                    case 2:
                        submenu();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();

        }
    }

    /**
     * Menu Transportadora
     * São apresentadas as opções de login ao transportadora
     */
    private void submenuTransportadora(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        submenu();
                        break;
                    case 2:
                        submenu();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();

        }
    }

    /**
     * Menu Voluntario
     * São apresentadas as opções de login ao voluntario
     */
    private void submenuVoluntario(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        submenu();
                        break;
                    case 2:
                        submenu();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();

        }
    }


    /**
     * Menu inicial
     * São apresentadas as primeiras opções ao utilizador
     */
    private void menuInicial(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{

                System.out.println("Bem-vindo ao Traz Aqui! Escolha uma funcionalidade.");
                System.out.println("1 - Cliente");
                System.out.println("2 - Loja");
                System.out.println("3 - Transportadora");
                System.out.println("4 - Voluntario");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        submenuCliente();
                        break;
                    case 2:
                        submenuLoja();
                        break;
                    case 3:
                        submenuTransportadora();
                        break;
                    case 4:
                        submenuVoluntario();
                        break;
                    case 0:
                        break;

                    default:
                        System.out.println("Opção inválida");
                        break;
                }
            } while (opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();

        }
    }
}