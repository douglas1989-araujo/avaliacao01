package classes;
public class Piloto extends Pessoa {
    private String habilitacao;
    private String matricula;
    public Piloto(){
        
    }
     public Piloto(String nome,String cpf, String matrcula){
     setNome(nome);
     setMatricula(matricula);
     setCpf(cpf);
        
    }
    public String getHabilitacao() {
        return habilitacao;
    }
    public void setHabilitacao(String habilitacao) {
        this.habilitacao = habilitacao;
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    @Override
   public boolean equals (Object outroCpf){
       boolean notNull = outroCpf != null;
       boolean cpfIguais = getCpf().equals(((Piloto)outroCpf).getCpf());
    return notNull && cpfIguais;
   }
}
