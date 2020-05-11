package trazAqui;

import trazAqui.Exceptions.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Armazena implements Serializable {
    private Map<String,Utilizador> utilizadores;
    private Map <String,Loja> lojas;
    private Map <String,Transportadora> transportadoras;
    private Map <String,Voluntario> voluntarios;


    /**
     * Construtor vazio
     */
    public Armazena(){
        this.utilizadores = new HashMap<>();
        this.lojas = new HashMap<>();
        this.transportadoras = new HashMap<>();
        this.voluntarios = new HashMap<>();
    }

    /**
     * Metodo construtor parameterizado
     */
    public Armazena( Map<String,Utilizador> u, Map<String,Loja> l, Map<String,Transportadora> t, Map<String,Voluntario> v){
        setUtilizadores(u);
        setLojas(l);
        setTransportadoras(t);
        setVoluntarios(v);
    }

    /**
     * Metodo construtor por copia
     * @param list Objeto da classe BaseDados
     */
    public Armazena(Armazena list){
        setUtilizadores(list.getUtilizadores());
        setLojas(list.getLojas());
        setTransportadoras(list.getTransportadoras());
        setVoluntarios(list.getVoluntarios());
    }

    /**
     * Retorna um cliente especifico com base no seu Username
     * @param cod O username do cliente
     * @return Um utilizador
     */
    public Utilizador getUtilizador(String cod){
        for(Utilizador c : this.utilizadores.values()){
            if(c.getCodUtilizador().equals(cod))
                return c;        }
        return null;
    }

    /**
     * Metodo para obter os utilizadores
     * @return Lista dos utilizadores
     */
    public Map<String,Utilizador> getUtilizadores(){
        Map<String,Utilizador> ret = new HashMap<>();
        for(Utilizador p : this.utilizadores.values()){
            ret.put(p.getCodUtilizador(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter as lojas
     * @return Lista das lojas
     */
    public Map<String,Loja> getLojas(){
        Map<String,Loja> ret = new HashMap<>();
        for(Loja p : this.lojas.values()){
            ret.put(p.getCodLoja(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter as transportadoras
     * @return Lista das transportadoras
     */
    public Map<String,Transportadora> getTransportadoras(){
        Map<String,Transportadora> ret = new HashMap<>();
        for(Transportadora p : this.transportadoras.values()){
            ret.put(p.getCodEmpresa(),p.clone());
        }
        return ret;
    }

    /**
     * Metodo para obter os voluntarios
     * @return Lista dos voluntarios
     */
    public Map<String,Voluntario> getVoluntarios(){
        Map<String,Voluntario> ret = new HashMap<>();
        for(Voluntario p : this.voluntarios.values()){
            ret.put(p.getCodVoluntario(),p.clone());
        }
        return ret;
    }

    /**
     * Adicionar um utilizador a lista de utilizadores
     * @param u um utilizador
     *
     */
    public void addUtilizador(Utilizador u){
        this.utilizadores.put(u.getCodUtilizador(),u.clone());
    }

    /**
     * Adicionar uma loja a lista de lojas
     * @param l uma loja
     *
     */
    public void addLoja(Loja l){
        this.lojas.put(l.getCodLoja(),l.clone());
    }

    /**
     * Adicionar um transportadora a lista de transportadoras
     * @param t uma transportadora
     *
     */
    public void addTransportadora(Transportadora t){
        this.transportadoras.put(t.getCodEmpresa(),t.clone());
    }

    /**
     * Adicionar um voluntario a lista de voluntarios
     * @param v um voluntario
     *
     */
    public void addVoluntario(Voluntario v){
        this.voluntarios.put(v.getCodVoluntario(),v.clone());
    }

    /**
     * Metodo para definir os utilizadores
     * @param u Lista de utilizadores
     */
    public void setUtilizadores(Map<String,Utilizador> u){
        this.utilizadores = new HashMap<>();
        for(Utilizador  p : u.values()){
            this.utilizadores.put(p.getCodUtilizador(),p.clone());
        }
    }

    /**
     * Metodo para definir as lojas
     * @param l Lista de lojas
     */
    public void setLojas(Map<String,Loja> l){
        this.lojas = new HashMap<>();
        for(Loja  p : l.values()){
            this.lojas.put(p.getCodLoja(),p.clone());
        }
    }

    /**
     * Metodo para definir as transportadoras
     * @param t Lista de transportadoras
     */
    public void setTransportadoras(Map<String,Transportadora> t){
        this.transportadoras = new HashMap<>();
        for(Transportadora p : t.values()){
            this.transportadoras.put(p.getCodEmpresa(),p.clone());
        }
    }

    /**
     * Metodo para definir os voluntarios
     * @param v Lista de voluntarios
     */
    public void setVoluntarios(Map<String,Voluntario> v){
        this.voluntarios = new HashMap<>();
        for(Voluntario  p : v.values()){
            this.voluntarios.put(p.getCodVoluntario(),p.clone());
        }
    }


    /**
     * Clonar um objecto da classe BaseDados
     */
    public Armazena clone(){
        return new Armazena(this);
    }



    /**
     * Metodo equals
     * @param o Objeto de uma classe qualquer
     * @return Boolean
     */
    public boolean equals(Object o){
        if(this == o) return true;
        if((o == null) || (o.getClass() != this.getClass())) return false;

        Armazena util = (Armazena) o;

        for(Utilizador u : util.utilizadores.values())
            if(!this.utilizadores.containsValue(u))
                return false;

        for(Loja l : util.lojas.values())
            if(!this.lojas.containsValue(l))
                return false;

        for(Transportadora t : util.transportadoras.values())
            if(!this.transportadoras.containsValue(t))
                return false;

        for(Voluntario v : util.voluntarios.values())
            if(!this.voluntarios.containsValue(v))
                return false;

        return true;
    }

    /**
     * Regista um novo proprietário na base de dados
     */
    public void novoUtilizador(Utilizador u) throws UtilizadorExisteException, CodigoJaEstaEmUsoException{
        if(codEmUso(u.getCodUtilizador()))
        throw new CodigoJaEstaEmUsoException("Ja existe um registo com este codigo");
        Utilizador p = new Utilizador();
        p.setCodUtilizador(u.getCodUtilizador());
        p.setNome(u.getNome());
        p.setGps(u.getGps());
        this.utilizadores.put(p.getCodUtilizador(),p.clone());
    }

    /**
     * Regista um novo cliente na base de dados
     */
    public void novaLoja(Loja l) throws LojaExisteException, CodigoJaEstaEmUsoException{
        if(codEmUso(l.getCodLoja()))
        throw new CodigoJaEstaEmUsoException("Ja existe um registo com este código");
        Loja p = new Loja();
        p.setCodLoja(l.getCodLoja());
        p.setNome(l.getNome());
        p.setGps(l.getGps());
        this.lojas.put(p.getCodLoja(),p.clone());
    }


    public void novaTransportadora(Transportadora t) throws TransportadoraExisteException, CodigoJaEstaEmUsoException{
        if(this.codEmUso(t.getCodEmpresa()))
        throw new CodigoJaEstaEmUsoException("Ja existe um registo com este codigo");
        LogTransportadora p = new LogTransportadora();
        p.setCodEmpresa(t.getCodEmpresa());
        p.setNome(t.getNome());
        p.setGps(t.getGps());
        p.setNif(t.getNif());
        p.setRaio(t.getRaio());
        p.setPrecokm(t.getPrecokm());
        this.transportadoras.put(p.getCodEmpresa(),p.clone());
    }

    public void novoVoluntario(Voluntario v) throws VoluntarioExisteException, CodigoJaEstaEmUsoException{
        if(this.codEmUso(v.getCodVoluntario()))
        throw new CodigoJaEstaEmUsoException("Ja existe um registo com este codigo");
        LogVoluntario p = new LogVoluntario();
        p.setCodVoluntario(v.getCodVoluntario());
        p.setNome(v.getNome());
        p.setGps(v.getGps());

        this.voluntarios.put(p.getCodVoluntario(),p.clone());
    }

    public boolean codEmUso(String cod){
        for(Utilizador u : this.getUtilizadores().values())
            if(u.getCodUtilizador().equals(cod))
                return true;
        for(Loja l : this.getLojas().values())
            if(l.getCodLoja().equals(cod))
                return true;
        for(Transportadora t : this.getTransportadoras().values())
            if(t.getCodEmpresa().equals(cod))
                return true;
        for(Voluntario v : this.getVoluntarios().values())
            if(v.getCodVoluntario().equals(cod))
                return true;
        return false;
    }

}
