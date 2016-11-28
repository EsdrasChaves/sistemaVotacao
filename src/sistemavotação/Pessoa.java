/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotação;

/**
 *
 * @author esdraschaves
 */
public class Pessoa {
    private String CPF;
    private String Nome;
    private String email_inst;
    private String email_sec;
    private String data_nasc;
    private String senha;
    private String tipo;
    
    
    public String getCPF() {
        return CPF;
    }
    
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    public String getNome() {
        return Nome;
    }
    
    public void setNome(String Nome) {
        this.Nome = Nome;
    }
    
    public String getEmail_inst() {
        return email_inst;
    }
    
    public void setEmail_inst(String email_inst) {
        this.email_inst = email_inst;
    }
    
    public String getEmail_sec() {
        return email_sec;
    }
    
    public void setEmail_sec(String email_sec) {
        this.email_sec = email_sec;
    }
    
    public String getData_nasc() {
        return data_nasc;
    }
    
    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }
    
    public String getSenha() {
        return senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
}
