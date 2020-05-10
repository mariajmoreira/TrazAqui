package trazAqui;

public class Produto {
    private String codProd;
    private String descricao;
    private double precoUnitario;
    private int stock;


    public Produto() {
        this.codProd = "n/a";
        this.descricao = "n/a";
        this.precoUnitario = 0.0;
        this.stock=0;
    }

    public Produto(String cod, String descricao, double preco, int qnt) {
        this.codProd = cod;
        this.descricao = descricao;
        this.precoUnitario = preco;
        this.stock=qnt;
    }

    public Produto(Produto linha) {
        this.codProd = linha.getCodProd();
        this.descricao = linha.getDescricao();
        this.precoUnitario = linha.getPreco();
        this.stock=linha.getStock();
    }

    public String getCodProd() {
        return this.codProd;
    }

    public void setCodProd(String cod) {
        this.codProd= cod;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.precoUnitario;
    }

    public void setPreco(double preco) {
        this.precoUnitario = preco;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int qnt) { this.stock = qnt;
    }

    public Produto clone() {
        return new Produto(this);
    }

    public boolean equals(Object obj) {
        if(obj==this) return true;
        if(obj==null || obj.getClass() != this.getClass()) return false;
        LinhaEncomenda le = (LinhaEncomenda) obj;
        return le.getCodProd().equals(this.codProd) &&
                le.getDescricao().equals(this.descricao) &&
                le.getPreco() == this.precoUnitario;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Encomendas:\n").append("Codigo Produto:").append(this.codProd).append("\n").append("Descriçao:")
                .append(this.descricao).append("\n").append("Preco:").append(this.precoUnitario)
                .append("\n");
        return sb.toString();
    }
}
