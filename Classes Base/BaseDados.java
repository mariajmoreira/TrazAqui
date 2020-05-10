package trazAqui;

import trazAqui.Exceptions.*;
import java.util.List;
        import java.util.ArrayList;
        import java.util.Map;
        import java.util.HashMap;
        import java.util.TreeSet;
        import java.util.Set;
        import java.time.LocalDate;
import java.io.FileNotFoundException;
import java.io.Serializable;
        import java.util.Scanner;
        import java.util.Comparator;
        import java.io.File;
import java.time.format.DateTimeFormatter;
        import java.util.Iterator;
        import java.util.Random;

/**
 * BaseDados
 * Classe que recebe os pedidos do menu e faz a gestao de todos os procedimentos necessarios
 * @author Pedro Oliveira, Luis Bigas, Bruno Alves
 */
public class BaseDados implements Serializable
{

    private Map <String,LogUtilizador> utilizadores;
    private Map <String,LogLoja> lojas;
    private Map <String,LogTransportadora> transportadoras;
    private Map <String,LogVoluntario> voluntarios;


    /**
     * Construtor vazio
     */
    public BaseDados(){
        this.utilizadores = new HashMap<>();
        this.lojas = new HashMap<>();
        this.transportadoras = new HashMap<>();
        this.voluntarios = new HashMap<>();

    }

    /**
     * Metodo construtor parameterizado
     * @param c Lista de clientes
     * @param p Lista de proprietarios
     */
    public BaseDados( Map<String,LogUtilizador> u, Map<String,LogLoja> l, Map<String,LogTransportadora> t, Map<String,LogVoluntario> v){
        setUtilizadores(u);
        setLojas(l);
        setTransportadoras(t);
        setVoluntarios(v);
    }

    /**
     * Metodo construtor por copia
     * @param list Objeto da classe BaseDados
     */
    public BaseDados(BaseDados list){
        setUtilizadores(list.getUtilizadores());
        setLojas(list.getLojas());
        setTransportadoras(list.getTransportadoras());
        setVoluntarios(list.getVoluntarios());
    }

    /**
     * Retorna um cliente especifico com base no seu Username
     * @param username O username do cliente
     * @return Um utilizador
     */
    public LogUtilizador getUtilizador(String username){
        for(LogUtilizador c : this.utilizadores.values()){
            if(c.getUsername().equals(username))
                return c;        }
        return null;
    }

    /**
     * Metodo para obter os utilizadores
     * @return Lista dos utilizadores
     */
    public Map<String,LogUtilizador> getUtilizadores(){
        Map<String,LogUtilizador> ret = new HashMap<>();
        for(LogUtilizador p : this.utilizadores.values()){
            ret.put(p.getUsername(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter as lojas
     * @return Lista das lojas
     */
    public Map<String,LogLoja> getLojas(){
        Map<String,LogLoja> ret = new HashMap<>();
        for(LogLoja p : this.lojas.values()){
            ret.put(p.getUsername(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter as transportadoras
     * @return Lista das transportadoras
     */
    public Map<String,LogTransportadora> getTransportadoras(){
        Map<String,LogTransportadora> ret = new HashMap<>();
        for(LogTransportadora p : this.transportadoras.values()){
            ret.put(p.getUsername(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter os voluntarios
     * @return Lista dos voluntarios
     */
    public Map<String,LogVoluntario> getVoluntarios(){
        Map<String,LogVoluntario> ret = new HashMap<>();
        for(LogVoluntario p : this.voluntarios.values()){
            ret.put(p.getUsername(),p.clone());
        }
        return ret;
    }

    /**
     * Adicionar um utilizador a lista de utilizadores
     * @param u um utilizador
     *
     */
    public void addUtilizador(LogUtilizador u){
        this.utilizadores.put(u.getUsername(),u.clone());
    }

    /**
     * Adicionar uma loja a lista de lojas
     * @param l uma loja
     *
     */
    public void addLoja(LogLoja l){
        this.lojas.put(l.getUsername(),l.clone());
    }

    /**
     * Adicionar um transportadora a lista de transportadoras
     * @param t uma transportadora
     *
     */
    public void addTransportadora(LogTransportadora t){
        this.transportadoras.put(t.getUsername(),t.clone());
    }

    /**
     * Adicionar um voluntario a lista de voluntarios
     * @param v um voluntario
     *
     */
    public void addVoluntario(LogVoluntario v){
        this.voluntarios.put(v.getUsername(),v.clone());
    }

    /**
     * Metodo para definir os utilizadores
     * @param u Lista de utilizadores
     */
    public void setUtilizadores(Map<String,LogUtilizador> u){
        this.utilizadores = new HashMap<>();
        for(LogUtilizador  p : u.values()){
            this.utilizadores.put(p.getUsername(),p.clone());
        }
    }

    /**
     * Metodo para definir as lojas
     * @param l Lista de lojas
     */
    public void setLojas(Map<String,LogLoja> l){
        this.lojas = new HashMap<>();
        for(LogLoja  p : l.values()){
            this.lojas.put(p.getUsername(),p.clone());
        }
    }

    /**
     * Metodo para definir as transportadoras
     * @param t Lista de transportadoras
     */
    public void setTransportadoras(Map<String,LogTransportadora> t){
        this.transportadoras = new HashMap<>();
        for(LogTransportadora p : t.values()){
            this.transportadoras.put(p.getUsername(),p.clone());
        }
    }

    /**
     * Metodo para definir os voluntarios
     * @param v Lista de voluntarios
     */
    public void setVoluntarios(Map<String,LogVoluntario> v){
        this.voluntarios = new HashMap<>();
        for(LogVoluntario  p : v.values()){
            this.voluntarios.put(p.getUsername(),p.clone());
        }
    }


    /**
     * Clonar um objecto da classe BaseDados
     */
    public BaseDados clone(){
        return new BaseDados(this);
    }



    /**
     * Metodo equals
     * @param o Objeto de uma classe qualquer
     * @return Boolean
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;

        BaseDados util = (BaseDados) o;

        for(LogUtilizador u : util.utilizadores.values())
            if(!this.utilizadores.containsValue(u))
                return false;

        for(LogLoja l : util.lojas.values())
            if(!this.lojas.containsValue(l))
                return false;

        for(LogTransportadora t : util.transportadoras.values())
            if(!this.transportadoras.containsValue(t))
                return false;

        for(LogVoluntario v : util.voluntarios.values())
            if(!this.voluntarios.containsValue(v))
                return false;

        return true;

    }


    //Tratamento de funções invocadas pelo menu

    /**
     * Verifica se um determinado utilizador existe com base no seu username
     * @param username O username do proprietario a pesquisar
     * @return Valor boleano
     */
    public boolean utilizadorExiste(String username){
        return utilizadores.containsKey(username);
    }

    /**
     * Verifica se uma determinada loja existe com base no seu username
     * @param username O username da loja a pesquisar
     * @return Valor boleano
     */
    public boolean lojaExiste(String username){
        return lojas.containsKey(username);
    }

    /**
     * Verifica se uma determinada transportadora existe com base no seu username
     * @param username O username da transportadora a pesquisar
     * @return Valor boleano
     */
    public boolean transportadoraExiste(String username){
        return transportadoras.containsKey(username);
    }

    /**
     * Verifica se um determinado voluntario existe com base no seu username
     * @param username O username do voluntario a pesquisar
     * @return Valor boleano
     */
    public boolean voluntarioExiste(String username){
        return voluntarios.containsKey(username);
    }

    /**
     * Verifica se um determinado produto existe com base na informaçao do codigo de produto
     * @param nif A matricula do veiculo a pesquisar
     * @return Valor boleano
     */
    public boolean produtoExiste(String codProd){
        for(LogLoja x : this.lojas.values()){
            for(Produto p : x.getProdutos()){
                if(p.getCodProd().equals(codProd)) return true;
            }
        }
        return false;
    }

    /**
     * Adiciona um veiculo a lista de veiculos de um proprietario
     * Lança a excepção ProprietarioNaoExisteException
     * @param nif O nif do proprietario
     * @param x O veiculo a adicionar
     */

    public void addProduto(String username, Produto x) throws LojaNaoExisteException{

        LogLoja p = this.lojas.get(username);
        if(p == null) throw new LojaNaoExisteException();

        p.addProduto(x.clone());

    }

    /**
     * Verifica se o username e a password introduzidos pelo proprietário correspondem
     *@param username O username introduzido
     *@param pass A password introduzida
     *@return O nif do proprietario caso e-mail e pass correspondam ou a string "NOK" caso não correspondam
     */
    public String checkUserPassUtilizador(String username, String pass){
        for(LogUtilizador x : this.utilizadores.values()){
            if(x.getUsername().equals(username)){
                if(x.getPassword().equals(pass)) return x.getUsername();
            }
        }
        return "NOK";
    }

    public String checkUserPassLoja(String username, String pass) {
        for (LogLoja x : this.lojas.values()) {
            if (x.getUsername().equals(username)) {
                if (x.getPassword().equals(pass)) return x.getUsername();
            }
        }
        return "NOK";
    }

    public String checkUserPassTransportadora(String username, String pass){
            for (LogTransportadora x : this.transportadoras.values()) {
                if (x.getUsername().equals(username)) {
                    if (x.getPassword().equals(pass)) return x.getUsername();
                }
            }
            return "NOK";
        }

    public String checkUserPassVoluntario(String username, String pass) {
        for (LogVoluntario x : this.voluntarios.values()) {
            if (x.getUsername().equals(username)) {
                if (x.getPassword().equals(pass)) return x.getNome();
            }
        }
        return "NOK";
    }


    /**
     * Verifica se um e-mail já se encontra registado na base de dados
     *@param mail O e-mail a pesquisar
     *@return Um valor boleano
     */
    public boolean usernameEmUso(String username){
        for(LogUtilizador u : this.getUtilizadores().values())
            if(u.getUsername().equals(username))
                return true;
        for(LogLoja l : this.getLojas().values())
            if(l.getUsername().equals(username))
               return true;
        for(LogTransportadora t : this.getTransportadoras().values())
            if(t.getUsername().equals(username))
               return true;
         for(LogVoluntario v : this.getVoluntarios().values())
            if(v.getUsername().equals(username))
                return true;
            return false;
    }



    /**
     * Regista um novo proprietário na base de dados
     *@param nif O nif
     *@param mail O e-mail
     *@param nome O nome
     *@param pass A pasword
     *@param morada A morada
     *@param nasc A data de nascimento
     *@return Um valor boleano
     */
    public void novoUtilizador(String c,String n,double gpsx, double gpsy, String username, String pass) throws UtilizadorExisteException, UsernameJaEstaEmUsoException{
        if(usernameEmUso(username)
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username"));
        LogUtilizador p = new LogUtilizador();
        p.setCodUtilizador(c);
        p.setUsername(username);
        p.setNome(n);
        p.setPassword(pass);
        p.setCoordenadaX(gpsx);
        p.setCoordenadaY(gpsy);


        if(utilizadorExiste(String username)throw new UtilizadorExisteException("Já existe um registo para esse username"));
        this.utilizadores.put(p.getUsername(),p.clone());
    }

    /**
     * Regista um novo cliente na base de dados
     *@param nif O nif
     *@param mail O e-mail
     *@param nome O nome
     *@param pass A pasword
     *@param morada A morada
     *@param nasc A data de nascimento
     *@param x A coordenada X da localização
     *@param y A coordenada Y da localização
     *@return Um valor boleano
     */
    public void novaLoja(String c,String n,double gpsx, double gpsy, String username, String pass) throws LojaExisteException, UsernameJaEstaEmUsoException{
        if(usernameEmUso(username)
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username"));
        LogLoja p = new LogLoja();
        p.setCodLoja(c);
        p.setUsername(username);
        p.setNome(n);
        p.setPassword(pass);
        p.setCoordenadaX(gpsx);
        p.setCoordenadaY(gpsy);

        if(lojaExiste(String username) throw new LojaExisteException("Já existe um registo para esse username"));
        this.lojas.put(p.getUsername(),p.clone());
    }


    public void novaTransportadora(String cod,String nome,double gpsx, double gpsy, String nif,double raio, double preco,String username, String pass) throws TransportadoraExisteException, UsernameJaEstaEmUsoException{
        if(this.usernameEmUso(username)
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username"));
        LogTransportadora p = new LogTransportadora();
        p.setCodEmpresa(cod);
        p.setUsername(username);
        p.setNome(nome);
        p.setPassword(pass);
        p.setCoordenadaX(gpsx);
        p.setCoordenadaY(gpsy);
        p.setNIF(nif);
        p.setRaio(raio);
        p.setPrecoporkm(preco);

        if(transportadoraExiste(String username) throw new TransportadoraExisteException("Já existe um registo para esse username"));
        this.transportadoras.put(p.getUsername(),p.clone());
    }

    public void novoVoluntario(String cod,String nome,double gpsx, double gpsy,double raio,String username, String pass, Boolean d) throws VoluntarioExisteException, UsernameJaEstaEmUsoException{
        if(this.usernameEmUso(username)
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username"));
        LogVoluntario p = new LogVoluntario();
        p.setCodVoluntario(cod);
        p.setUsername(username);
        p.setNome(nome);
        p.setPassword(pass);
        p.setCoordenadaX(gpsx);
        p.setCoordenadaY(gpsy);
        p.setDisponibilidade(d);

        if(voluntarioExiste(String username) throw new VoluntarioExisteException("Já existe um registo para esse username"));
        this.voluntarios.put(p.getUsername(),p.clone());
    }

    /**
     * Consultar o top10 de clientes
     * Pode ser consultado por número total de Km efectuados ou por número de alugueres efectuados
     *@return Uma lista dos 10+ clientes
     *
     */
    public List<Cliente> top10clientes(int escolha){
        List <Cliente> res = new ArrayList<>();
        if(escolha == 1){
            Comparator<Cliente> cmpClienteKm = (c1, c2) ->{if(c2.getTotaldeKm() < c1.getTotaldeKm())
                return -1;
            else
                return 1; };

            Set<Cliente> ret = new TreeSet<Cliente>(cmpClienteKm);
            double counter = 0;
            for(Cliente c: this.clientes){
                ret.add(c.clone());
            }

            Iterator it = ret.iterator();
            while(it.hasNext() && counter <10){
                Cliente x = (Cliente) it.next();
                res.add(x.clone());
                //System.out.println(x.getTotaldeKm());
                counter++;
            }
        }
        if(escolha ==2){
            Comparator<Cliente> cmpClienteN = (c1, c2) ->{if(c1.getHistorico().size() < c2.getHistorico().size())
                return 1;
            else
                return -1; };

            Set<Cliente> ret = new TreeSet<Cliente>(cmpClienteN);
            double counter = 0;
            for(Cliente c: this.clientes){
                ret.add(c.clone());
            }

            Iterator it = ret.iterator();
            while(it.hasNext() && counter <10){
                Cliente x = (Cliente) it.next();
                res.add(x.clone());
                //System.out.println(x.getTotaldeKm());
                counter++;
            }
        }
        return res;
    }

    /**
     *Mudar a localização de um cliente
     *@param nif O nif do cliente
     *@param x A coordenada X da localização
     *@param y A coordenada Y da localização
     */
    public void setLocalizacaoCliente(String nif, double x, double y){
        Localizacao loc = new Localizacao(x,y);
        for(Cliente c : clientes){
            if(c.getNif().equals(nif)){
                c.setPosicao(loc);
            }
        }
    }

    /**
     * Consultar o top10 de veículos com maior número de Km efectuados
     *
     */
    public List<Veiculo> top10Veiculos(){
        //Comparator<Veiculo> cmpVeiculo = (v1, v2) ->{if(v1.getHistorico().size() < v2.getHistorico().size())
        Comparator<Veiculo> cmpVeiculo = (v1, v2) ->{if(v1.getTotaldeKmV() < v2.getTotaldeKmV())
            return 1;
        else
            return -1; };

        Map<String,Proprietario> props = this.getProprietarios();
        Set<Veiculo> ret = new TreeSet<Veiculo>(cmpVeiculo);
        List<Veiculo> res = new ArrayList<>();

        Iterator it = props.values().iterator();
        while(it.hasNext()){
            Proprietario p = (Proprietario) it.next();
            for(Veiculo v : p.getVeiculos()){
                ret.add(v.clone());
            }
        }
        int counter = 0;
        Iterator in = ret.iterator();
        while(in.hasNext() && counter <10){
            Veiculo x = (Veiculo) in.next();
            res.add(x.clone());
            //System.out.println(x.getTotaldeKm());
            counter++;
        }
        return res;

    }

    /**
     * Adiciona novo produto a uma loja
     *@param nif O nif do proprietário
     *@param marca Marca do veículo
     *@param matricula Matricula do veículo
     *@param velocidadeM Velocidade média do veículo
     *@param precoKm O preço por Km
     *@param x Coordenada X da localização do veículo
     *@param y Coordenada Y da localização do veículo
     *@param combustivel Valor inteiro que corresponde ao tipo de combustivel do Veículo
     *@param consumo Valor inteiro que coresponde ao consumo por Km do veículo
     *@param autonomia Valor inteiro que coresponde à autonomia do veículo
     *@param autonomiaMax Valor inteiro que coresponde à autonomia máxima do veículo
     */
    public void novoProduto(String username,String codProd,String desc,double preco,int qnt) throws ProdutoExisteException{
            Produto prod = new Produto();
            prod.setCodProd(codProd);
            prod.setDescricao(desc);
            prod.setPreco(preco);
            prod.setStock(qnt);


            LogLoja p = this.lojas.get(username);
            if(produtoExiste(codProd) throw new ProdutoExisteException("Produto já registado"));
            else p.addProduto(prod.clone());
    }


    /**
     * Remover um veículo de um proprietário
     * @param nif String com o nif do proprietário
     * @param matricula String com a matricula do veículo a remover
     */
    public int removeProduto(String username,String nome) throws ProdutoNaoExisteException{
        LogLoja p = this.lojas.get(username);
        int x = p.removeProduto(nome);
        if(x==0) throw new ProdutoNaoExisteException("Produto não registado");
        return x;

    }

    /**
     * Consultar histórico de alugueres de todos os veículos de um proprietário
     * @param nif O nif do proprietário
     * @param dataI String com a data inicial da pesquisa (AAAA-MM-DD)
     * @param dataF String com a data final da pesquisa (AAAA-MM-DD)
     * @return Registo de histórico de alugueres
     */
    public List <HistoricoProprietario> consultaHistorico(String nif,String dataI, String dataF) throws HistoricoNaoExisteException{
        Proprietario p = this.proprietarios.get(nif).clone();
        List<HistoricoProprietario> ret = new ArrayList<>();
        DateTimeFormatter dateFormatte = DateTimeFormatter.ofPattern("y-M-d");
        LocalDate dateI = LocalDate.parse(dataI, dateFormatte);
        LocalDate dateF = LocalDate.parse(dataF, dateFormatte);
        for(HistoricoProprietario hist : p.getHistorico()){
            if(hist.getData().isAfter(dateI) && hist.getData().isBefore(dateF)){
                ret.add(hist.clone());
            }
        }
        if(ret.size()==0) throw new HistoricoNaoExisteException("Sem registos");
        return ret;
    }

    /**
     * Obter a classificação de um veículo
     * @param nif String com o nif do proprietario
     * @param mat A matricula do veículo a pesquisar
     * @return Valor da classificação do veículo
     */
    public double ClassifVeiculo(String nif, String mat)throws VeiculoNaoExisteException{
        Proprietario p = this.proprietarios.get(nif); double k = -1;
        List<Veiculo> ret = p.getVeiculos();
        for(Veiculo car : ret){
            if(car.getMatricula().equals(mat)){
                k = car.classifMedia();
            }
        }
        if(k == -1) throw new VeiculoNaoExisteException("Veiculo não registado");
        return k;
    }

    /**
     * Alterar o preço por Km de um veículo
     * Lança a excepção VeiculoNaoExisteException
     * @param nif String com o nif do proprietario
     * @param matricula A matricula do veículo
     * @param preco Valor do novo preço
     * @return Valor da classificação do veículo
     */
    public void mudaPrecoKm(String username,String nome, double preco) throws TransportadoraNaoExisteException{
        LogTransportadora p = this.transportadoras.get(username);
        List<Veiculo> ret = p.getVeiculos(); boolean x = false;
        while(!x){
            for(Veiculo car : ret){
                if(car.getMatricula().equals(matricula)) car.setPrecoKm(preco);
                x = true;
            }
        }
        if(!x) throw new VeiculoNaoExisteException("Veiculo não existe.");
        p.setVeiculos(ret);
    }

    /**
     * Consultar histórico de alugueres de um veículos de um proprietário
     * Lança a excepção VeiculoNaoExisteException
     * @param nif O nif do proprietário
     * @param mat Matricula do veículo
     * @return Registo de histórico de alugueres
     */
    public List< HistoricoVeiculo> historicoUmVeiculo(String nif,String mat) throws VeiculoNaoExisteException{
        Proprietario p = this.proprietarios.get(nif);
        List<HistoricoVeiculo> ret = new ArrayList<>();
        for(Veiculo car : p.getVeiculos()){
            if(car.getMatricula().equals(mat)){
                ret = car.getHistorico();
            }
        }
        if(ret == null) throw new VeiculoNaoExisteException("Não existe histórico / Veiculo inexistente");
        return ret;

    }

    /**
     * Obter a classificação de um proprietário
     * @param nif String com o nif do proprietario
     * @return O valor da classificação
     */
    public double classProp(String nif){
        Map<String,Proprietario> ret = this.getProprietarios();
        Proprietario p = ret.get(nif).clone();
        return p.getClassificacao();
    }

    /**
     * Consultar valores facturados por um veículo
     * Lança a excepção VeiculoNaoExisteException
     * @param nif String com o nif do proprietario
     * @param mat String com a matricula do veiculo
     * @return O valor facturado
     */
    public double ganhosVeiculo(String nif,String mat) throws VeiculoNaoExisteException{
        double ganhos = 0;
        Proprietario p = this.proprietarios.get(nif).clone();
        for(Veiculo v : p.getVeiculos()){
            if(v.getMatricula().equals(mat)){
                ganhos = v.ganhosFacturados();
            }
        }
        if(ganhos == 0) throw new VeiculoNaoExisteException("Sem valores facturados/Viatura inexistente \n");
        return ganhos;
    }

    public List<HistoricoCliente> histCliente(String nif, String dataI, String dataF) throws HistoricoNaoExisteException{
        List<HistoricoCliente> res = new ArrayList<>();
        Cliente c = this.getCliente(nif);
        DateTimeFormatter dateFormatte = DateTimeFormatter.ofPattern("y-M-d");
        LocalDate dateI = LocalDate.parse(dataI, dateFormatte);
        LocalDate dateF = LocalDate.parse(dataF, dateFormatte);
        for(HistoricoCliente hist : c.getHistorico()){
            if(hist.getData().isAfter(dateI) && hist.getData().isBefore(dateF)){
                res.add(hist.clone());
            }
        }

        if(res.size() == 0) throw new HistoricoNaoExisteException("Não existe histórico");
        return res;
    }

    /**
     * Obter a classificação de um cliente
     * @param nif String com o nif do cliente
     * @return O valor da classificação
     */
    public double classfCliente(String nif){
        double k = 0;
        Cliente c = getCliente(nif);
        k = c.getClassificacao();
        return k;
    }

    /**
     * Ordenar os veiculos por preco
     * @return Informação com os vaículos ordenados
     */
    public TreeSet<LogTransportadora> getVeiculosOrdemPreco(){
        Comparator<LogTransportadora> cmpVeiculo = (v1, v2) -> {if(v1.getPrecoporkm() < v2.getPrecoporkm())
            return -1;
        else
            return 1; };
        TreeSet<LogTransportadora> ret = new TreeSet<>(cmpVeiculo);

        for(LogTransportadora p : this.transportadoras.values()){
                ret.add(p.clone());
            }
        return ret;
    }

    /**
     * Encontrar o veículo mais próximo da localização do cliente
     * Lança a excepção NoSuchElementException
     * Verifica se o veiculo tem autonomia para satisfazer a distância de viagem
     * @param pos A localização do cliente
     * @param tipo Valor inteiro correspondente ao tipo de combustivel pretendido pelo cliente
     * @return um veículo
     */
    public LogVoluntario devolveMaisPerto(Localizacao pos,int tipo) {
        TreeSet<LogVoluntario> v = getVeiculosOrdemDist(pos);
        LogVoluntario viavel = null;
        boolean escolhido = false;
        Iterator it = v.iterator();
        while (it.hasNext() && !escolhido) {
            Voluntario c = (Voluntario) it.next();
            double dist = c.getPosicao().distLocalizacao(pos);
            if (c.getAutonomia() > dist && c.getDisponibilidade) {
                escolhido = true;
                viavel = c.clone();
            }
        }
        //if(viavel == null) throw new NoSuchElementException();
        return viavel;
    }

    /**
     * Encontrar o veículo mais barato
     * Lança a excepção NoSuchElementException
     * Verifica se o veiculo tem autonomia para satisfazer a distância de viagem
     * @param pos A localização do cliente
     * @param tipo Valor inteiro correspondente ao tipo de combustivel pretendido pelo cliente
     * @return um veículo
     */
    public LogTransportadora devolveMaisBarato(Localizacao pos,int tipo){
        boolean escolhido = false;
        TreeSet<Veiculo> veiculos = getVeiculosOrdemPreco();
        Veiculo viavel = null;
        Iterator it = veiculos.iterator();
        switch(tipo){
            case 1:
                while(it.hasNext() && !escolhido){
                    Veiculo c = (Veiculo) it.next();
                    double dist = c.getPosicao().distLocalizacao(pos);
                    if(c.getAutonomia()>dist && c instanceof CarroElectrico){
                        escolhido = true;
                        viavel = c.clone();
                    }

                }

                //if(viavel == null) throw new NoSuchElementException();

                break;

            case 2:
                it = veiculos.iterator();
                while(it.hasNext() && !escolhido){
                    Veiculo c = (Veiculo) it.next();
                    double dist = c.getPosicao().distLocalizacao(pos);
                    if(c.getAutonomia()>dist && c instanceof CarroHibrido){
                        escolhido = true;
                        viavel = c;
                    }

                }
                //if(viavel == null) throw new NoSuchElementException();
                break;


            case 3:
                it = veiculos.iterator();
                while(it.hasNext() && !escolhido){
                    Veiculo c = (Veiculo) it.next();
                    double dist = c.getPosicao().distLocalizacao(pos);
                    if(c.getAutonomia()>dist && c instanceof CarroCombustao){
                        escolhido = true;
                        viavel = c;
                    }

                }
                //if(viavel == null) throw new NoSuchElementException();
                break;
        }
        return viavel;
    }

    /**
     * Obter a localização do cliente a partir no Nif
     * @param nif O nif do cliente
     * @return Uma localização
     */
    public Localizacao getLocalizacaoCliente(String nif){
        Localizacao b = new Localizacao();
        for(Cliente c : this.getClientes()){
            if(c.getNif().equals(nif))
                b =  c.getPosicao();
        }
        return b;
    }


    /**
     * Ordenar os veiculos por distancia a um ponto
     * @param dest ponto ao qual se compara a distancia
     * @return Informação ordenada dos veículos
     */
    public TreeSet<Voluntario> getVeiculosOrdemDist(Localizacao dest){
        Comparator<Voluntario> cmpVoluntarios = (v1, v2) -> {
            if(v1.getPosicao().distLocalizacao(dest) < v2.getPosicao().distLocalizacao(dest))
                return -1;
            else
                return 1; };

        TreeSet<Voluntario> ret = new TreeSet<>(cmpVoluntarios);

        for(LogVoluntario p : this.voluntarios.values()){
                ret.add(p.clone());
        }
        return ret;
    }

    /*
     * Obter um proprietário pela informação do nif
     * @param nif String com o nif do proprietário
     */
    public LogUtilizador getUtilizado(String username){
        return this.utilizadores.get(username);
    }

    public LogLoja getLoja(String username){
        return this.lojas.get(username);
    }

    public LogTransportadora getTransportadora(String username){
        return this.transportadoras.get(username);
    }

    public LogVoluntario getVoluntario(String username){
        return this.voluntarios.get(username);
    }

    /*
     * Adicionar um aluguer ao historico do cliente
     * @param nif String com o nif do proprietário
     * @param hist O historico a adicionar
     */
    public void addHistCli(String nif, HistoricoCliente hist){
        for(Cliente c : clientes){
            if(c.getNif().equals(nif)){
                c.addHistorico(hist);
                return;
            }
        }
    }

    public void addHistPropVeic(String nif, HistoricoProprietario hp, HistoricoVeiculo hv){
        Proprietario p = this.proprietarios.get(nif);
        p.addHistorico(hp);
        p.addHistVeiculo(hp.getMatricula(), hv);

    }

    public void addHistoricos(HistoricoProprietario hp, HistoricoVeiculo hv, HistoricoCliente hc){
        String nifCli = hv.getCliente();
        String nifProp = hc.getProprietario();

        this.addHistPropVeic(nifProp, hp, hv);
        this.addHistCli(nifCli, hc);

    }

    /**
     * Tratamento de todos os processos relacionados com um aluger
     * Regista informação em cada tipo de histórico
     * @param veic Um veiculo
     * @param c Um cliente
     * @param dest A localização de destino do aluguer
     */
    public void registaEncomenda(Veiculo veic, Cliente c, Localizacao dest){
        HistoricoCliente hc = new HistoricoCliente();
        HistoricoProprietario hp = new HistoricoProprietario();
        HistoricoVeiculo hv = new HistoricoVeiculo();

        LocalDate localdate = LocalDate.now();
        String matric = veic.getMatricula();
        String nifProp = veic.getNif();
        double preco = getPrecoAluguer(veic, c, dest);
        double distancia = dest.distLocalizacao(c.getPosicao());
        Proprietario p = proprietarios.get(veic.getNif());
        if(veic.getAutonomia()<0.1*veic.getAutonomiaMax()){
            p.abasteceVeiculo(veic);
        }

        hc.setData(localdate);
        hc.setCustoV(preco);
        hc.setDistV(distancia);
        hc.setMatricula(matric);
        hc.setProprietario(nifProp);

        hp.setData(localdate);
        hp.setCustoV(preco);
        hp.setDistV(distancia);
        hp.setMatricula(matric);
        hp.setCliente(c.getNif());

        hv.setData(localdate);
        hv.setCustoV(preco);
        hv.setDistV(distancia);
        hv.SetCliente(c.getNif());

        this.addHistoricos(hp, hv, hc);

    }

    /**
     * Obter preco de um aluguer
     * @param veic Veiculo a ser Cdo
     * @param cli Cliente a fazer o aluguer
     * @param dest Localizacao de destino do aluguer
     */
    public double getPrecoAluguer(Veiculo veic, Cliente cli, Localizacao dest){
        double preco = veic.getPrecoKm() * (dest.distLocalizacao(cli.getPosicao()) * veic.getTaxa() * cli.getTaxaIdade());
        return preco;

    }


    /**
     * Iniciar adicionar um aluguer a partir do ficheiro de carregamento inicial
     * @param nifCli nif do cliente que fez o aluguer
     * @param dest Localizacao final do aluguer
     * @param typeV tipo de veiculo(combustivel) a alugar
     * @param pref preferencia de veiculo(distancia/preco) a alugar
     */
/*    public void parseAluguer(String nifCli, Localizacao dest, String typeV, String pref){
        TreeSet<Veiculo> veiculos = null;

        String matricula = "";
        switch(pref){
            case "MaisPerto":
                veiculos = this.getVeiculosOrdemDist(dest);
                break;
            case "MaisBarato":
                veiculos = this.getVeiculosOrdemPreco();
                break;
        }

        List<Veiculo> aux = new ArrayList<>();

        switch(typeV){
            case "Electrico":
                for(Veiculo v : veiculos){
                    if(v instanceof CarroElectrico){
                    if(v.getAutonomia() < 0.1*v.getAutonomiaMax()){
                        Proprietario p = this.proprietarios.get(v.getNif());
                        p.abasteceVeiculo(v);

                    }
                    aux.add(v);
                }
                }
                break;

            case "Gasolina":
                for(Veiculo v : veiculos){
                    if(v instanceof CarroCombustao){
                        if(v.getAutonomia() < 0.1*v.getAutonomiaMax()){
                        Proprietario p = this.proprietarios.get(v.getNif());
                        p.abasteceVeiculo(v);

                    }
                    aux.add(v);
                }
                }
                break;

            case "Hibrido":
                for(Veiculo v : veiculos){
                    if(v instanceof CarroHibrido){
                        if(v.getAutonomia() < 0.1*v.getAutonomiaMax()){
                        Proprietario p = this.proprietarios.get(v.getNif());
                        p.abasteceVeiculo(v);

                    }
                    aux.add(v);
                }
                }
                break;
        }

        if(aux.size() == 0)
            return;

        Cliente c = getCliente(nifCli);
        this.registarAluguer(aux.get(0), c, dest);
    }
*/
    /**
     * Adicionar uma classificação a um cliente
     * @param nif String com o nif do cliente
     * @param clas O valor da classificação
     */

    public void classificaCli(String nif, Integer clas){
        for(Cliente c : clientes){
            if(c.getNif().equals(nif))
                c.addAvaliacao(clas);
            return;
        }
    }

    /**
     * Adicionar uma classificação a um proprietario
     * @param nif String com o nif do proprietario
     * @param clas O valor da classificação
     */

    public void classificaProp(String nif, Integer clas){
        Proprietario p = getProprietario(nif);
        p.addAvaliacao(clas);
    }

    public void classificaUtil(String nif, Integer clas){
        if(this.clienteExiste(nif)){
            this.classificaCli(nif,clas);
            return;
        }
        if(this.proprietarioExiste(nif)){
            this.classificaProp(nif,clas);
            return;
        }
    }

    public void abastecerVeiculos(String nif){
        Proprietario p = this.proprietarios.get(nif);
        p.abastecerVeiculos();
    }

    /**
     * Obter lista de veículos de um proprietário
     * @param nif String com o nif do proprietário
     * @return Informação de todos os veiculos
     */
    public List<Veiculo> getVeiculos(String nif) throws VeiculoNaoExisteException{
        Proprietario p = proprietarios.get(nif);
        List<Veiculo> ret = p.getVeiculos();
        if(ret.size()==0) throw new VeiculoNaoExisteException("Sem veículos registados");
        return ret;
    }

    /**
     * Adicionar uma classificação a um veículo
     * @param nif String com a matricula do veiculo
     * @param clas O valor da classificação
     */
    public void classificaVeic(String mat, Integer clas){
        for(Proprietario p : this.proprietarios.values()){
            if(p.getVeiculos().contains(mat)){
                p.addClassVeic(mat, clas);
            }
        }
    }

    public void parseClassificacao(String first, Integer clas){
        if(first.matches("[0-9]+")){
            this.classificaUtil(first, clas);
            return;
        }
        else{
            this.classificaVeic(first, clas);
            return;
        }

    }

    /**
     * Gestão do processo de aluguer
     * Lança a excepção VeiculoNaoExisteException caso o cliente opte por escolher um veículo específico
     * @param nifCliente String com o nif do cliente
     * @param combustivel Valor inteiro correspondente ao tipo de aluguer escolhido pelo cliente (1 - electrico, 2 - hibrido, 3 - combustão, 4 - escolher viatura especifico)
     * @param escolha Forma de aluguer 1 - Mais perto, 2 - Mais barato
     * @param x Coordenada X do destino
     * @param y Coordenada Y do destino
     * @param mat Matricula do veículo; Caso não seja escolhido aluguer especifico, este campo é uma string vazia
     */
    public String alugaCar(String nifCliente,int combustivel,double escolha,double x, double y,String mat)throws VeiculoNaoExisteException,VeiculoSemAutonomiaException{ //escolha 1 - mais perto, 2 mais barato
        // combustivel 1 - electrico,2 - hibrido, 3 combustao;
        Random gerador = new Random();
        Localizacao a = new Localizacao(x,y);
        String str = "";
        List<Veiculo> lista = new ArrayList<>();

        if(combustivel == 4){
            Veiculo c = null;
            Proprietario p = new Proprietario();
            Cliente cl = getCliente(nifCliente);
            for(Proprietario k : this.proprietarios.values()){
                for(Veiculo v : k.getVeiculos()){
                    if(v.getMatricula().equals(mat)){
                        p = k;
                        c = v;
                    }
                }
            }
            if(c==null) throw new VeiculoNaoExisteException("Não existe o veículo pretendido.");
            if(c.getAutonomia() < c.getPosicao().distLocalizacao(a)) throw new VeiculoSemAutonomiaException("Veiculo sem autonomia suficiente.");

            Localizacao cliente = c.getPosicao();

            double dist = cliente.distLocalizacao(a);
            double custo = getPrecoAluguer(c,cl,a);
            cl.setPosicao(a);
            LocalDate data = LocalDate.now();
            int classifC = gerador.nextInt(101);
            int classifP = gerador.nextInt(101);
            int classifV = gerador.nextInt(101);
            HistoricoCliente histC = new HistoricoCliente(data,custo,dist,c.getMatricula(),classifC,p.getNif());
            HistoricoProprietario histP = new HistoricoProprietario(data,custo,dist,c.getMatricula(),cl.getNif(),classifP);
            HistoricoVeiculo histV = new HistoricoVeiculo(data,custo,dist,classifV,nifCliente);
            cl.addHistorico(histC);
            cl.addAvaliacao(classifC);
            p.addHistorico(histP);
            p.addAvaliacao(classifP);
            lista = p.getVeiculos();
            for(Veiculo v : lista){
                if(v.getMatricula().equals(c.getMatricula())){
                    v.setPosicao(a);

                    v.setAutonomia(v.getAutonomia()-(dist*v.getConsumo()));
                    if(v.getAutonomia()<0.1*v.getAutonomiaMax()){
                        p.abasteceVeiculo(v);
                    }
                    v.addHistorico(histV);
                    v.addAvaliacao(classifV);
                }

            }


            p.setVeiculos(lista);
            str = ("A sua viagem custou " + /*Math.floor(*/custo + "€ no veículo " + c.getMatricula()+ " do proprietário "+p.getNif());

        }

        if(escolha == 1){
            Veiculo c = devolveMaisPerto(a,combustivel);
            if(c == null) throw new VeiculoNaoExisteException("Nao foi encontrado um veiculo para alugar");
            Cliente cl = getCliente(nifCliente);
            Proprietario p = proprietarios.get(c.getNif());
            Localizacao cliente = c.getPosicao();
            double dist = cliente.distLocalizacao(a);
            double custo = getPrecoAluguer(c,cl,a);
            cl.setPosicao(a);
            LocalDate data = LocalDate.now();
            int classifC = gerador.nextInt(101);
            int classifP = gerador.nextInt(101);
            int classifV = gerador.nextInt(101);
            HistoricoCliente histC = new HistoricoCliente(data,custo,dist,c.getMatricula(),classifC,p.getNif());
            HistoricoProprietario histP = new HistoricoProprietario(data,custo,dist,c.getMatricula(),cl.getNif(),classifP);
            HistoricoVeiculo histV = new HistoricoVeiculo(data,custo,dist,classifV,nifCliente);
            cl.addHistorico(histC);
            cl.addAvaliacao(classifC);
            p.addHistorico(histP);
            p.addAvaliacao(classifP);
            lista = p.getVeiculos();
            for(Veiculo v : lista){
                if(v.getMatricula().equals(c.getMatricula())){
                    v.setPosicao(a);
                    v.setAutonomia(v.getAutonomia()-(dist*v.getConsumo()));
                    if(v.getAutonomia()< 0.1*v.getAutonomiaMax()){
                        p.abasteceVeiculo(v);
                    }
                    v.addHistorico(histV);
                    v.addAvaliacao(classifV);
                }

            }
            p.setVeiculos(lista);
            str = ("A sua viagem custou " + /*Math.floor(*/custo + "€ no veículo " + c.getMatricula()+ " do proprietário "+p.getNif());

        }

        else if(escolha == 2){
            Veiculo c = devolveMaisBarato(a,combustivel);
            if(c == null) throw new VeiculoNaoExisteException("Nao foi encontrado um veiculo para alugar");
            Cliente cl = getCliente(nifCliente);
            Proprietario p = proprietarios.get(c.getNif());
            Localizacao cliente = c.getPosicao();
            double dist = cliente.distLocalizacao(a);
            double custo = getPrecoAluguer(c,cl,a);
            cl.setPosicao(a);
            LocalDate data = LocalDate.now();
            int classifC = gerador.nextInt(101);
            int classifP = gerador.nextInt(101);
            int classifV = gerador.nextInt(101);
            HistoricoCliente histC = new HistoricoCliente(data,custo,dist,c.getMatricula(),classifC,p.getNif());
            HistoricoProprietario histP = new HistoricoProprietario(data,custo,dist,c.getMatricula(),cl.getNif(),classifP);
            HistoricoVeiculo histV = new HistoricoVeiculo(data,custo,dist,classifV,nifCliente);
            cl.addHistorico(histC);
            cl.addAvaliacao(classifC);
            p.addHistorico(histP);
            p.addAvaliacao(classifP);
            lista = p.getVeiculos();
            for(Veiculo v : lista){
                if(v.getMatricula().equals(c.getMatricula())){
                    v.setPosicao(a);

                    v.setAutonomia(v.getAutonomia()-(dist*v.getConsumo()));
                    if(v.getAutonomia()<0.1*v.getAutonomiaMax()){
                        p.abasteceVeiculo(v);
                    }
                    v.addHistorico(histV);
                    v.addAvaliacao(classifV);
                }

            }


            p.setVeiculos(lista);
            str = ("A sua viagem custou " + /*Math.floor(*/custo + "€ no veículo " + c.getMatricula()+ " do proprietário "+p.getNif());
        }

        return str;
    }

    /**
     * Carregamento de dados a partir de um ficheiro de texto
     *
     */
    public void loadSaveFile() {
        try {
            Scanner scanner = new Scanner(new File("loadfile.txt"));
            while (scanner.hasNextLine()) {
                String[] arrInfo;
                String[] arrStr = scanner.nextLine().split(":");
                int s;
                switch(arrStr[0]){
                    case "NovoProp":

                        arrInfo = arrStr[1].split(",");

                        s = arrInfo.length;

                        if(this.proprietarioExiste(arrInfo[1])){
                            continue;
                        }
                        Proprietario p = new Proprietario();
                        p.setNome(arrInfo[0]);
                        p.setNif(arrInfo[1]);
                        p.setEmail(arrInfo[2]);
                        p.setMorada(arrInfo[3]);

                        this.addProprietario(p);
                        break;

                    case "NovoCliente":
                        arrInfo = arrStr[1].split(",");
                        s = arrInfo.length;

                        if(this.clienteExiste(arrInfo[1])){
                            continue;
                        }
                        Localizacao pos = new Localizacao(Double.parseDouble(arrInfo[4]), Double.parseDouble(arrInfo[5]));
                        Cliente c = new Cliente();
                        c.setNome(arrInfo[0]);
                        c.setNif(arrInfo[1]);
                        c.setEmail(arrInfo[2]);
                        c.setMorada(arrInfo[3]);
                        c.setPosicao(pos);

                        this.addCliente(c);
                        break;

                    case "NovoCarro":{
                        arrInfo = arrStr[1].split(",");
                        s = arrInfo.length;
                        if(this.veiculoExiste(arrInfo[2])){
                            continue;
                        }

                        switch(arrInfo[0]){
                            case "Electrico":
                                VeiculoElectrico ve = new CarroElectrico();
                                ve.setMarca(arrInfo[1]);
                                ve.setMatricula(arrInfo[2]);
                                ve.setNif(arrInfo[3]);
                                ve.setVelocidadeMedia(Double.parseDouble(arrInfo[4]));
                                ve.setPrecoKm(Double.parseDouble(arrInfo[5]));
                                ve.setConsumo(Double.parseDouble(arrInfo[6]));
                                ve.setAutonomiaMax(Double.parseDouble(arrInfo[7]));
                                ve.setAutonomia(Double.parseDouble(arrInfo[7]));
                                Localizacao a = new Localizacao(Double.parseDouble(arrInfo[8]),Double.parseDouble(arrInfo[9]));
                                ve.setPosicao(a);

                                try{
                                    this.addViatura(arrInfo[3],ve.clone());}

                                catch(ProprietarioNaoExisteException e) {
                                    continue;
                                }

                                break;
                            case "Gasolina":
                                VeiculoCombustao vc = new CarroCombustao();
                                vc.setMarca(arrInfo[1]);
                                vc.setMatricula(arrInfo[2]);
                                vc.setNif(arrInfo[3]);
                                vc.setVelocidadeMedia(Double.parseDouble(arrInfo[4]));
                                vc.setPrecoKm(Double.parseDouble(arrInfo[5]));
                                vc.setConsumo(Double.parseDouble(arrInfo[6]));
                                vc.setAutonomiaMax(Double.parseDouble(arrInfo[7]));
                                vc.setAutonomia(Double.parseDouble(arrInfo[7]));
                                Localizacao b = new Localizacao(Double.parseDouble(arrInfo[8]),Double.parseDouble(arrInfo[9]));
                                vc.setPosicao(b);

                                try{
                                    this.addViatura(arrInfo[3],vc.clone());}

                                catch(ProprietarioNaoExisteException e) {
                                    continue;
                                }
                                break;

                            case "Hibrido":
                                VeiculoHibrido vh = new CarroHibrido();
                                vh.setMarca(arrInfo[1]);
                                vh.setMatricula(arrInfo[2]);
                                vh.setNif(arrInfo[3]);
                                vh.setVelocidadeMedia(Double.parseDouble(arrInfo[4]));
                                vh.setPrecoKm(Double.parseDouble(arrInfo[5]));
                                vh.setConsumo(Double.parseDouble(arrInfo[6]));
                                vh.setAutonomiaMax(Double.parseDouble(arrInfo[7]));
                                vh.setAutonomia(Double.parseDouble(arrInfo[7]));
                                Localizacao d = new Localizacao(Double.parseDouble(arrInfo[8]),Double.parseDouble(arrInfo[9]));
                                vh.setPosicao(d);

                                try{
                                    this.addViatura(arrInfo[3],vh);}

                                catch(ProprietarioNaoExisteException e) {
                                    continue;
                                }

                                break;
                        }

                        break;
                    }

                    case "Aluguer":

                        arrInfo = arrStr[1].split(",");
                        if(!clienteExiste(arrInfo[0])){
                            continue;
                        }
                        int combustivel = 0; double escolha = 0;
                        Localizacao dest = new Localizacao(Double.parseDouble(arrInfo[1]), Double.parseDouble(arrInfo[2]));
                        if(arrInfo[3].equals("Electrico")) combustivel = 1;
                        if(arrInfo[3].equals("Hibrido")) combustivel = 2;
                        if(arrInfo[3].equals("Gasolina")) combustivel = 3;
                        if(arrInfo[4].equals("MaisPerto")) escolha = 1;
                        if(arrInfo[4].equals("MaisBarato")) escolha = 2;
                        //this.parseAluguer(arrInfo[0], dest, arrInfo[3], arrInfo[4]);
                        double x = Double.parseDouble(arrInfo[1]);
                        double y = Double.parseDouble(arrInfo[2]);
                        try{
                            alugaCar(arrInfo[0],combustivel,escolha,x,y,"");
                            break;
                        }
                        catch(VeiculoSemAutonomiaException e){
                            System.out.println(e.getMessage());
                        }
                        catch(VeiculoNaoExisteException e){
                            System.out.println(e.getMessage());
                        }

                    case "Classificar":
                        arrInfo = arrStr[1].split(",");
                        this.parseClassificacao(arrInfo[0], Integer.parseInt(arrInfo[1]));
                        break;

                }

            }
            scanner.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }


}


