/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotação;

import classesdao.AlunoDao;
import classesdaoimpl.AlunoDaoImpl;
import java.util.ArrayList;
import uteis.ConnectionDataBase;

/**
 *
 * @author esdraschaves
 */
public class SistemaVotação {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ConnectionDataBase.loadDrive();
        ConnectionDataBase.getConnection();
        
        ArrayList<Aluno> alunos = new ArrayList<>();
        
        
        AlunoDao banco = new AlunoDaoImpl();
        alunos = banco.getAllAlunos();
        
        
        for (Aluno aluno :alunos) {
            System.out.println("CPF: " + aluno.getCPF() + "  Nome: " + aluno.getNome() + " Email1: " + aluno.getEmail_inst() + " Email2: " 
                    + aluno.getEmail_sec() + " Nascimento: " + aluno.getData_nasc() + " Senha: " + aluno.getSenha() + " Tipo: " 
                    + aluno.getTipo() + " Matricula: " + aluno.getNro_matricula() + " Curso: " + aluno.getCurso() + " FIM");
        }
    }
    
}
