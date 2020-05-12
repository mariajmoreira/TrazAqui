package trazaqui;

import trazaqui.Exceptions.*;

import java.io.Serializable;
import java.util.*;

public class BaseDados implements Serializable {
    private Map <String,LogUtilizador> utilizadores;
    private Map <String,LogTransportadora> transportadoras;
    private Map <String,LogVoluntario> voluntarios;
    private Map <String,LogLoja> lojas;

    //getters
    public Map<String,LogUtilizador> getUtilizadores(){return new HashMap<>(this.utilizadores);}

    public Map<String,LogTransportadora> getTrasnportadoras(){return new HashMap<>(this.transportadoras);}

    public Map<String, LogVoluntario> getVoluntarios(){return new HashMap<>(this.voluntarios);}

    public Map<String, LogLoja> getLojas(){return new HashMap<>(this.lojas);}

    //setters
    public void setUtilizadores(Map<String,LogUtilizador> user){this.utilizadores=new HashMap<>(user);}

    public void setTransportadoras(Map<String,LogTransportadora> trans){this.transportadoras=new HashMap<>(trans);}

    public void setVoluntarios(Map<String,LogVoluntario> vol){this.voluntarios=new HashMap<>(vol);}

    public void setLojas(Map<String,LogLoja> loj){this.lojas=new HashMap<>(loj);}

    //clone
    public BaseDados clone(){return new BaseDados(this);}

    //construtor vazio
    public BaseDados(){
        this.utilizadores=new HashMap<>();
        this.transportadoras=new HashMap<>();
        this.voluntarios=new HashMap<>();
        this.lojas=new HashMap<>();
    }

    //construtor parametrizado
    public BaseDados(Map<String,LogUtilizador> user,Map<String,LogTransportadora> trans, Map<String,LogVoluntario> vol, Map<String,LogLoja> loj){
        setUtilizadores(user);
        setTransportadoras(trans);
        setVoluntarios(vol);
        setLojas(loj);
    }

    //construtor por copia
    public BaseDados(BaseDados bd){
        setUtilizadores(bd.getUtilizadores());
        setTransportadoras(bd.getTrasnportadoras());
        setVoluntarios(bd.getVoluntarios());
        setLojas(bd.getLojas());
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
    public void novoUtilizador(String nome, Localizacao pos, String user, String pass) throws UsernameJaEstaEmUsoException{
        if(userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");
        String cod=novoCodUtilizador();
        LogUtilizador u=new LogUtilizador();
        u.setCodUtilizador(cod);
        u.setNome(nome);
        u.setGps(pos);
        u.setUsername(user);
        u.setPassword(pass);

        this.utilizadores.put(u.getUsername(), u.clone());
    }

    //transportadoras
    public void novaTransportadora(String nome, Localizacao gps, String nif, double raio, double precokm, String user, String password) throws UsernameJaEstaEmUsoException{
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

        this.transportadoras.put(t.getUsername(),t.clone());
    }

    //voluntarios
    public void novoVoluntario(String nome, Localizacao gps, double raio, String user, String pass, boolean tf) throws UsernameJaEstaEmUsoException {
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

        this.voluntarios.put(v.getUsername(),v.clone());
    }

    //lojas
    public void novaLoja(String nome, Localizacao gps, String user, String pass) throws UsernameJaEstaEmUsoException{
        if (userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        String cod=novoCodLoja();
        LogLoja l= new LogLoja();
        l.setCodLoja(cod);
        l.setNome(nome);
        l.setGps(gps);
        l.setUsername(user);
        l.setPassword(pass);

        this.lojas.put(l.getUsername(),l.clone());
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
        while(ExisteUtilizador(confirma)){
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
        String confirma="u"+count;
        while(ExisteTransportadora(confirma)){
            confirma="u"+rand.nextInt(count+2);
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
        String confirma="u"+count;
        while(ExisteTransportadora(confirma)){
            confirma="u"+rand.nextInt(count+2);
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
        String confirma="u"+count;
        while(ExisteTransportadora(confirma)){
            confirma="u"+rand.nextInt(count+2);
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
            for(Produto p : x.getProdutos()){
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
        List<Produto> p=log.getProdutos();
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
        ArrayList<Produto> p = l.getProdutos();
        if (produtoExiste(user, novo.getCodProd())) {
            for (Produto pr : p) {
                if (pr.getCodProd().equals(novo.getCodProd())) {
                    pr.setStock(pr.getStock()+novo.getStock());
                }
            }
        } else {
            p.add(novo);
            l.setProdutos(p);
        }
    }

    //método que remove um produto de uma determinada loja
    public void removeProduto(String user, Produto x) throws LojaNaoExisteException, ProdutoNaoExisteException{
        if(!ExisteLoja(user))
            throw new LojaNaoExisteException("Loja não existe!");
        if(!produtoExiste(user,x.getCodProd()))
            throw  new ProdutoNaoExisteException("Produto não existe!");
        LogLoja log=this.lojas.get(user);
        List<Produto> p=log.getProdutos();
        p.removeIf(pr -> pr.equals(x));
    }

    //método que reduz o stock de um produto de uma loja
    public void reduzStock(String user, String codprod, int stock) throws LojaNaoExisteException, ProdutoNaoExisteException{
        if(!ExisteLoja(user))
            throw new LojaNaoExisteException("Loja não existe!");
        if(!produtoExiste(user, codprod))
            throw new ProdutoNaoExisteException("Produto não existe!");

        LogLoja log=this.lojas.get(user);
        List<Produto> pr=log.getProdutos();
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
}
