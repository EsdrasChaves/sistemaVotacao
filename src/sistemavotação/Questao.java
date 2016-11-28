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
public class Questao {
    private int ID;
    private String descricao;
    private int formulario;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFormulario() {
        return formulario;
    }

    public void setFormulario(int formulario) {
        this.formulario = formulario;
    }
    
}
