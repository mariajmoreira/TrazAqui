package trazaqui;

import trazaqui.Exceptions.*;

import java.io.Serializable;
import java.util.*;

public class BaseDados implements Serializable {
    private Map <String,LogUtilizador> utilizadores;
    private Map <String,LogTransportadora> transportadoras;
    private Map <String,LogVoluntario> voluntarios;
    private Map <String,LogLoja> lojas;
    private Map <String,Encomenda> encomendas;

    //getters
    public Map<String,LogUtilizador> getUtilizadores(){return new HashMap<>(this.utilizadores);}

    public Map<String,LogTransportadora> getTrasnportadoras(){return new HashMap<>(this.transportadoras);}

    public Map<String, LogVoluntario> getVoluntarios(){return new HashMap<>(this.voluntarios);}

    public Map<String, LogLoja> getLojas(){return new HashMap<>(this.lojas);}

    public Map<String, Encomenda> getEncomendas(){return new HashMap<>(this.encomendas);}

    //setters
    public void setUtilizadores(Map<String,LogUtilizador> user){this.utilizadores=new HashMap<>(user);}

    public void setTransportadoras(Map<String,LogTransportadora> trans){this.transportadoras=new HashMap<>(trans);}

    public void setVoluntarios(Map<String,LogVoluntario> vol){this.voluntarios=new HashMap<>(vol);}

    public void setLojas(Map<String,LogLoja> loj){this.lojas=new HashMap<>(loj);}

    public void setEncomendas(Map<String,Encomenda> enc){this.encomendas=new HashMap<>(enc);}

    //clone
    public BaseDados clone(){return new BaseDados(this);}

    //construtor vazio
    public BaseDados(){
        this.utilizadores=new HashMap<>();
        this.transportadoras=new HashMap<>();
        this.voluntarios=new HashMap<>();
        this.lojas=new HashMap<>();
        this.encomendas=new HashMap<>();
    }

    //construtor parametrizado
    public BaseDados(Map<String,LogUtilizador> user,Map<String,LogTransportadora> trans, Map<String,LogVoluntario> vol, Map<String,LogLoja> loj, Map<String,Encomenda> enc){
        setUtilizadores(user);
        setTransportadoras(trans);
        setVoluntarios(vol);
        setLojas(loj);
        setEncomendas(enc);
    }

    //construtor por copia
    public BaseDados(BaseDados bd){
        setUtilizadores(bd.getUtilizadores());
        setTransportadoras(bd.getTrasnportadoras());
        setVoluntarios(bd.getVoluntarios());
        setLojas(bd.getLojas());
        setEncomendas(bd.getEncomendas());
    }

    //metodo equals
    public boolean equals (Object o){
        if (this==o) return true;
        if ( (o==null) || (o.getClass()!=this.getClass())) return false;

        BaseDados bd = (BaseDados) o;

        for (LogUtilizador lu : bd.utilizadores.values()){
            if(!this.utilizadores.containsValue(lu)){
                return false;
            }
        }
        for (LogTransportadora lt: bd.transportadoras.values()){
            if(!this.transportadoras.containsValue(lt)){
                return false;
            }
        }
        for (LogVoluntario lu: bd.voluntarios.values()){
            if(!this.voluntarios.containsValue(lu)){
                return false;
            }
        }
        for (LogLoja ls: bd.lojas.values() ){
            if(!this.lojas.containsValue(ls)){
                return false;
            }
        }
        for (Encomenda e:bd.encomendas.values()){
            if(!this.encomendas.containsValue(e)){
                return false;
            }
        }

        return true;

    }

    //metodo para adicionar um utilizador
    // à lista de utilizadores
    public void addUtilizador(LogUtilizador user){
        this.utilizadores.put(user.getUsername(),user.clone());
    }

    //à lista de transportadoras
    public void addTransportadora(LogTransportadora trans){ this.transportadoras.put(trans.getUsername(),trans.clone()); }

    //à lista de voluntários
    public void addVoluntario(LogVoluntario vol){
        this.voluntarios.put(vol.getUsername(),vol.clone());
    }

    //à lista de lojas
    public void addLoja(LogLoja loj){
        this.lojas.put(loj.getUsername(),loj.clone());
    }


    //metodo que verifica se um determinado user existe
    //utilizadores
    public boolean ExisteUtilizador(String user){
        return utilizadores.containsKey(user);
    }

    //transportadoras
    public boolean ExisteTransportadora(String user){
        return transportadoras.containsKey(user);
    }

    //voluntarios
    public boolean ExisteVoluntario(String user){
        return voluntarios.containsKey(user);
    }

    //lojas
    public boolean ExisteLoja(String user){
        return lojas.containsKey(user);
    }

    //método que verifica se um determinado código existe
    //utilizador
    public boolean ExisteCodUser(String cod){
        for(LogUtilizador lu: this.utilizadores.values()){
            if(lu.getCodUtilizador().equals(cod)){
                return true;
            }
        }
        return false;
    }

    //transportadora
    public boolean ExisteCodTrans(String cod){
        for(LogTransportadora lt: this.transportadoras.values()){
            if(lt.getCodEmpresa().equals(cod))
                return true;
        }
        return false;
    }

    //voluntarios
    public boolean ExisteCodVoluntario(String cod){
        for(LogVoluntario lv: this.voluntarios.values()){
            if(lv.getCodVoluntario().equals(cod))
                return true;
        }
        return false;
    }

    //lojas
    public boolean ExisteCodLoja(String cod){
        for(LogTransportadora lt: this.transportadoras.values()){
            return true;
        }
        return false;
    }

    //encomendas
    public boolean ExisteEncomenda(String cod){
        return this.encomendas.containsKey(cod);
    }


    //método que verifica

    //metodo que verifica a correspondência do username e da password introduzidos
    //pelo utilizador
    public String checkUserPassUtil(String user, String pass){
        for(LogUtilizador lu : this.utilizadores.values()){
            if(lu.getUsername().equals(user)){
                if(lu.getPassword().equals(pass)) return lu.getUsername();
            }
        }
        return "NOK";
    }

    //pela transportadora
    public String checkUSerPassTrans(String user, String pass){
        for(LogTransportadora lt: this.transportadoras.values()){
            if(lt.getUsername().equals(user)){
                if(lt.getPassword().equals(pass)) return lt.getUsername();
            }
        }
        return "NOK";
    }

    //pelos voluntários
    public String checkUserPassVol(String user, String pass){
        for(LogVoluntario lv: this.voluntarios.values()){
            if(lv.getUsername().equals(user)){
                if(lv.getPassword().equals(pass)) return lv.getUsername();
            }
        }
        return "NOK";
    }

    //pelas lojas
    public String checkUserPassLoj(String user, String pass){
        for(LogLoja loj: this.lojas.values()){
            if(loj.getUsername().equals(user)){
                if(loj.getPassword().equals(pass)) return loj.getUsername();
            }
        }
        return "NOK";
    }

    //verifica se um username
    // já se encontra registado na base de dados

    public boolean userEmUso(String user){
        for(LogUtilizador lu: this.getUtilizadores().values()){
            if(lu.getUsername().equals(user)) return true;
        }

        for(LogTransportadora lt: this.getTrasnportadoras().values()){
            if(lt.getUsername().equals(user)) return true;
        }

        for(LogVoluntario lv: this.getVoluntarios().values()){
            if(lv.getUsername().equals(user)) return true;
        }

        for(LogLoja loj: this.getLojas().values()){
            if (loj.getUsername().equals(user)) return true;
        }
        return false;
    }

    //regista um novo user na base de dados
    //utilizador
    public void novoUtilizador(String nome, Localizacao pos, String user, String pass) throws UsernameJaEstaEmUsoException, UtilizadorExisteException{
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");
        String cod=novoCodUtilizador();
        LogUtilizador u=new LogUtilizador();
        u.setCodUtilizador(cod);
        u.setNome(nome);
        u.setGps(pos);
        u.setUsername(user);
        u.setPassword(pass);
        if(ExisteUtilizador(user))
            throw new UtilizadorExisteException("Já existe registo com este username");
        this.utilizadores.put(u.getUsername(), u.clone());
    }

    //transportadoras
    public void novaTransportadora(String nome, Localizacao gps, String nif, double raio, double precokm, String user, String password) throws UsernameJaEstaEmUsoException, TransportadoraExisteException{
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");

        String cod=novoCodTransportadora();
        LogTransportadora t=new LogTransportadora();
        t.setCodEmpresa(cod);
        t.setNome(nome);
        t.setGps(gps);
        t.setNif(nif);
        t.setRaio(raio);
        t.setPrecokm(precokm);
        t.setUsername(user);
        t.setPassword(password);
        t.setClassificacoes(new ArrayList<>());
        if(ExisteTransportadora(user))
            throw new TransportadoraExisteException("Já existe registo com este username");
        this.transportadoras.put(t.getUsername(),t.clone());
    }

    //

    //voluntarios
    public void novoVoluntario(String nome, Localizacao gps, double raio, String user, String pass, boolean tf) throws UsernameJaEstaEmUsoException, VoluntarioExisteException {
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        String cod=novoCodVoluntario();
        LogVoluntario v= new LogVoluntario();
        v.setCodVoluntario(cod);
        v.setNome(nome);
        v.setGps(gps);
        v.setRaio(raio);
        v.setUsername(user);
        v.setPassword(pass);
        v.setDisponibilidade(tf);
        v.setClassificacoes(new ArrayList<>());

        if(ExisteVoluntario(user))
            throw new VoluntarioExisteException("Já existe um registo com este username");
        this.voluntarios.put(v.getUsername(),v.clone());
    }

    //lojas
    public void novaLoja(String nome, Localizacao gps, String user, String pass) throws UsernameJaEstaEmUsoException, LojaExisteException{
        if (userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        String cod=novoCodLoja();
        LogLoja l= new LogLoja();
        l.setCodLoja(cod);
        l.setNome(nome);
        l.setGps(gps);
        l.setUsername(user);
        l.setPassword(pass);
        if(ExisteLoja(user))
            throw new LojaExisteException("Já existe um registo com este username");
        this.lojas.put(l.getUsername(),l.clone());
    }

    //encomenda
    public void novaEncomenda(String codUtilizador, String codLoja, double peso, ArrayList<LinhaEncomenda> linhas){
        String cod=novoCodEncomenda();
        Encomenda e= new Encomenda();
        e.setCodEncomenda(cod);
        e.setCodUtilizador(codUtilizador);
        e.setCodEncomenda(codLoja);
        e.setPeso(peso);
        e.setLinhas(linhas);
        this.encomendas.put(e.getcodEncomenda(),e.clone());
    }
    /**
     * ASSOCIAR CONTA CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */

    public void associaLoja(String cod, String nome, Localizacao gps, String user, String pass, CatalogoProdutos cp) throws LojaExisteException,UsernameJaEstaEmUsoException {
        if (userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        LogLoja l = new LogLoja();
        l.setCodLoja(cod);
        l.setNome(nome);
        l.setGps(gps);
        l.setUsername(user);
        l.setPassword(pass);
        l.setCatalogoProdutos(cp);
        if (ExisteLoja(user)) throw new LojaExisteException("Já existe um registo para esse username");
        this.lojas.put(l.getUsername(), l.clone());
    }

    public void associaVoluntario(String cod,String nome, Localizacao gps, double raio, String user, String pass, boolean tf) throws VoluntarioExisteException,UsernameJaEstaEmUsoException {
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        LogVoluntario v= new LogVoluntario();
        v.setCodVoluntario(cod);
        v.setNome(nome);
        v.setGps(gps);
        v.setRaio(raio);
        v.setUsername(user);
        v.setPassword(pass);
        v.setDisponibilidade(tf);
        v.setClassificacoes(new ArrayList<>());
        if(ExisteVoluntario(user)) throw new VoluntarioExisteException("Já existe um registo para esse username");
        this.voluntarios.put(v.getUsername(),v.clone());
    }

    public void associaUtilizador(String cod,String nome, Localizacao pos, String username, String pass) throws UtilizadorExisteException,UsernameJaEstaEmUsoException{
        if(userEmUso(username))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");

        LogUtilizador u=new LogUtilizador();
        u.setCodUtilizador(cod);
        u.setNome(nome);
        u.setGps(pos);
        u.setUsername(username);
        u.setPassword(pass);
        if(ExisteUtilizador(username)) throw new UtilizadorExisteException("Já existe um registo para esse username");
        this.utilizadores.put(u.getUsername(), u.clone());
    }

    //transportadoras
    public void associaTransportadora(String cod,String nome, Localizacao gps, String nif, double raio, double precokm, String user, String password) throws TransportadoraExisteException,UsernameJaEstaEmUsoException{
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");

        LogTransportadora t=new LogTransportadora();
        t.setCodEmpresa(cod);
        t.setNome(nome);
        t.setGps(gps);
        t.setNif(nif);
        t.setRaio(raio);
        t.setPrecokm(precokm);
        t.setUsername(user);
        t.setPassword(password);
        t.setClassificacoes(new ArrayList<>());
        if(ExisteTransportadora(user)) throw new TransportadoraExisteException("Já existe um registo para esse username");
        this.transportadoras.put(t.getUsername(),t.clone());
    }

    //método que cria um novo código para
    //utilizador
    public String novoCodUtilizador(){
        int count=0;
        String cod;
        for(LogUtilizador lu: this.utilizadores.values()){
            cod=lu.getCodUtilizador().substring(1);
            if (Integer.parseInt(cod)>count) count=Integer.parseInt(cod);
        }
        Random rand= new Random();
        String confirma="u"+count;
        while(ExisteCodUser(confirma)){
            confirma="u"+ rand.nextInt(count + 2);
        }

        return confirma;
    }

    //transportadora
    public String novoCodTransportadora(){
        int count=0;
        String cod;
        for(LogTransportadora lt: this.transportadoras.values()){
            cod=lt.getCodEmpresa().substring(1);
            if(Integer.parseInt(cod)>count) count=Integer.parseInt(cod);
        }
        Random rand=new Random();
        String confirma="t"+count;
        while(ExisteCodTrans(confirma)){
            confirma="t"+rand.nextInt(count+2);
        }
        return confirma;
    }

    //voluntário
    public String novoCodVoluntario(){
        int count=0;
        String cod;
        for(LogVoluntario lt: this.voluntarios.values()){
            cod=lt.getCodVoluntario().substring(1);
            if(Integer.parseInt(cod)>count) count=Integer.parseInt(cod);
        }
        Random rand=new Random();
        String confirma="v"+count;
        while(ExisteCodTrans(confirma)){
            confirma="v"+rand.nextInt(count+2);
        }
        return confirma;
    }

    //encomenda
    public String novoCodEncomenda(){
        int count=0;
        String cod;
        for(Encomenda e: this.encomendas.values()){
            cod=e.getcodEncomenda().substring(1);
            if(Integer.parseInt(cod)>count) count=Integer.parseInt(cod);
        }
        Random rand=new Random();
        String confirma="e"+count;
        while(ExisteEncomenda(confirma)){
            confirma="e"+rand.nextInt(count+2);
        }
        return confirma;
    }

    //loja
    public String novoCodLoja(){
        int count=0;
        String cod;
        for(LogLoja lt: this.lojas.values()){
            cod=lt.getCodLoja().substring(1);
            if(Integer.parseInt(cod)>count) count=Integer.parseInt(cod);
        }
        Random rand=new Random();
        String confirma="l"+count;
        while(ExisteCodLoja(confirma)){
            confirma="l"+rand.nextInt(count+2);
        }
        return confirma;
    }

    //mudar a localização
    //de um utilizador
    public void setLocalizacaoUtilizador(String cod, double x, double y){
        Localizacao loc=new Localizacao(x,y);
        for(LogUtilizador lu : this.utilizadores.values()){
            if(lu.getCodUtilizador().equals(cod)){
                lu.setGps(loc);
            }
        }
    }

    //de uma transportadora
    public void setLocalizacaotransportadora(String cod,double x, double y){
        Localizacao loc=new Localizacao(x,y);
        for(LogTransportadora lt: this.transportadoras.values()){
            if(lt.getCodEmpresa().equals(cod)){
                lt.setGps(loc);
            }
        }
    }

    //de um voluntário
    public void setLocalizacaovoluntario(String cod, double x, double y){
        Localizacao loc=new Localizacao(x,y);
        for(LogVoluntario lv: this.voluntarios.values()){
            if(lv.getCodVoluntario().equals(cod)){
                lv.setGps(loc);
            }
        }
    }

    //de uma Loja
    public void setLocalizacaoloja(String cod, double x,double y){
        Localizacao loc = new Localizacao(x,y);
        for(LogLoja lg : this.lojas.values()){
            if(lg.getCodLoja().equals(cod)){
                lg.setGps(loc);
            }
        }
    }

    //metodo que verifica em que lojas é que um determinado produto existe
    public Set<String> produtoExisteGlobal(String descricao) throws ProdutoNaoExisteException{
        Set<String> nomes=new TreeSet<>();
        for(LogLoja x : this.lojas.values()){
            for(Produto p : x.getCatalogoProdutos().getProdutos()){
                if(p.getDescricao().equals(descricao)){
                    nomes.add(x.getNome());
                }
            }
        }
        if (nomes.isEmpty()) throw new ProdutoNaoExisteException("O produto não existe!");

        return nomes;
    }

    //metodo que verifica se um deteminado produto existe
    public boolean produtoExiste(String user, String CodProd){
        LogLoja log=this.lojas.get(user);
        List<Produto> p=log.getCatalogoProdutos().getProdutos();
        for (Produto pr: p){
            if (pr.getCodProd().equals(CodProd))
                return true;
        }
        return false;
    }

    //método que adiciona um novo produto ou atualiza o stock de uma determinada loja
    public void addProduto(String user, Produto novo) throws LojaNaoExisteException {
        if (!ExisteLoja(user))
            throw new LojaNaoExisteException("A Loja não existe");
        LogLoja l = this.lojas.get(user);
        ArrayList<Produto> p = l.getCatalogoProdutos().getProdutos();
        if (produtoExiste(user, novo.getCodProd())) {
            for (Produto pr : p) {
                if (pr.getCodProd().equals(novo.getCodProd())) {
                    pr.setStock(pr.getStock()+novo.getStock());
                }
            }
        } else {
            p.add(novo);
            CatalogoProdutos c= new CatalogoProdutos(l.getCodLoja(),p);
            l.setCatalogoProdutos(c);
        }
    }

    //método que remove um produto de uma determinada loja
    public void removeProduto(String user, Produto x) throws LojaNaoExisteException, ProdutoNaoExisteException{
        if(!ExisteLoja(user))
            throw new LojaNaoExisteException("Loja não existe!");
        if(!produtoExiste(user,x.getCodProd()))
            throw  new ProdutoNaoExisteException("Produto não existe!");
        LogLoja log=this.lojas.get(user);
        ArrayList<Produto> p=log.getCatalogoProdutos().getProdutos();
        p.removeIf(pr -> pr.equals(x));
        CatalogoProdutos c= new CatalogoProdutos(log.getCodLoja(),p);
        log.setCatalogoProdutos(c);
    }

    //método que reduz o stock de um produto de uma loja
    public void reduzStock(String user, String codprod, double stock) throws LojaNaoExisteException, ProdutoNaoExisteException{
        if(!ExisteLoja(user))
            throw new LojaNaoExisteException("Loja não existe!");
        if(!produtoExiste(user, codprod))
            throw new ProdutoNaoExisteException("Produto não existe!");

        LogLoja log=this.lojas.get(user);
        List<Produto> pr=log.getCatalogoProdutos().getProdutos();
        for(Produto p: pr){
            if(p.getCodProd().equals(codprod)){
                p.setStock(p.getStock()-stock);
            }
        }
    }

    //método que adicona uma classificação
    //a uma transportadora
    public void classifTrans(String user, Classificacao classif) throws TransportadoraNaoExisteException{
        if(!ExisteTransportadora(user))
            throw new TransportadoraNaoExisteException("A empresa transportadora não existe!");
        List<Classificacao> cl= this.transportadoras.get(user).getClassificacoes();
        cl.add(classif);
    }

    //a um voluntario
    public void classifVol(String user, Classificacao classif) throws VoluntarioNaoExisteException{
        if(!ExisteVoluntario(user))
            throw new VoluntarioNaoExisteException("O voluntário não existe!");
        List<Classificacao> cl= this.voluntarios.get(user).getClassificacoes();
        cl.add(classif);
    }

    //método que determina a classificacao média
    //das transportadoras
    public double classifMediaTrans(String user) throws TransportadoraNaoExisteException{
        if(!ExisteTransportadora(user))
            throw new TransportadoraNaoExisteException("A empresa transportadora não existe!");
        List<Classificacao> cl =this.transportadoras.get(user).getClassificacoes();
        double count=0;
        for(Classificacao c: cl){
            count+=c.getClassificacao();
        }

        return count/cl.size();
    }

    //dos voluntarios
    public double classifMediaVol(String user) throws VoluntarioNaoExisteException{
        if(!ExisteVoluntario(user))
            throw new VoluntarioNaoExisteException("O voluntario não existe!");
        List<Classificacao> cl=this.voluntarios.get(user).getClassificacoes();
        double count=0;
        for(Classificacao c: cl){
            count+=c.getClassificacao();
        }
        return count/cl.size();
    }

    //método para uma loja poder alterar o preço de um produto
    public void mudaPreco(String user,String cod, double preco) throws LojaNaoExisteException{
        if(!ExisteLoja(user)){
            throw new LojaNaoExisteException("Loja não existe");
        }
        LogLoja l=this.lojas.get(user);
        for(Produto p:l.getCatalogoProdutos().getProdutos()){
            if(p.getCodProd().equals(cod)){
                p.setPreco(preco);
            }
        }
    }

    //método para obter a localizacao
    //utilizador
    public Localizacao getLocalizacaoUtilizador(String username){
        Localizacao b = new Localizacao();
        for(LogUtilizador c : this.getUtilizadores().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    //Loja
    public Localizacao getLocalizacaoLoja(String username){
        Localizacao b = new Localizacao();
        for(LogLoja c : this.getLojas().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    //Transportadora
    public Localizacao getLocalizacaoTransportadora(String username){
        Localizacao b = new Localizacao();
        for(LogTransportadora c : this.getTrasnportadoras().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    //Voluntário
    public Localizacao getLocalizacaoVoluntario(String username){
        Localizacao b = new Localizacao();
        for(LogVoluntario c : this.getVoluntarios().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    //Método que ordena as lojas por ordem alfabética
    public Set<String> lojasOrdemAlfabetica() throws NaoExisteLojasRegistadasException{
        if(this.getLojas().isEmpty()){
            throw new NaoExisteLojasRegistadasException("Nao existem lojas registadas!");
        }
        Set<String> s = new TreeSet<>();
        for(LogLoja a : this.getLojas().values()){
            s.add(a.getNome());
        }
        return s;
    }
}
