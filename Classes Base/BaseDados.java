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

    public BaseDados(Armazena armazena){

    }

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
    public boolean ExisteUtilizador(String username){
        return utilizadores.containsKey(username);
    }

    //transportadoras
    public boolean ExisteTransportadora(String username){
        return transportadoras.containsKey(username);
    }

    //voluntarios
    public boolean ExisteVoluntario(String username){
        return voluntarios.containsKey(username);
    }

    //lojas
    public boolean ExisteLoja(String username){
        return lojas.containsKey(username);
    }

    //metodo que verifica se um determinado produto existe
    public boolean produtoExiste(String codProd){
        for(LogLoja x : this.lojas.values()){
            for(Produto p : x.getCatalogoProdutos().getProdutos()){
                if(p.getCodProd().equals(codProd)) return true;
            }
        }
        return false;
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
    public void novoUtilizador(String nome, Localizacao pos, String username, String pass) throws UtilizadorExisteException,UsernameJaEstaEmUsoException{
        if(userEmUso(username))
            throw new UsernameJaEstaEmUsoException("Ja existe um registo com este username");
        String cod=novoCodUtilizador();
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
    public void novaTransportadora(String nome, Localizacao gps, String nif, double raio, double precokm, String user, String password) throws TransportadoraExisteException,UsernameJaEstaEmUsoException{
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
        if(ExisteTransportadora(user)) throw new TransportadoraExisteException("Já existe um registo para esse username");
        this.transportadoras.put(t.getUsername(),t.clone());
    }

    //voluntarios
    public void novoVoluntario(String nome, Localizacao gps, double raio, String user, String pass, boolean tf) throws VoluntarioExisteException,UsernameJaEstaEmUsoException {
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
        if(ExisteVoluntario(user)) throw new VoluntarioExisteException("Já existe um registo para esse username");
        this.voluntarios.put(v.getUsername(),v.clone());
    }

    //lojas
    public void novaLoja(String nome, Localizacao gps, String user, String pass) throws LojaExisteException,UsernameJaEstaEmUsoException{
        if (userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        String cod=novoCodLoja();
        LogLoja l= new LogLoja();
        l.setCodLoja(cod);
        l.setNome(nome);
        l.setGps(gps);
        l.setUsername(user);
        l.setPassword(pass);
        if(ExisteLoja(user)) throw new LojaExisteException("Já existe um registo para esse username");
        this.lojas.put(l.getUsername(),l.clone());
    }

    public void novaLoja(LogLoja l) throws LojaExisteException, CodigoJaEstaEmUsoException{
        if(userEmUso(l.getUsername()))
            throw new CodigoJaEstaEmUsoException("Ja existe um registo com este código");
        LogLoja p = new LogLoja();
        p.setCodLoja(l.getCodLoja());
        p.setNome(l.getNome());
        p.setGps(l.getGps());
        p.setUsername(l.getUsername());
        p.setPassword(l.getPassword());
        p.setCatalogoProdutos(l.getCatalogoProdutos());
        this.lojas.put(p.getCodLoja(),p.clone());
    }
    /**
     * ASSOCIAR CONTA CLIENTE, LOJA, TRANSPORTADORA, VOLUNTARIO
     */

    public void associaLoja(String cod, String nome, Localizacao gps, String user, String pass) throws LojaExisteException,UsernameJaEstaEmUsoException {
        if (userEmUso(user))
            throw new UsernameJaEstaEmUsoException("Já existe um registo com este username");

        LogLoja l = new LogLoja();
        l.setCodLoja(cod);
        l.setNome(nome);
        l.setGps(gps);
        l.setUsername(user);
        l.setPassword(pass);
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

    public Localizacao getLocalizacaoUtilizador(String username){
        Localizacao b = new Localizacao();
        for(LogUtilizador c : this.getUtilizadores().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    public Localizacao getLocalizacaoLoja(String username){
        Localizacao b = new Localizacao();
        for(LogLoja c : this.getLojas().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    public Localizacao getLocalizacaoTransportadora(String username){
        Localizacao b = new Localizacao();
        for(LogTransportadora c : this.getTrasnportadoras().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    public Localizacao getLocalizacaoVoluntario(String username){
        Localizacao b = new Localizacao();
        for(LogVoluntario c : this.getVoluntarios().values()){
            if(c.getUsername().equals(username))
                b =  c.getGps();
        }
        return b;
    }

    public LogUtilizador getUtilizador(String username){
        for(LogUtilizador c : this.utilizadores.values()){
            if(c.getCodUtilizador().equals(username))
                return c;        }
        return null;
    }

    public LogLoja getLoja(String username){
        for(LogLoja c : this.lojas.values()){
            if(c.getCodLoja().equals(username))
                return c;        }
        return null;
    }

    public LogTransportadora getTransportadora(String username){
        for(LogTransportadora c : this.transportadoras.values()){
            if(c.getCodEmpresa().equals(username))
                return c;        }
        return null;
    }

    public LogVoluntario getVoluntario(String username){
        for(LogVoluntario c : this.voluntarios.values()){
            if(c.getCodVoluntario().equals(username))
                return c;        }
        return null;
    }

    public Set<String> lojasOrdemAlfabetica(){
        Set<String> s = new TreeSet<>();
        for(LogLoja a : this.getLojas().values()){
            s.add(a.getNome());
        }
        return s;
    }


}
