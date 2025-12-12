
package loja_de_carros;

import java.time.LocalDateTime;

public abstract class Relatorio {
    private int id;
    private String forma_de_pagamento;
    private String data_registro;
    
    public Relatorio(String forma_de_pagamento, String data_registro) {
        this.forma_de_pagamento = forma_de_pagamento;
        this.data_registro = data_registro;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForma_de_pagamento() {
        return forma_de_pagamento;
    }

    public void setForma_de_pagamento(String forma_de_pagamento) {
        this.forma_de_pagamento = forma_de_pagamento;
    }

    public String getData_registro() {
        return data_registro;
    }

    public void setData_registro(String data_registro) {
        this.data_registro = data_registro;
    }
    
}
