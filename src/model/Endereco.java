package model;

public class Endereco {
    private int id;
    private TipoLogradouro tipoLogradouro;
    private String logradouro;
    private int numero;
    private String complemento;
    private String CEP;

    public Endereco(int id, TipoLogradouro tipoLogradouro, String logradouro, int numero, String complemento, String CEP) {
        this.id = id;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.CEP = CEP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    @Override
    public String toString() {
        return "id= " + id +
                ", TipoLogradouro= " + tipoLogradouro +
                ", Logradouro= " + logradouro +
                ", Numero= " + numero +
                ", Complemento= " + complemento +
                ", CEP= " + CEP;
    }
}
