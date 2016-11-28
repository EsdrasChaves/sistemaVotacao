/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classesdao;

import java.util.ArrayList;
import sistemavotação.Aluno;

/**
 *
 * @author esdraschaves
 */
public interface AlunoDao {
    public ArrayList<Aluno> getAllAlunos();
    public int insertAluno (Aluno aluno);
    public Aluno getAluno (Aluno aluno);
    public void deleteAluno (String cpf);
}
