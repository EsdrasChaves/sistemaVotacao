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
public class Aluno extends Pessoa{
    private String Nro_matricula;
    private String Curso;

    public String getNro_matricula() {
        return Nro_matricula;
    }

    public void setNro_matricula(String Nro_matricula) {
        this.Nro_matricula = Nro_matricula;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }
    
    
}
