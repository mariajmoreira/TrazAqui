package trazaqui;

public class Transportadora {
    private String codEmpresa;
    private String nome;
    private Localizacao gps;
    private String nif;
    private double raio;
    private double precokm;


    //getters
    public String getCodEmpresa(){return codEmpresa;}

    public String getNome(){return nome;}

    public Localizacao getGps(){return new Localizacao(this.gps.getX(),this.gps.getY());}

    public String getNif(){return nif;}

    public double getRaio(){return raio; }

    public double getPrecokm(){return precokm;}

    //setters
    public void setCodEmpresa(String ce){this.codEmpresa=ce;}

    public void setNome(String nome){this.nome=nome;}

    public void setGps(Localizacao pos){this.gps=new Localizacao(pos);}

    public void setNif(String nif){this.nif=nif;}

    public void setRaio(double raio){this.raio=raio;}

    public void setPrecokm(double pk){this.precokm=pk;}

    //construtor vazio
    public Transportadora(){
        this.codEmpresa="";
        this.nome="";
        this.gps=new Localizacao();
        this.nif="";
        this.raio=0;
        this.precokm=0;
    }

    //construtor parametrizado
    public Transportadora(String cod, String nome, Localizacao pos, String nif, double raio, double pk){
        this.codEmpresa=cod;
        this.nome=nome;
        setGps(pos);
        this.nif=nif;
        this.raio=raio;
        this.precokm=pk;
    }

    //construtor por cópia
    public Transportadora(Transportadora t){
        this.codEmpresa=t.getCodEmpresa();
        this.nome=t.getNome();
        setGps(t.getGps());
        this.nif=t.getNif();
        this.raio=t.getRaio();
        this.precokm=t.getPrecokm();
    }

    //metodo toString
    public String toString(){
        StringBuilder sb=new StringBuilder();
        sb.append("Trasnportador:\n").append("Codigo da Empresa:").append(this.codEmpresa)
                .append("\n").append("Nome:").append(this.nome)
                .append("\n").append("Gps:").append(this.gps)
                .append("\n").append("Raio").append(this.raio)
                .append("\n").append("Preço por Km:").append(this.precokm).append("\n");
        return sb.toString();
    }
}
