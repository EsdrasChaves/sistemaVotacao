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
public class Restricao {
    private int Formulario;
    private boolean Professor;
    private boolean Aluno;
    private boolean Tecnico;
    private boolean Terceirizado;

    public int getFormulario() {
        return Formulario;
    }

    public void setFormulario(int Formulario) {
        this.Formulario = Formulario;
    }

    public boolean isProfessor() {
        return Professor;
    }

    public void setProfessor(boolean Professor) {
        this.Professor = Professor;
    }

    public boolean isAluno() {
        return Aluno;
    }

    public void setAluno(boolean Aluno) {
        this.Aluno = Aluno;
    }

    public boolean isTecnico() {
        return Tecnico;
    }

    public void setTecnico(boolean Tecnico) {
        this.Tecnico = Tecnico;
    }

    public boolean isTerceirizado() {
        return Terceirizado;
    }

    public void setTerceirizado(boolean Terceirizado) {
        this.Terceirizado = Terceirizado;
    }
    
}
