package pkt;

public class Aluno {
    private String nomeCompleto;
   
    // private int dia;
    // private int mes;
    // private int ano;
    
    private String endereco;
    
    private String data;
    private String sexo;
    private int matricula;
    private String curso;
    private String cpf;
    private String contato;

    public Aluno(String nomeCompleto, String data, String sexo, String endereco, int matricula, String curso, String cpf, String contato) {
        this.nomeCompleto = nomeCompleto;
        this.endereco = endereco;
        this.data = data;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Aluno{" + "nomeCompleto=" + nomeCompleto + ", endereco=" + endereco + ", data=" + data + ", sexo=" + sexo + ", matricula=" + matricula + ", curso=" + curso + ", cpf=" + cpf + ", contato=" + contato + '}';
    }


}
