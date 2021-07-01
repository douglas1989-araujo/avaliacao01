package classes;

import java.util.InputMismatchException;

/**
 * Pessoas
 */
public abstract class Pessoa {
    private String nome;
    private String cpf;
    
    public Pessoa(){

    }
    public Pessoa(String cpf){
    
        setCpf(cpf);
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        if (cpf!= null && cpf.matches("\\d{11}")) {
            this.cpf = cpf;
            
        } else {
            throw new InputMismatchException("O cpf deve conter 11 caracteres");
        }
        
    }

    public String getCpfFormatado() {
        if (cpf != null) {
            return cpf.substring(0, 3) + "." +
                   cpf.substring(3, 6) + "." +
                   cpf.substring(6, 9) + "-" +
                   cpf.substring(9);
        } else {
            return null;
        }
    }
  @Override
   public boolean equals (Object outroCpf){
       boolean notNull = outroCpf != null;
       boolean cpfIguais = getCpf().equals(((Pessoa)outroCpf).getCpf());
    return notNull && cpfIguais;
   }
    
}