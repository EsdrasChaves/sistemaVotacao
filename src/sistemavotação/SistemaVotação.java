/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavotação;

import classesdao.AlunoDao;
import classesdaoimpl.AlunoDaoImpl;
import interfaces.areaAluno;
import interfaces.loginScreen;
import static java.sql.Date.valueOf;
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
        
        /*Formuformularios
        ResultSet r = */
        /*ArrayList<Aluno> alunos = new ArrayList<>();
        
        
       
        
        Aluno a = new Aluno();
        
        a.setCPF("11111111111");
        a.setNome("Gordox");
        a.setEmail_inst("gordox@ufu.br");
        a.setEmail_sec("gordox@gmail.com");
        a.setData_nasc(valueOf("1997-12-30"));
        a.setSenha("gordox1997");
        a.setTipo("alu");
        a.setNro_matricula("00000000005");
        a.setCurso("COMP");
        
        
        
        AlunoDao banco = new AlunoDaoImpl();
        
        
        //banco.insertAluno(a);
        
        //a = banco.getAluno("11111111111");
        
        //System.out.println("Nome: " + a.getNome() + "");
        
        //banco.deleteAluno("11111111111");
        
        //alunos = banco.getAllAlunos();
        
        new loginScreen().setVisible(true);
       
        for (Aluno aluno :alunos) {
            System.out.println("CPF: " + aluno.getCPF() + "  Nome: " + aluno.getNome() + " Email1: " + aluno.getEmail_inst() + " Email2: " 
                    + aluno.getEmail_sec() + " Nascimento: " + aluno.getData_nasc() + " Senha: " + aluno.getSenha() + " Tipo: " 
                    + aluno.getTipo() + " Matricula: " + aluno.getNro_matricula() + " Curso: " + aluno.getCurso() + " FIM");
        }
        
     */
    }
    
}
