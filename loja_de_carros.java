package loja_de_carros;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class loja_de_carros {

    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
       ArrayList<BD> listaclientes = new ArrayList();
       ArrayList<Carro> listacarros = new ArrayList();
       ArrayList<String> listamarcas = new ArrayList();
       
     
       int menu,subMenu,id,idcli,quantidade,car, parcelas;
       long cpf,telefone;
       String nome,email,marca,modelo;
       String nome_vendedor,pag=" ";
       String marcaSelecionada,cpf_caractere;
       int formaPagamento;
       double preco;
       
       BD clientes;
       Carro carros;
      
       do{
           System.out.println("\n1 - Comprar carro");
           System.out.println("2 - Cadastrar Clientes");
           System.out.println("3 - Cadastrar carro");
           System.out.println("4 - Listar Clientes");
           System.out.println("5 - Listar carros");
           System.out.println("6 - Excluir clientes");
           System.out.println("7 - Editar Clientes");
           System.out.println("8 - Excluir carro");
           System.out.println("9 - Relatório de Vendas");
           System.out.println("0 -Sair");
           System.out.print("\nDigite sua opção: ");
           menu=sc.nextInt();
           switch(menu){
               case 1:
                   System.out.println("\nInforme o Cpf do Cliente: ");
                   cpf=sc.nextLong();
                   if(cpf==0){
                            break;
                        }
                
                
                   while(BD.verificarCpf(cpf)==false){
                        System.out.println("\nCpf não encontrado, Informe o Cpf novamente: ");
                        cpf=sc.nextLong();       
                        if(cpf==0){
                            break;
                        }
                   }
                   if(BD.verificarCpf(cpf)==true){
                       System.out.println("");
                       listamarcas = Carro.getMarcas();
                       
                       for(int c=0;c<listamarcas.size();c++){   
                            System.out.println((c+1)+" - "+listamarcas.get(c));   
                       }
                       System.out.println("\nDigite o Número da Marca:");
                       subMenu=sc.nextInt();
                      
                       
                       
                       for(int c=0;c<listamarcas.size();c++){   
                            if(subMenu==c+1){
                                marcaSelecionada=listamarcas.get(c);
                                listacarros = Carro.getModelos(marcaSelecionada);
                                    for(Carro p:listacarros){
                                    System.out.println("\nid: " + p.getId());                                
                                    System.out.println("modelo: " + p.getModelo());
                                    System.out.println("preço: R$ " + p.getPreco());
                                    System.out.println("quantidade: " + p.getQuantidade()+"\n"); 
                                }
                                System.out.println("\nDigite o Id do carro que deseja adquirir:"); 
                                id=sc.nextInt();
                                while(BD.verificarId(id)==false){
                                    System.out.println("\nId não encontrado,Informe o Id novamente: ");
                                    id=sc.nextInt();                  
                                }
                                System.out.println("\nSelecione o método de pagamento:");
                                System.out.println("\n1 - Avista");
                                System.out.println("2 - Parcelado");
                                System.out.println("0 - Sair\n");
                               
                                formaPagamento=sc.nextInt();
                                if(formaPagamento==0){
                                    break;
                                }
                                
                               
                                
                                while(formaPagamento!=1 && formaPagamento!=2){
                                    System.out.println("\nNúmero inválido, Informe novamente: ");
                                    System.out.println("\n1 - Avista");
                                    System.out.println("2 - Parcelado");
                                    System.out.println("0 - Sair");
                                    formaPagamento=sc.nextInt();    
                                    if(formaPagamento==0){
                                        break;
                                    }
                                }
                                
     
                                if(formaPagamento==1){
                                    pag="Avista";
                                }
                   
                           if(formaPagamento==2){
                                     System.out.print("Digite O número de parcelas:\n");
                                     parcelas=sc.nextInt();
                                    if(parcelas==0){
                                        break;
                                    }
                                    while(parcelas<1){
                                        System.out.println("\nNúmero Inválido, Digite Novamente:\n"); 
                                        parcelas=sc.nextInt();

                                        if(parcelas==0){
                                        break;
                                        }
                                    }
                                        pag="Parceleado-"+parcelas+" Vezes de "+(Vendas.verificarCarro_Cliente(id)/parcelas);
                                        
                                }
                                sc.nextLine();
                                System.out.println("\nDigite o nome do Vendedor:"); 
                                nome_vendedor=sc.nextLine();
                             
                               
                             
                                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                                Date date = new Date();
                                String data=dateFormat.format(date);
                               
                                Vendas venda=new Vendas(pag,data,BD.verificarId_Cliente(cpf),id," ",nome_vendedor,cpf," "," ",0.0);       
                                venda.cadastrar();
                               
                                                   
                            }   
                       }                    
                 
                   }
                                                 
                   break;
               case 2:
                   System.out.println("Nome: ");
                   sc.nextLine();
                   nome = sc.nextLine();
                   if("0".equals(nome)){
                           break;
                   }
                   System.out.println("Email: ");
                   email = sc.nextLine();
                   if("0".equals(email)){
                           break;
                   }
                   
                  
                   System.out.println("cpf: ");
                   cpf = sc.nextLong();
                   
                   
                   if(cpf==0){
                        break;
                   }
                   cpf_caractere = Long.toString(cpf);
                   while(cpf_caractere.length()!=11){
                       System.out.println("\nCpf Inválido, tente novamente: ");
                       cpf = sc.nextLong();
                       cpf_caractere = Long.toString(cpf);
                        if(cpf==0){
                            break;
                        
                        }
                   }
                   
                           if(cpf==0){
                            break;
                        
                        }
                   System.out.println("telefone: ");
                   telefone = sc.nextLong();
                   if(telefone==0){
                        break;
                   }
                   clientes = new BD(nome, email, cpf,telefone);
                   clientes.cadastrar();
                  listaclientes.add(clientes);
                   System.out.println("\nCadastrado com sucesso!");
               break;
              
               case 3: 
                   System.out.println("marca do carro: ");
                   marca=  sc.next();
                   if("0".equals(marca)){
                         break;
                   }
                   System.out.println("modelo : ");
                   modelo = sc.next();
                   if("0".equals(modelo)){
                      break;
                    }
                   sc.nextLine();
                   System.out.println("preço : ");
                   preco = sc.nextDouble();
                   if(preco==0){
                        break;
                    }
                   System.out.println("quantidade : ");
                   quantidade = sc.nextInt();
                    if(quantidade==0){
                       break;
                    }
                   carros = new Carro(marca, modelo, preco,quantidade);
                   carros.cadastrar();
                  listacarros.add(carros);
                   System.out.println("\nCadastrado com sucesso!");
               break;
             
               case 4: 
                   System.out.println("\nLista de clientes: \n");
                   listaclientes = BD.getClientes();
                   for(BD p:listaclientes){
                       p.dados();
                   }
               break;
               
               case 5 :System.out.println("\nlista de carros: "+"\n");
                   listacarros = Carro.getCarro();
                   for(Carro p:listacarros){
                       p.dados();
                              }
                   break;
                   
                case 6:
  
                   System.out.print("\nDigite o ID do cliente que será excluído: #O Cliente só poderá ser excluído se não tiver realizado nenhuma compra.\n");
                   idcli = sc.nextInt();
                   if(idcli==0){
                           break;
                   }
                   BD.excluir(idcli);
                   System.out.print("\n\nCliente excluido com sucesso! ");
       
               
                   break;
               
                case 7:
                   listaclientes = BD.getClientes();
                   System.out.println();
                   for(BD p:listaclientes){
                       System.out.println(p.getId() + " - " + p.getNome());
                   }
                   System.out.print("\nDigite o ID do cliente que será editado: ");
                   idcli = sc.nextInt();
                   if(idcli==0){
                           break;
                   }
                   System.out.println("Novo nome: ");
                   sc.nextLine();
                   nome = sc.nextLine();
                   if("0".equals(nome)){
                           break;
                   }
                   System.out.println("Novo e-mail: ");
                   email = sc.nextLine();
                   
                   if("0".equals(email)){
                           break;
                   }
                  
                   System.out.println("novo cpf: ");
                   cpf = sc.nextLong();
                   
                   if(cpf==0){
                        break;
                   }
                   cpf_caractere = Long.toString(cpf);
                   while(cpf_caractere.length()!=11){
                       System.out.println("\nCpf Inválido, tente novamente: ");
                       cpf = sc.nextLong();
                       cpf_caractere = Long.toString(cpf);
                        if(cpf==0){
                            break;
                        
                        }
                   }
                   
                   if(cpf==0){
                            break;
                        
                    }
                   System.out.println("novo telefone: ");
                   telefone = sc.nextLong();
                   if(telefone==0){
                           break;
                   }
                   System.out.println("\nEditado com sucesso!: ");
                   clientes = new BD(nome, email, cpf,telefone);
                   clientes.setId( idcli );
                   clientes.editar_Cliente();
                  
                   break;
                   
               case 8:listacarros = Carro.getCarro();
                   for(Carro p:listacarros){
                       p.dados();
                 
                   }
                   System.out.print("Digite o ID do carro que será excluído: ");
                   car = sc.nextInt();
                   if(car==0){
                           break;
                   }
                   Carro.excluir( car );
                   System.out.print("\nCarro excluido com sucesso! ");
                  
                   break;
               case 9:
                    System.out.println();
                    Vendas.getVendas();
                       
                    
       }
                 
                   
                   
                   
                   
                   
           
       } while(menu!=0);
           
    }
}
     
    
       
      
   
       

    
                
       