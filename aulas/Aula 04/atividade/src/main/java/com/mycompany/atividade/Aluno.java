package com.mycompany.atividade;

public class Aluno {
    private String nomeCompleto;
    private int dia;
    private int mes;
    private int ano;
    private String sexo;
    private int matricula;
    private String curso;
    private String cpf;
    private String rua;
    private int numero;
    private String bairro;
    private String cidade;
    private String Cep;
    private String estado;
    private String contato;

    public Aluno(String nomeCompleto, int dia, int mes, int ano, String sexo, int matricula, String curso, String cpf, String rua, int numero, String bairro, String cidade, String Cep, String estado, String contato) {
        this.nomeCompleto = nomeCompleto;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.sexo = sexo;
        this.matricula = matricula;
        this.curso = curso;
        this.cpf = cpf;
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.Cep = Cep;
        this.estado = estado;
        this.contato = contato;
    }

    @Override
    public String toString() {
        return "Aluno: " + nomeCompleto + ", " + dia + "/" + mes + "/" + ano + ", " + sexo + ", " + matricula + ", "+ curso + ", " + cpf + ", Rua " + rua + ", " + numero + ", " + bairro + ", " + cidade + ", " + Cep + ", " + estado + ", " + contato + '}';
    }

}
