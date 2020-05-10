package trazAqui;

import java.util.Scanner;
import trazAqui.Exceptions.*;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.Iterator;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.ArrayList;

public class Menu
{

    private BaseDados b_dados;

    public Menu(BaseDados base_dados){
        b_dados = base_dados;
        menuInicial();
    }


    /**
     * Registar um proprietario
     * Interage com o utilizador para recolha de dados para registo
     * Excepções ProprietarioExisteException e EmailJaEstaEmUsoException
     */
    private void registoUtilizador(){

        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a sua codigo");
        String cod = s.nextLine();
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza a sua gpsx");
        Double gpsx = s.nextDouble();
        System.out.println("Introduza a sua gpsy");
        Double gpsy = s.nextDouble();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu PassWord");
        String pass = s.nextLine();
        try{
            b_dados.novoUtilizador(cod,nome,gpsx,gpsy,username,pass);
        }

        catch(UtilizadorExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Registar um cliente
     * Interage com o utilizador para recolha de dados para registo
     * Excepções DateTimeParseException, ClienteExisteException e EmailJaEstaEmUsoException
     */
    private void registoLoja(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a sua codigo");
        String cod = s.nextLine();
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza a sua gpsx");
        Double gpsx = s.nextDouble();
        System.out.println("Introduza a sua gpsy");
        Double gpsy = s.nextDouble();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu PassWord");
        String pass = s.nextLine();
        try{
            b_dados.novaLoja(cod,nome,gpsx,gpsy,username,pass);
        }

        catch(LojaExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void registoTransportadora(){

        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a sua codigo");
        String cod = s.nextLine();
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza a sua gpsx");
        Double gpsx = s.nextDouble();
        System.out.println("Introduza a sua gpsy");
        Double gpsy = s.nextDouble();
        System.out.println("Introduza o seu NIF");
        String nif = s.nextLine();
        System.out.println("Introduza a sua Raio");
        Double raio= s.nextDouble();
        System.out.println("Introduza a sua Preco");
        Double preco= s.nextDouble();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu PassWord");
        String pass = s.nextLine();
        try{
            b_dados.novaTransportadora(String cod,String nome,double gpsx, double gpsy, String nif,double raio, double preco,String username, String pass);
        }

        catch(TransportadoraExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void registoVoluntario(){

        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a sua codigo");
        String cod = s.nextLine();
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza a sua gpsx");
        Double gpsx = s.nextDouble();
        System.out.println("Introduza a sua gpsy");
        Double gpsy = s.nextDouble();
        System.out.println("Introduza a sua Raio");
        Double raio= s.nextDouble();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu PassWord");
        String pass = s.nextLine();
        System.out.println("Introduza o seu PassWord");
        boolean d = s.nextBoolean();

        try{
            b_dados.novoVoluntario(String cod,String nome,double gpsx, double gpsy,double raio,String username, String pass, Boolean d);
        }

        catch(UtilizadorExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Registar um veiculo num proprietario
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados para registo
     * Excepções InputMismatchException e VeiculoExisteException
     */
    private void addProdutoLoja(String username){
        String codProd = ""; String desc = ""; double preco = 0; int qnt = 0;double x = 0; double y = 0;
        try{
            Scanner s = new Scanner(System.in);
            s.useLocale(Locale.US);
            System.out.println("Codigo Do Produto: ");
            codProd = s.nextLine();
            System.out.println("Nome do Produto: ");
            desc = s.nextLine();
            System.out.println("Preço por Unidade: ");
           preco = s.nextDouble();
            System.out.println("Quantidade no Stock: ");
            qnt = s.nextInt();

        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuLoja(username);

        }

        try{
            b_dados.novoProduto(String username,String codProd,String desc,double preco,int qnt);
        }
        catch(ProdutoExisteException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * Remover um veículo de um proprietário
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void remProdutoLoja(String username){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a quantidade a remover: ");
        String nome = s.nextLine(); int rem = -1;

        try{
            rem = b_dados.removeProduto(username,nome);

        }
        catch(ProdutoNaoExisteException e){
            System.out.println(e.getMessage()+"\n");
        }

        if(rem>0) System.out.println("Removido com sucesso\n");
    }

    /**
     * Consultar histórico de alugueres de veiculos de um proprietário
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void consultaHistoricoProp(String nif){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a data inicial (AAAA-MM-DD): ");
        String dataInicio = s.nextLine();
        System.out.println("Introduza a data de fim (AAAA-MM-DD): ");
        String dataFim = s.nextLine();

        try{
            List<HistoricoProprietario> hist = b_dados.consultaHistorico(nif,dataInicio,dataFim);
            //for(HistoricoProprietario hs : hist){
            System.out.println(hist);
            //}
        }
        catch(HistoricoNaoExisteException e){
            System.out.println("Não existem alugueres efectuados");
        }
    }

    /**
     * Alterar o preço por Km de um veículo
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void alteraPrecoKm(String nif){
        Scanner s = new Scanner(System.in);
        s.useLocale(Locale.US);
        System.out.println("Introduza a matrícula do veículo");
        String mat = s.nextLine();
        System.out.println("introduza o novo preço por Km");
        double price = s.nextDouble();

        try{
            b_dados.mudaPrecoKm(nif,mat,price);
        }
        catch(VeiculoNaoExisteException e){
            System.out.println("O veículo não existe");
        }
    }

    /**
     * Consultar histórico de alugueres um de veiculo
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void historicoVeiculo(String nif){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a matrícula do veículo");
        String mat = s.nextLine();

        try{
            List<HistoricoVeiculo> ret = b_dados.historicoUmVeiculo(nif,mat);
            //for(HistoricoVeiculo hv : ret){
            System.out.println(ret.toString());
            //}
        }
        catch(VeiculoNaoExisteException e){
            System.out.println(e.getMessage());
        }


    }

    /**
     * Consultar a classificação média de uma transportadora
     * @param nif O nif do proprietario
     */
    private void consultaClassTransp(String username){
        double k = b_dados.classProp(username);
        System.out.println("A sua classificação é " +k +"\n");
    }

    /**
     * Consultar total facturado por um veículo
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void consultarGanhosVeiculo(String nif){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a matricula do veículo a consultar: ");
        String mat = s.nextLine();

        try{
            double k = b_dados.ganhosVeiculo(nif,mat);
            System.out.println("O veículo "+mat+" facturou "+k+" € \n");
        }
        catch(VeiculoNaoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    private void abastecerVeiculos(String nif){
        b_dados.abastecerVeiculos(nif);
    }


    /**
     * Consultar classificação média de um veiculo
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     * Excepções VeiculoNaoExisteException
     */
    private void consultaClassVeiculo(String nif){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a matricula do veículo a consultar: ");
        String mat = s.nextLine();

        try{
            double k = b_dados.ClassifVeiculo(nif,mat);
            System.out.println("A classificação do veículo "+mat+" é "+k+" .\n");
        }
        catch(VeiculoNaoExisteException e){
            System.out.println(e.getMessage()+"\n");
        }
    }

    /**
     * Consultar lista de veículos
     * @param nif O nif do proprietário
     */
    private void verMeusProdutos(String username){
        try{
            List<trazAqui.Produto> veic = b_dados.getProdutos(username);
            for(trazAqui.Produto v : veic){
                System.out.println(v.toString());
            }
        }
        catch(ProdutoNaoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Menu de proprietário
     * @param nif O nif do proprietário
     * Interage com o utilizador para recolha de dados
     */

    private void menuProprietario(String nif){
        int opcao = 0;
        Scanner s = new Scanner(System.in);
        do{
            System.out.println("Escolha o que pretende fazer");
            System.out.println("1 - Adicionar Veículo");
            System.out.println("2 - Remover Veículo");
            System.out.println("3 - Consultar histórico");
            System.out.println("4 - Alterar preço por km de um veículo");
            System.out.println("5 - Consultar o histórico de um veículo");
            System.out.println("6 - Consultar  a minha classificação");
            System.out.println("7 - Consultar facturação de um veículo");
            System.out.println("8 - Consultar Top10 de clientes");
            System.out.println("9 - Ver todos os meus veiculos");
            System.out.println("10 - Consultar classificação de um veículo");
            System.out.println("11 - Abastecer os meus veiculos");
            System.out.println("0 - Retroceder");

            opcao = s.nextInt();
            System.out.print("\n");

            switch(opcao){
                case 1:
                    addVeiculoProprietario(nif);
                    break;
                case 2:
                    remVeiculoProprietario(nif);
                    break;
                case 3:
                    consultaHistoricoProp(nif);
                    break;
                case 4:
                    alteraPrecoKm(nif);
                    break;
                case 5:
                    historicoVeiculo(nif);
                    break;
                case 6:
                    consultaClassProp(nif);
                    break;
                case 7:
                    consultarGanhosVeiculo(nif);
                    break;
                case 8:
                    top10clientes();
                    break;
                case 9:
                    verMeusVeiculos(nif);
                    break;
                case 10:
                    consultaClassVeiculo(nif);
                case 11:
                    abastecerVeiculos(nif);
                    break;

                case 0:
                    break;
                default:
                    System.out.println("Opção inválida\n");
                    break;

            }
        }while(opcao != 0);
    }

    /**
     * Efectuar login de proprietario
     * Interage com o utilizador para recolha de dados
     * Recolhe email e password, verifica se fazem match
     */

    private void loginProprietario(){
        Scanner s = new Scanner(System.in); int contador = 0; String k;
        String email,pass;

        do{
            System.out.println("Introduza o seu e-mail");
            email = s.nextLine();
            System.out.println("Introduza a sua password");
            pass = s.nextLine();
            contador++;
            k = b_dados.checkMailPassProp(email,pass);
            if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
        }while((k.equals("NOK")) && contador < 3);


        if(k.equals("NOK")) return; //menuInicial();

        else menuProprietario(k);
    }

    /**
     * Consultar historico de alugueres de um cliente
     * @param nif O nif do cliente
     * Excepções HistoricoNaoExisteException
     */
    private void consultaHistoricoCl(String nif){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza a data inicial (AAAA-MM-DD): ");
        String dataInicio = s.nextLine();
        System.out.println("Introduza a data de fim (AAAA-MM-DD): ");
        String dataFim = s.nextLine();

        try{
            List<HistoricoCliente> ret = b_dados.histCliente(nif,dataInicio,dataFim);
            //for(HistoricoCliente h : ret){
            System.out.println(ret);
            //}
        }
        catch(HistoricoNaoExisteException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Consultar a classificação média de um cliente
     * @param nif O nif do cliente
     */
    private void consultaClassCl(String nif){
        double k = b_dados.classfCliente(nif);
        System.out.println("A sua classificação é "+k + "\n");
    }

    /**
     * Alugar um veículo
     * @param nif O nif do cliente
     * Interage com o utilizador para recolha de dados
     * Excepções InputMismatchException
     */
    private void alugaVeiculo(String nif){
        Scanner s = new Scanner(System.in);double escolha = 0,x = 0,y=0;int combustivel =0;
        s.useLocale(Locale.US);String ret = "";String mat = "";
        try{
            do{
                System.out.println("Qual o tipo de veículo que pretende alugar? \n1- Electrico \n2- Hibrido \n3 -Combustão\n4- Alugar veículo específico ");
                combustivel = s.nextInt();
                if(combustivel != 1 && combustivel != 2 && combustivel != 3 && combustivel !=4) System.out.println("Entrada inválida");
            } while(combustivel!=1 && combustivel!=2 && combustivel!=3  && combustivel!=4);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            // menuInicial();
            return;

        }

        if(combustivel == 4){
            List<Veiculo> temp =b_dados.top10Veiculos();
            System.out.println("\n-----Top10 Veiculos mais utilizados: \n");
            for(Veiculo v : temp){
                System.out.println(v.toString());
            }
            Scanner p = new Scanner(System.in);
            System.out.println("Introduza a matricula: ");
            mat = p.nextLine();
            try{
                System.out.println("Coordenada x do seu destino: ");
                x = s.nextDouble();
                System.out.println("Coordenada y do seu destino: ");
                y = s.nextDouble();
                ret = b_dados.alugaCar(nif,combustivel,escolha,x,y,mat);

            }
            catch(VeiculoSemAutonomiaException e){
                System.out.println(e.getMessage());
            }

            catch(InputMismatchException e){
                System.out.println("Entrada inválida");
                //menuInicial();
                return;
            }

            catch(VeiculoNaoExisteException e){
                System.out.println(e.getMessage());
            }
            System.out.println(ret);
            System.out.print("\n");
            return;
        }

        do{
            System.out.println("Forma de alugar: \n1 - Mais Perto\n2 - Mais Barato");
            escolha = s.nextDouble();
            if(escolha != 1 && escolha != 2) System.out.println("Entrada inválida");
        }while (escolha != 1 && escolha != 2);



        try{
            System.out.println("Coordenada x do seu destino: ");
            x = s.nextDouble();
            System.out.println("Coordenada y do seu destino: ");
            y = s.nextDouble();
            ret = b_dados.alugaCar(nif,combustivel,escolha,x,y,mat);

        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            //menuInicial();
            return;
        }
        catch(VeiculoSemAutonomiaException e){
            System.out.println(e.getMessage());
        }

        catch(VeiculoNaoExisteException e){
            System.out.println(e.getMessage());
        }
        System.out.println(ret);
        System.out.print("\n");
    }

    /**
     * Consultar o top10 de clientes que mais Km fizeram
     *
     */
    private void top10clientes(){
        Scanner s = new Scanner(System.in); int escolha = 0;
        List<Cliente> res = new ArrayList();
        do{
            System.out.println("1- Por número de Km efectuados\n2- Por número de alugueres");
            escolha = s.nextInt();
            if(escolha!=1 && escolha !=2) System.out.println("Entrada inválida\n");
        }while(escolha!=1 && escolha !=2);

        switch(escolha){
            case 1:
                res = b_dados.top10clientes(escolha);
                System.out.println("ID cliente \tTotal de Km\n");
                for(Cliente x : res){
                    System.out.println(x.getNif() + "\t" + x.getTotaldeKm());
                }
                System.out.print("\n");
                break;
            case 2:
                res = b_dados.top10clientes(escolha);
                System.out.println("ID cliente \tNumero de alugueres\n");
                for(Cliente x : res){
                    System.out.println(x.getNif() + "\t" + x.getHistorico().size());
                }
                System.out.print("\n");
                break;
        }
    }

    /**
     * Consultar o top10 de veículos com mais Km
     *
     */
    private void consultaTop10V(){
        List<Veiculo> res = b_dados.top10Veiculos();
        System.out.println("Matricula \tTotal de Km\n");
        for(Veiculo x : res){
            System.out.println(x.getMatricula() + "\t" + x.getTotaldeKmV());

        }
        System.out.print("\n");
    }

    /**
     * Consultar a localização de um cliente
     * @param nif O nif do cliente
     * Excepções ClienteNaoExisteException
     */
    private void localizacaoCliente(String nif){
        Localizacao loc = b_dados.getLocalizacaoCliente(nif);
        System.out.println(loc.toString());
    }

    /**
     * Alterar a localização de um cliente
     * @param nif O nif do cliente
     * Excepções InputMismatchException
     */
    private void mudarLocalizacaoCliente(String nif){
        Scanner s = new Scanner(System.in);
        double cordx, cordy;
        System.out.println("Posicao X:");
        try{
            cordx = s.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Opcao invalida");
            return;
        }
        System.out.println("Posicao Y:");
        try{
            cordy = s.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Opcao invalida");
            return;
        }
        b_dados.setLocalizacaoCliente(nif, cordx, cordy);


    }

    /**
     * Menu cliente
     * Interage com o utilizador para recolha de dados
     * @param nif Nif do cliente
     * Excepções InputMismatchException
     */
    private void menuCliente(String nif){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Alugar Veículo");
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
                        alugaVeiculo(nif);
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
        String email,pass,k;
        try{
            do{
                System.out.println("Introduza o seu e-mail");
                email = s.nextLine();
                System.out.println("Introduza a sua password");
                pass = s.nextLine();
                contador++;
                k = b_dados.checkMailPassCl(email,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuCliente(k);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            //menuInicial();
            return;

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

                System.out.println("Bem-vindo ao Um Carro Já! Escolha uma funcionalidade.");
                System.out.println("1 - Registar Proprietário");
                System.out.println("2 - Registar Cliente");
                System.out.println("3 - Login de Proprietário");
                System.out.println("4 - Login de Cliente");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        registoProprietario();
                        break;
                    case 2:
                        registoCliente();
                        break;
                    case 3:
                        loginProprietario();
                        break;
                    case 4:
                        loginCliente();
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