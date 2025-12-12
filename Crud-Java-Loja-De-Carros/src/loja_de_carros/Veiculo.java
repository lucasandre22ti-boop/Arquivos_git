
package loja_de_carros;

public interface Veiculo {
      
    public void dados();
       
    String getMarca();
    void setMarca(String marca);

    String getModelo();
    void setModelo(String modelo);

    double getPreco();

    void setPreco(double preco);

    int getQuantidade();
    void setQuantidade(int quantidade);

     int getId();
     void setId(int id);
 
}



     


