package aula05poo;

/**
 *
 * @author Daniel
 */
public class ContaBanco {
    //ATRIBUTOS
    public int numConta;
    protected String tipo;
    private String dono;
    private float saldo;
    private boolean status;
    
    public ContaBanco() { //CONSTRUTOR
        this.setStatus(false);
        this.setSaldo(0);
    }

    //MÉTODOS
    public void estadoAtualConta() {
        System.out.println("Conta: " + this.getNumConta());
        System.out.println("Tipo da conta: " + this.getTipo());
        System.out.println("Dono: " + this.getDono());
        System.out.format("Saldo atual: R$%.2f", this.getSaldo());
        System.out.println("\nStatus: " + this.isStatus());
        System.out.println("--------------------------------------");
    }
    
    public void abrirConta(String tipo) {
        this.setStatus(true);
        this.setTipo(tipo);
        
        if(this.getTipo().equals("CC"))
        {
            this.setSaldo(50);
        }else if(this.getTipo().equals("CP"))
        {
            this.setSaldo(150);
        }else
        {
            System.out.println("Tipo de conta inexistente!");
        }
        System.out.println("Conta aberta com sucesso!");
    }
    
    public void fecharConta() {
        if(this.getSaldo() == 0 )
        {    
            this.setStatus(false);
            System.out.println("Conta fechada com sucesso!");
        }    
        else
        {    
            System.out.println("Não foi possível fechar a conta, pois ainda possui dinheiro.");
        }    
    }
    
    public void depositar(float valorDeposito) {
        if(this.isStatus())
        {    
            this.setSaldo(this.getSaldo()+valorDeposito);
            System.out.println("Depósito realizado na conta de " + this.getDono());
        
        }else
        {    
            System.out.println("Impossível depositar, a conta está fechada!");
        }    
    }
    
    public void sacar(float valorSaque) {
        if(this.isStatus())
        {    
            if(this.getSaldo() >= valorSaque)
            {
                this.setSaldo(this.getSaldo() - valorSaque);
                System.out.println("Saque realizado na cona de " + this.getDono());
            }else
            {
                System.out.println("Saldo insuficiente para o saque.");
            }
        }else
        {
            System.out.println("Impossível sacar, a conta está fechada!");
        }    
    }
    
    public void pagarMensal() {
        int valMen;
        if(this.getTipo().equals("CC"))
        {
            valMen = 12;
        }else
        {
            valMen = 20;
        }
        
        if(this.isStatus())
        {
            if(this.getSaldo() >= valMen)
            {    
                this.setSaldo(this.getSaldo() - valMen);
                System.out.println("Mensalidade paga com sucesso por " + this.getDono());
            }    
            else
            {
                System.out.println("Saldo insuficiente para pagar a mensalidade!");
            }    
        }else
        {
            System.out.println("Impossível pagar a mensalidade, a conta está fechada!");
        }
    }
    
    //GETTERS
    
    public int getNumConta() {
        return numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public String getDono() {
        return dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    //SETTERS
    
    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
    
}
