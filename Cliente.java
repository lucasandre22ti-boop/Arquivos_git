package loja_de_carros;

public class Cliente {
    private int id;
    private long cpf, telefone;
    private String nome, email;
    
   
    
    public Cliente(String nome, String email,long cpf,long telefone){
        this.nome = nome;
        this.email = email;
        this.cpf =cpf;
        this.telefone = telefone;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public void dados(){
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("Email: " + getEmail());
        System.out.println("cpf: " + getCpf());
        System.out.println("telefone: " + getTelefone()+"\n");
    }

   
    public long getCpf() {
        return cpf;
    }

  
    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

  
    public long getTelefone() {
        return telefone;
    }

    public void settelefone(long telefone) {
        this.telefone = telefone;
    }
}