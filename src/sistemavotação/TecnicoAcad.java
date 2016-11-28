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
public class TecnicoAcad extends Pessoa{
    private String Siape;
    private String UnidadeAcad;

    public String getSiape() {
        return Siape;
    }

    public void setSiape(String Siape) {
        this.Siape = Siape;
    }

    public String getUnidadeAcad() {
        return UnidadeAcad;
    }

    public void setUnidadeAcad(String UnidadeAcad) {
        this.UnidadeAcad = UnidadeAcad;
    }
    
}
