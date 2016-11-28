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
public class TecnicoAdm extends Pessoa{
    private String Siape;
    private String UnidadeAdm;

    public String getSiape() {
        return Siape;
    }

    public void setSiape(String Siape) {
        this.Siape = Siape;
    }

    public String getUnidadeAdm() {
        return UnidadeAdm;
    }

    public void setUnidadeAdm(String UnidadeAdm) {
        this.UnidadeAdm = UnidadeAdm;
    }
    
}
