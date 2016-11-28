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
public class Professor extends Pessoa{
    private String Siape;
    private String regime_trabalho;
    private String unidade_academica;
    

    public String getSiape() {
        return Siape;
    }
    
    public void setSiape(String Siape) {
        this.Siape = Siape;
    }

    public String getRegime_trabalho() {
        return regime_trabalho;
    }


    public void setRegime_trabalho(String regime_trabalho) {
        this.regime_trabalho = regime_trabalho;
    }


    public String getUnidade_academica() {
        return unidade_academica;
    }


    public void setUnidade_academica(String unidade_academica) {
        this.unidade_academica = unidade_academica;
    }
    
    
}
