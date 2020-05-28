package trazaqui;

import java.util.*;
import java.util.stream.Collectors;
import trazaqui.Exceptions.*;
import java.time.format.DateTimeParseException;

public class Menu
{

    private BaseDados b_dados;
    private Armazena a_armazena;

    public Menu(BaseDados base_dados, Armazena armazena){
        b_dados = base_dados;
        a_armazena=armazena;
        menuInicial();
    }

    /**
     * CONSULTAR LOCALIZAÇAO
     */
    private void verLocalizacaoUtilizador(String username){
        Localizacao loc = b_dados.getLocalizacaoUtilizador(username);
        System.out.println(loc.toString());
    }

    private void verLocalizacaoLoja(String username){
        Localizacao loc = b_dados.getLocalizacaoLoja(username);
        System.out.println(loc.toString());
    }

    private void verLocalizacaoTransportadora(String username){
        Localizacao loc = b_dados.getLocalizacaoTransportadora(username);
        System.out.println(loc.toString());
    }

    private void verLocalizacaoVoluntario(String username){
        Localizacao loc = b_dados.getLocalizacaoVoluntario(username);
        System.out.println(loc.toString());
    }

    /**
     * ALTERAR LOCALIZAÇAO
     */
    private void mudarLocalizacaoUtilizador(String username){
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
        b_dados.setLocalizacaoUtilizador(username, cordx, cordy);
    }

    private void mudarLocalizacaoLoja(String username){
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
        b_dados.setLocalizacaoloja(username, cordx, cordy);
    }

    private void mudarLocalizacaoTransportadora(String username){
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
        b_dados.setLocalizacaotransportadora(username, cordx, cordy);
    }

    private void mudarLocalizacaoVoluntario(String username){
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
        b_dados.setLocalizacaovoluntario(username, cordx, cordy);
    }

    public double calculaPreco(double preco,double stock,double quant){
        return ((preco*quant)/stock);
    }

    public double calculaPeso(List<LinhaEncomenda> l){
        double res=0;
        for(LinhaEncomenda e : l){
            res+=e.getQuantidade();
        }
        return res;
    }

    public void metodoEntrega(){
        try {
            String opcao;
            do {
                System.out.println("Escolha o metodo de entrega");
                System.out.println("1 - Empresa Transportadora");
                System.out.println("2 - Voluntario");
                System.out.println("0 - Retroceder");

                Scanner s = new Scanner(System.in);
                opcao = s.nextLine();
                if(opcao.equals("0")){
                    break;
                }

                switch (opcao) {
                    case "1":

                    case "2":

                    default:
                        System.out.print("Opção inválida\n\n");
                        break;
                }
            }
            while (true);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
        }

    }

    public void fazerEncomenda(String codLoja,String codUtilizador){
        ArrayList<LinhaEncomenda> encs = new ArrayList<>();
        try {
            String opcao;
            do {
                System.out.println("1 - Adicionar um produto ao carrinho");
                System.out.println("2 - Remover um produto do carrinho");
                System.out.println("3 - Efetuar encomenda");
                System.out.println("0 - Retroceder");

                Scanner s = new Scanner(System.in);
                opcao = s.nextLine() ;

                if (opcao.equals("0")){
                    break;
                }

                switch (opcao) {
                    case "1":
                        System.out.println("Introduza o código do produto!");
                        opcao = s.nextLine();
                        System.out.print(opcao);
                        System.out.print("\n");
                        Produto p = buscaCatalogo(codLoja).getProduto(opcao);
                        System.out.println("Indique a quantidade");
                        double q = Double.parseDouble(s.nextLine());
                        System.out.print(q);
                        System.out.print("\n");
                        double preco = calculaPreco(p.getPreco(), p.getStock(), q);
                        System.out.print(preco);
                        System.out.print("\n");
                        LinhaEncomenda l = new LinhaEncomenda(opcao, p.getDescricao(), preco, q);
                        encs.add(l);
                        System.out.print("Carrinho:");
                        System.out.print(encs);
                        System.out.print("\n");
                        break;
                    case "2":
                        System.out.println("Introduza o código do produto!");
                        opcao = s.nextLine();
                        System.out.print(opcao);
                        System.out.print("\n");
                        System.out.println("Indique a quantidade");
                        double qu = Double.parseDouble(s.nextLine());
                        int index =0;
                        for(LinhaEncomenda le : encs) {
                            if (le.getCodProd().equals(opcao)) {
                                if(le.getQuantidade()==qu){
                                    break;
                                }else{
                                    le.setQuantidade(le.getQuantidade()-qu);
                                    le.setPreco(calculaPreco(le.getPreco(),le.getQuantidade(),qu));
                                    index=-1;
                                    break;
                                }
                            }
                            else{
                                System.out.print("O produto não se encontra no seu carrinho!\n");
                            }
                            index+=1;
                        }

                        if(index!=-1){
                            encs.remove(index);
                        }
                        System.out.println(encs);
                        break;

                    case "3":
                        double peso = calculaPeso(encs);
                        Encomenda e = b_dados.novaEncomenda(codUtilizador, codLoja, peso, encs);
                        System.out.print("Encomenda efetuada com sucesso!\n");
                        System.out.print("Codigo da sua Encomenda:" + e.getcodEncomenda());
                        System.out.print("\n");
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }
            while (true);
        }
        catch(CatalogoNaoExisteException e) {
            System.out.println("Nao existe catalogo");
        }
        catch(ProdutoNaoExisteException e) {
            System.out.println("Nao existe produto");
        }
        catch(InputMismatchException e) {
            System.out.println("Entrada inválida");
        }
    }

    private void verLojas(String username) {
        Scanner s = new Scanner(System.in);
        String opcao = "";
        try {
            do {
                Set<String> alfa = b_dados.lojasOrdemAlfabetica();
                System.out.println("Escreva o nome da loja que deseja visitar!");
                lojasOrdemAlfabeticaDisplay(alfa);

                System.out.println("0 - Retroceder");

                opcao = s.nextLine();
                if(opcao.equals("0")){
                    break;
                }
                System.out.print("\n");
                for (LogLoja l : b_dados.getLojas().values()) {
                    if (l.getNome().equals(opcao)) {
                        System.out.println(l.getCatalogoProdutos().toString());
                        fazerEncomenda(l.getCodLoja(), username);
                    }
                }
            }
            while (opcao.equals(""));
        } catch (NaoExisteLojasRegistadasException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida");
        }
    }


    /**
     *Lojas por ordem alfabetica
     */
    public void lojasOrdemAlfabeticaDisplay(Set<String> s) {
        Iterator<String> it = s.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public CatalogoProdutos buscaCatalogo(String cod) throws CatalogoNaoExisteException{
        for(CatalogoProdutos c : a_armazena.getCatalogos()){
            if(cod.equals(c.getCodLoja())){
                return c;
            }
        }
        throw new CatalogoNaoExisteException();
    }
    /**
     * ASSOCIAR CONTA CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */
    private void associarContaCliente(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Codigo de Utilizador");
        String cod = s.nextLine();
        Utilizador u = a_armazena.getUtilizador(cod);
        System.out.println(u.toString());
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();

        try{
            b_dados.associaUtilizador(u.getCodUtilizador(),u.getNome(),u.getGps(),username,pass);
        }

        catch(UtilizadorExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void associarContaLoja(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Codigo de Loja");
        String cod = s.nextLine();
        Loja l = a_armazena.getLoja(cod);
        System.out.println(l.toString());
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        CatalogoProdutos cp = new CatalogoProdutos();
        HashMap<String,Encomenda> encs=new HashMap<>();
        for (Encomenda e: a_armazena.getEncomendas().values()){
            if(e.getcodLoja().equals(cod)){
                encs.put(e.getcodEncomenda(),e.clone());
            }
        }
        try{
            cp=buscaCatalogo(cod);
        }
        catch (CatalogoNaoExisteException e){
            System.out.println(e.getMessage());
        }

        try{
            b_dados.associaLoja(l.getCodLoja(),l.getNome(),l.getGps(),username,pass,cp);
            for(Encomenda e: encs.values()){
                if (a_armazena.checkAceite(e)){
                    b_dados.associaAceite(e.getcodEncomenda(),e.getcodUtilizador(),e.getcodLoja(),e.getPeso(),e.getLinhas());
                }
                else{
                    b_dados.associaEncomenda(e.getcodEncomenda(),e.getcodUtilizador(),e.getcodLoja(),e.getPeso(),e.getLinhas());
                }
            }
        }

        catch(LojaExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }
        catch (EncomendaExisteException e){
            System.out.println(e.getMessage());
        }
    }

    private void associarContaTransportadora(){
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Codigo de Transportadora");
        String cod = s.nextLine();
        Transportadora t = a_armazena.getTransportadora(cod);
        System.out.println(t.toString());
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();


        try{
            b_dados.associaTransportadora(t.getCodEmpresa(),t.getNome(),t.getGps(),t.getNif(),t.getRaio(),t.getPrecokm(),username,pass);
        }

        catch(TransportadoraExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void associarContaVoluntario(){
        boolean disponibilidade = true;
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Codigo de Voluntário");
        String cod = s.nextLine();
        Voluntario v = a_armazena.getVoluntario(cod);
        System.out.println(v.toString());
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        System.out.println("Encontra-se disponivel para realizar entregas?");
        System.out.println("1-Sim");
        System.out.println("2-Nao");
        int d = Integer.parseInt(s.nextLine());
        if(d == 1){
            disponibilidade = true;
        } if(d==2){
            disponibilidade =false;
        }


        try{
            b_dados.associaVoluntario(v.getCodVoluntario(),v.getNome(),v.getGps(),v.getRaio(),username,pass,disponibilidade);
        }

        catch(VoluntarioExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    /**
     * REGISTO CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */
    private void registoCliente(){

        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        System.out.println("Introduza a sua Coordenada X");
        double gpsx= Double.parseDouble(s.nextLine());
        System.out.println("Introduza a sua Coordenada Y");
        double gpsy = Double.parseDouble(s.nextLine());
        Localizacao pos = new Localizacao(gpsx,gpsy);

        try{
            b_dados.novoUtilizador(nome, pos,username,pass);
        }

        catch(UtilizadorExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void registoLoja(){

        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        System.out.println("Introduza a sua Coordenada X");
        double gpsx= Double.parseDouble(s.nextLine());
        System.out.println("Introduza a sua Coordenada Y");
        double gpsy = Double.parseDouble(s.nextLine());
        Localizacao pos = new Localizacao(gpsx,gpsy);

        try{
            b_dados.novaLoja(nome,pos,username,pass);
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
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        System.out.println("Introduza o seu NIF");
        String nif = s.nextLine();
        System.out.println("Introduza a sua Coordenada X");
        double gpsx= Double.parseDouble(s.nextLine());
        System.out.println("Introduza a sua Coordenada Y");
        double gpsy = Double.parseDouble(s.nextLine());
        Localizacao pos = new Localizacao(gpsx,gpsy);
        System.out.println("Introduza o seu raio de atuação");
        double raio= Double.parseDouble(s.nextLine());
        System.out.println("Introduza o preço cobrado por kilometro");
        double preco= Double.parseDouble(s.nextLine());

        try{
            b_dados.novaTransportadora(nome,pos,nif,raio,preco,username,pass);
        }

        catch(TransportadoraExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }

    }

    private void registoVoluntario(){
        boolean disponibilidade = true;
        Scanner s = new Scanner(System.in);
        System.out.println("Introduza o seu Nome");
        String nome = s.nextLine();
        System.out.println("Introduza o seu Username");
        String username = s.nextLine();
        System.out.println("Introduza o seu Password");
        String pass = s.nextLine();
        System.out.println("Introduza a sua Coordenada X");
        double gpsx= Double.parseDouble(s.nextLine());
        System.out.println("Introduza a sua Coordenada Y");
        double gpsy = Double.parseDouble(s.nextLine());
        Localizacao pos = new Localizacao(gpsx,gpsy);
        System.out.println("Introduza o seu raio de atuação");
        double raio= Double.parseDouble(s.nextLine());
        System.out.println("Encontra-se disponivel para realizar entregas?");
        System.out.println("1-Sim");
        System.out.println("2-Nao");
        int d = Integer.parseInt(s.nextLine());
        if(d == 1){
            disponibilidade = true;
        } if(d==2){
            disponibilidade =false;
        }

        try{
            b_dados.novoVoluntario(nome,pos,raio,username,pass,disponibilidade);
        }

        catch(VoluntarioExisteException e){
            System.out.println(e.getMessage());
        }
        catch(UsernameJaEstaEmUsoException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * CONSULTA DADOS CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */
    private void consultadadosUtilizador(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Informações de Conta ");
                System.out.println(b_dados.getUtilizadores().get(username).toString());
                System.out.println("1-Mudar localizacao");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        mudarLocalizacaoUtilizador(username);
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuCliente(username);

        }
    }

    private void consultadadosLoja(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Informações de Conta ");
                System.out.println(b_dados.getLojas().get(username).toString());
                System.out.println("1-Mudar localizacao");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        mudarLocalizacaoLoja(username);
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuLoja(username);

        }
    }

    private void consultadadosTransportadora(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Informações de Conta ");
                System.out.println(b_dados.getTrasnportadoras().get(username).toString());
                System.out.println("1-Mudar localizacao");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        mudarLocalizacaoTransportadora(username);
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuTransportadora(username);

        }
    }

    private void consultadadosVoluntario(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Informações de Conta ");
                System.out.println(b_dados.getVoluntarios().get(username).toString());
                System.out.println("1-Mudar localizacao");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        mudarLocalizacaoVoluntario(username);
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuVoluntario(username);

        }
    }

    private void consultarProdutos(String cod){
        for(CatalogoProdutos c : a_armazena.getCatalogos()){
            if(c.getCodLoja().equals(cod)){
                System.out.println(c);
            }
        }
    }


    /**
     * MENUS CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */
    private void menuCliente(String username){
        a_armazena.juntaCatalogos();
        a_armazena.JuntaProdutos();
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Ver Lojas");
                System.out.println("2 - Consultar Dados Pessoais");
                System.out.println("3 - Historico de Encomendas");
                System.out.println("4 - Classifica um voluntário/transportadora");


                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        verLojas(b_dados.getUtilizadores().get(username).getCodUtilizador());
                        break;
                    case 2:
                        consultadadosUtilizador(username);
                        break;
                    case 3:
                        b_dados.buscaHistoricoDisplay(b_dados.buscaHistoricoUtilizador(b_dados.getUtilizadores().get(username).getCodUtilizador()));
                        break;
                    case 4:
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch (UtilizadorNaoExisteException e){
            System.out.println(e.getMessage());
            menuCliente(username);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuCliente(username);

        }
    }

    private void menuLoja(String username){
        a_armazena.juntaCatalogos();
        a_armazena.JuntaProdutos();
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Consultar Produtos");
                System.out.println("2 - Consultar dados pessoais");
                System.out.println("3 - Consultar encomendas");
                System.out.println("4 - Hisórico");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        consultarProdutos(b_dados.getLojas().get(username).getCodLoja());
                        break;
                    case 2:
                        consultadadosLoja(username);
                        break;
                    case 3:
                        verEncomendas(b_dados.getLojas().get(username).getCodLoja());
                        break;
                    case 4:
                        b_dados.buscaHistoricoDisplay(b_dados.buscaHistoricoLoja(b_dados.getLojas().get(username).getCodLoja()));
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuLoja(username);
        }
        catch (LojaNaoExisteException e){
            System.out.println(e.getMessage());
            menuLoja(username);
        }
    }

    private void menuTransportadora(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Encomendas dentro do raio");
                System.out.println("2 - Dados pessoais");
                System.out.println("3 - Historico de encomendas ");
                System.out.println("4 - Classificações");

                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        break;
                    case 2:
                        consultadadosTransportadora(username);
                        break;
                    case 3:
                        b_dados.buscaHistoricoDisplay(b_dados.buscaHistoricoTransportadora(b_dados.getTrasnportadoras().get(username).getCodEmpresa()));
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuTransportadora(username);

        }
        catch(TransportadoraNaoExisteException e){
            System.out.println(e.getMessage());
            menuTransportadora(username);
        }
    }

    private void menuVoluntario(String username){
        Scanner s = new Scanner(System.in); int opcao = 0;
        try{
            do{
                System.out.println("Escolha o que pretende fazer");
                System.out.println("1 - Consultar encomendas no meu raio");
                System.out.println("2 - historico de encomendas");
                System.out.println("3 - Dados pessoais");
                System.out.println("4 - Classificaçoes");
                System.out.println("0 - Retroceder");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        break;
                    case 2:
                        b_dados.buscaHistoricoDisplay(b_dados.buscaHistoricoVoluntario(b_dados.getVoluntarios().get(username).getCodVoluntario()));
                        break;
                    case 3:
                        consultadadosVoluntario(username);
                        break;
                    default:
                        System.out.print("Opção inválida\n\n");
                        break;

                }
            }while(opcao != 0);
        }
        catch (VoluntarioNaoExisteException e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuVoluntario(username);

        }
    }

    /**
     * LOGIN CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
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
                k = b_dados.checkUserPassUtil(username,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuCliente(username);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();
            return;

        }
    }

    private void loginLoja(){
        Scanner s = new Scanner(System.in); int contador = 0;
        String username,pass,k;
        try{
            do{
                System.out.println("Introduza o seu username");
                username= s.nextLine();
                System.out.println("Introduza a sua password");
                pass = s.nextLine();
                contador++;
                k = b_dados.checkUserPassLoj(username,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuLoja(username);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();
            return;

        }
    }

    private void loginTransportadora(){
        Scanner s = new Scanner(System.in); int contador = 0;
        String username,pass,k;
        try{
            do{
                System.out.println("Introduza o seu username");
                username= s.nextLine();
                System.out.println("Introduza a sua password");
                pass = s.nextLine();
                contador++;
                k = b_dados.checkUSerPassTrans(username,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuTransportadora(username);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();
            return;

        }
    }

    private void loginVoluntario(){
        Scanner s = new Scanner(System.in); int contador = 0;
        String username,pass,k;
        try{
            do{
                System.out.println("Introduza o seu username");
                username= s.nextLine();
                System.out.println("Introduza a sua password");
                pass = s.nextLine();
                contador++;
                k = b_dados.checkUserPassVol(username,pass);
                if(k.equals("NOK")) System.out.println("Dados de acesso inválidos ou não registado\n");
            }while(k.equals("NOK")&& contador < 3);
            if(k.equals("NOK")) //menuInicial();
                return;

            else menuVoluntario(username);
        }
        catch(InputMismatchException e){
            System.out.println("Entrada inválida");
            menuInicial();
            return;

        }
    }

    /**
     *SUBMENUS CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */
    private void submenuCliente(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("3 - Associar conta");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        registoCliente();
                        break;
                    case 2:
                        loginCliente();
                        break;
                    case 3:
                        associarContaCliente();
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

    private void submenuLoja(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("3 - Associar conta");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        registoLoja();
                        break;
                    case 2:
                        loginLoja();
                        break;
                    case 3:
                        associarContaLoja();
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

    private void submenuTransportadora(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("3 - Associar conta");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        registoTransportadora();
                        break;
                    case 2:
                        loginTransportadora();
                        break;
                    case 3:
                        associarContaTransportadora();
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

    private void submenuVoluntario(){
        Scanner s = new Scanner(System.in);
        int opcao = 0;

        try{
            do{
                System.out.println("1 - Criar Conta");
                System.out.println("2 - Já possui conta? Log In");
                System.out.println("3 - Associar conta");
                System.out.println("0 - Sair");

                opcao = s.nextInt();
                System.out.print("\n");

                switch(opcao){
                    case 1:
                        registoVoluntario();
                        break;
                    case 2:
                        loginVoluntario();
                        break;
                    case 3:
                        associarContaVoluntario();
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
     * MENU INICIAL
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

    //Método que permite uma loja ver as encomendas que lhe foram emitidas
    public void verEncomendas(String cod){
        Scanner s = new Scanner(System.in);
        String opcao = "";
        try {
            do {
                ArrayList<Encomenda> encs=b_dados.buscaEncomendas(cod);
                if(encs.isEmpty()){
                    System.out.println("Não existem encomendas!");
                    break;
                }
                else {
                    System.out.println("Escreva o codigo de encomenda que está pronta a entregar:");
                    b_dados.buscaEncomendasDisplay(encs);
                    System.out.println("0 - Retroceder");

                    opcao = s.nextLine();
                    if(opcao.equals("0")){
                        break;
                    }
                    System.out.print("\n");
                    for(Encomenda e: encs){
                        if(e.getcodEncomenda().equals(opcao)){
                            b_dados.addEncomendaDisponivel(e);
                            b_dados.removeEncomenda(e);
                        }
                        else{
                            System.out.println("Não existe uma encomenda com esse código!");
                        }
                    }
                }
            }
            while(true);
        }
        catch (LojaNaoExisteException e){
            System.out.println(e.getMessage());
        }
        catch(InputMismatchException e) {
            System.out.println("Entrada inválida");
        }
    }
}