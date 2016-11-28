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
public class RespostaME {
    private int ID;
    private int possivel_resposta;
    private String pessoa;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPossivel_resposta() {
        return possivel_resposta;
    }

    public void setPossivel_resposta(int possivel_resposta) {
        this.possivel_resposta = possivel_resposta;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
}
