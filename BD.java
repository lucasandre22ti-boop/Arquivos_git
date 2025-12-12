package loja_de_carros;

import java.sql.ResultSet;
import java.util.ArrayList;

public class BD extends Cliente {
    
    public BD(String nome, String email, long cpf,long telefone){
        super(nome,email,cpf,telefone);
                
       
    }
    public void cadastrar(){
        String  sql =  "INSERT INTO clientes (Nome,Email,Cpf,Telefone) VALUES ( "
                    + " '" + this.getNome() +   "' ,  "
                    + " '" + this.getEmail() +  "' ,  "
                    + " '" + this.getCpf() +  "' ,  "
                    + " '" + this.getTelefone() +"'  ) ";
        Conexao.executar( sql );
    }
    
    public void editar_Cliente(){
        String sql =  "UPDATE clientes SET  "
                    + " nome    = '" + this.getNome() +   "' ,  "
                    + " email   = '" + this.getEmail() +  "' ,  "
                    + " cpf =  '" + this.getCpf() +"', "
                    + " telefone =  '" + this.getTelefone() +"' "
                    + " WHERE id = '" + this.getId()+"'";
        Conexao.executar( sql );
    }
    
    public static void excluir(int idClientes){
             String sql =  "DELETE FROM clientes  WHERE Id = " + idClientes;
                   
    
        
      Conexao.executar(sql);
    }
    public static boolean verificarCpf(long cpf){
        String sql = "SELECT cpf FROM clientes ORDER BY cpf";
        boolean encontradoCpf=false;
        ResultSet rs = Conexao.consultar(sql);
        
        if( rs != null){
            
            try{
                while (rs.next()) {                
                    long cpf_bd=rs.getLong(1);
                    if(cpf==cpf_bd){
                        encontradoCpf=true;
                    }
                  
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
        return encontradoCpf;
    }
    public static int verificarId_Cliente(long cpf){
        String sql = "SELECT id,cpf FROM clientes WHERE Cpf="+"'"+cpf+"'";

        ResultSet rs = Conexao.consultar(sql);
        
        if( rs != null){
            
            try{
                while (rs.next()) {                
                    long cpf_cliente=rs.getLong(2);
                    if(cpf==cpf_cliente){
                        return rs.getInt(1);
                    }
                  
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
        return 0;
    }
    public static boolean verificarId(int id){
        String sql = "SELECT id FROM carro WHERE id="+"'"+id+"'";
        boolean encontradoId=false;
        ResultSet rs = Conexao.consultar(sql);
        
        if( rs != null){
            
            try{
                while (rs.next()) {    
                    
                    int id_bd=rs.getInt(1);                
                    if(id==id_bd){
                        encontradoId=true;
                    }
                  
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
        
        return encontradoId;
    }
    
    
    
    public static ArrayList<BD> getClientes(){
        ArrayList<BD> lista = new ArrayList<>();
        
        String sql = "SELECT id, nome, email, cpf,telefone FROM clientes ORDER BY nome ";
        
        ResultSet rs = Conexao.consultar( sql );
        
        if( rs != null){
            
            try{
                while ( rs.next() ) {                
                    String nome = rs.getString( 2);
                    String email = rs.getString( 3 );
                    long cpf = rs.getLong(4);
                    long telefone = rs.getLong(5);
                    BD cli = new BD(nome, email, cpf,telefone);
                    cli.setId( rs.getInt(1 ) );
                    lista.add( cli );
                }
            }catch(Exception e){
                System.out.println("==>" + e);
            }
            
        }
     
        return lista;
    }
    
    
    
 
}