package br.ufms.facom.pegaaulaapp.model;

import java.io.Serializable;

public class ProfessorSubstituto implements Serializable {

    private String nome;
    private String materia;
    private String localizacao;
    private String contato;
    private Integer idade;
    private String periodo;
    private Integer avatar;

    public ProfessorSubstituto(String nome, String materia, String localizacao, String contato, Integer idade, String periodo, Integer avatar){
        this.nome = nome;
        this.materia = materia;
        this.localizacao = localizacao;
        this.contato = contato;
        this.idade = idade;
        this.periodo = periodo;
        this.avatar = avatar;
    }

    public Integer getAvatar() {
        return avatar;
    }

    public void setAvatar(Integer avatar) {
        this.avatar = avatar;
    }

    public Integer getIdade() {
        return idade;
    }
    public void setIdade(Integer idade) {
        this.idade = idade;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
}
