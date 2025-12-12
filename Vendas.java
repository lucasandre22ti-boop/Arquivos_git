
package loja_de_carros;

import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Vendas extends Relatorio {

    public Vendas(String forma_de_pagamento,String data_registro,int id_cliente, int id_carro, String nome_cliente, String nome_vendedor, long cpf, String marca, String modelo, double preco) {
        super(forma_de_pagamento,data_registro);
        this.id_cliente = id_cliente;
        this.id_carro = id_carro;
        this.nome_cliente = nome_cliente;
        this.nome_vendedor = nome_vendedor;
        this.cpf = cpf;
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
    }
    private int id_cliente;
    private int id_carro;
    private String nome_cliente;
    private String nome_vendedor;
    private long cpf;
    private String marca;
    private String modelo;
    private double preco;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_carro() {
        return id_carro;
    }

    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_vendedor() {
        return nome_vendedor;
    }

    public void setNome_vendedor(String nome_vendedor) {
        this.nome_vendedor = nome_vendedor;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
    public static double verificarCarro_Cliente(int id){
        String sql = "SELECT id,preco FROM carro WHERE id="+"'"+id+"'";

        ResultSet rs = Conexao.consultar(sql);
        
        if( rs != null){
            
            try{
                while (rs.next()) {                
                    int id_Carro=rs.getInt(1);
                    if(id_Carro==id){
                        return rs.getDouble(2);
                    }
                  
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
         return 0;
    }
       
    public static ArrayList<Vendas> getVendas(){
        ArrayList<Vendas> lista = new ArrayList<>();
        
        String sql = "SELECT * FROM vendas INNER JOIN clientes ON vendas.Id_Cliente = clientes.Id INNER JOIN carro ON vendas.Id_Carro = carro.Id;";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {        
                    System.out.println("Id: "+rs.getString(1));
                    System.out.println("Vendedor: "+rs.getString(2));
                    System.out.println("Data da Compra: "+rs.getString(3));
                    System.out.println("Forma de pagamento: "+rs.getString(4));
                    System.out.println("Cpf: "+rs.getLong(10));
                    System.out.println("Marca: "+rs.getString(13));
                    System.out.println("Modelo: "+rs.getString(14));
                    System.out.println("Preço: R$ "+rs.getDouble(15)+"\n");
                    
                    
                   
        
                    
                    
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
     
        return lista;
    }
    public void cadastrar(){
        String  sql =  "INSERT INTO vendas (Vendedor,Data_Registro,Forma_de_Pagamento,Id_Cliente,Id_Carro) VALUES ( "
                    + " '" + this.getNome_vendedor()+   "' ,  "
                    + " '" + this.getData_registro()+  "' ,  "
                    + " '" + this.getForma_de_pagamento()+  "' ,  "
                    + " '" + this.getId_cliente()+  "' ,  "
                    + " '" + this.getId_carro()+  "' )";
                    
        Conexao.executar( sql );
        System.out.println("\nVenda realizada com Sucesso!");
    }
    
    
    
}
