package br.ufms.facom.pegaaulaapp.model;


public class Professor {

    private Integer idProfessor;
    private String nome;
    private Integer idade;
    private String cpf;
    private String tipoProfessor;
    private String email;
    private String senha;


    public Integer getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Integer idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoProfessor() {
        return tipoProfessor;
    }

    public void setTipoProfessor(String tipoProfessor) {
        this.tipoProfessor = tipoProfessor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() { return senha;}

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
