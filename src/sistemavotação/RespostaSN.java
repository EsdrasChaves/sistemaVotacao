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
public class RespostaSN {
    private int questao;
    private boolean resposta;
    private String pessoa;

    public int getQuestao() {
        return questao;
    }

    public void setQuestao(int questao) {
        this.questao = questao;
    }

    public boolean isResposta() {
        return resposta;
    }

    public void setResposta(boolean resposta) {
        this.resposta = resposta;
    }

    public String getPessoa() {
        return pessoa;
    }

    public void setPessoa(String pessoa) {
        this.pessoa = pessoa;
    }
}
