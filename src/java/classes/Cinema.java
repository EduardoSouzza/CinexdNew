package classes;

public class Cinema {

    private int id;
    private String nome;
    private String endereco;
    private Cidade cidade;
    private Estado estado;
    private int idEstado;
    private int idCidade;
    private boolean XD;
    private boolean PRIME;
    private boolean VIP;
    private boolean DBOX;
    private boolean D3D;
    
    public Cinema(int id, String nome, String endereco, Cidade cidade, Estado estado, int idEstado, int idCidade, boolean XD, boolean PRIME, boolean VIP, boolean DBOX, boolean D3D) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
        this.idEstado = idEstado;
        this.idCidade = idCidade;
        this.XD = XD;
        this.PRIME = PRIME;
        this.VIP = VIP;
        this.DBOX = DBOX;
        this.D3D = D3D;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdEstado() {
        return idEstado;
    }

    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public boolean isXD() {
        return XD;
    }

    public void setXD(boolean XD) {
        this.XD = XD;
    }

    public boolean isPRIME() {
        return PRIME;
    }

    public void setPRIME(boolean PRIME) {
        this.PRIME = PRIME;
    }

    public boolean isVIP() {
        return VIP;
    }

    public void setVIP(boolean VIP) {
        this.VIP = VIP;
    }

    public boolean isDBOX() {
        return DBOX;
    }

    public void setDBOX(boolean DBOX) {
        this.DBOX = DBOX;
    }

    public boolean isD3D() {
        return D3D;
    }

    public void setD3D(boolean D3D) {
        this.D3D = D3D;
    }

}

