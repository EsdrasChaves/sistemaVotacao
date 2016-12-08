/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdao;

import java.sql.ResultSet;

/**
 *
 * @author esdraschaves
 */
public interface FormularioDao {
    
    public void fechaStatement();
    public ResultSet getFormularioNumQuestao();
    public ResultSet getQuestoesFormulario(int id);
    public ResultSet getResultadosQuestao(int id);
    public ResultSet getQtaQuestoes(String cpf);
    public boolean deleteResposta(int questao_id);
    public void UpdateRestricao(int id,boolean pro,boolean alu,boolean tec,boolean ter);
}
