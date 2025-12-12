
package loja_de_carros;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Carro implements Veiculo{
    private String marca;
    private String modelo;
    private double preco;
    private int quantidade,id;

    public Carro(String marca, String modelo, double preco, int quantidade) {
        this.marca = marca;
        this.modelo = modelo;
        this.preco = preco;
        this.quantidade = quantidade;
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

   
    public int getQuantidade() {
        return quantidade;
    }

   
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
  public void cadastrar(){
        String  sql =  "INSERT INTO carro (Marca,Modelo,Preco,Quantidade) VALUES ( "
                    + " '" + this.getMarca() +   "' ,  "
                    + " '" + this.getModelo() +  "' ,  "
                    + " '" + this.getPreco() +  "' ,  "
                    + " '" + this.getQuantidade() +"'  ) ";
        Conexao.executar( sql );
    
  }
  public static void excluir(int idCarro){
        String sql =  "DELETE FROM carro  WHERE id = " + idCarro;
                   
        
        
      Conexao.executar( sql );
    }
  
      public static ArrayList<Carro> getCarro(){
        ArrayList<Carro> lista = new ArrayList<>();
        
        String sql = "SELECT Id, Marca, Modelo, Preco,Quantidade FROM carro ORDER BY Marca";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {                
                    String marca = rs.getString( 2);
                    String modelo = rs.getString( 3 );
                    double preco = rs.getDouble( 4 );
                    int quantidade = rs.getInt(5);
                    Carro car = new Carro(marca, modelo,preco,quantidade);
                    car.setId( rs.getInt(1 ) );
                    lista.add(  car );
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
     
        return lista;
    }
      public static ArrayList<Carro> getModelos(String Marca){
        ArrayList<Carro> lista = new ArrayList<>();
        
        String sql = "SELECT Id, Modelo, Preco,Quantidade FROM carro WHERE Marca='"+Marca+"'";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {         
                    String modelo = rs.getString( 2 );
                    double preco = rs.getDouble( 3 );
                    int quantidade = rs.getInt(4);
                    Carro car = new Carro(Marca, modelo,preco,quantidade);
                    car.setId( rs.getInt(1 ) );
                    lista.add(  car );
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
     
        return lista;
    }
      public static ArrayList<String> getMarcas(){
        ArrayList<String> lista = new ArrayList<>();
        
        String sql = "SELECT Marca FROM carro ORDER BY Marca";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {                
                    String marca = rs.getString(1);
                    
                    lista.add(marca);
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
     
        return lista;
    }
        public void dados(){
        System.out.println("\nid: " + getId());
        System.out.println("marca: " + getMarca());
        System.out.println("modelo: " + getModelo());
         System.out.println("preço: R$ " + getPreco());
         System.out.println("quantidade: " + getQuantidade()+"\n");
    
    }
}
    
  
  

    
