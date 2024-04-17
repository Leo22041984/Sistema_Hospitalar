
package dao;

import java.util.ArrayList;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.sql.SQLException;

/**
 *
 * @author PC
 */
public class PacienteDAOTest {

    public PacienteDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCadastrarPaciente() throws SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        // vamos criar um paciente para o teste do cadastro
        Paciente paciente = new Paciente();
        paciente.setNome("Lucilene");
        paciente.setEndereco("Rua Vicente Sobrinho, 137");
        paciente.setDataNascimento(new java.util.Date());
        paciente.setTelefone("(22) 996457884");
        paciente.setCpf("789.456.123-00");
        paciente.setRg("789.456.12-3");
        paciente.setIdConvenio(1);

        // Fazendo o procedimento de cadastrar o paciente
        try {
            pacienteDAO.cadastrarPaciente(paciente);

        } catch (SQLException ex) {
            fail("Erro ao fazer o cadastro do paciente: " + ex.getMessage());
        }

        // Verificando se o cadastro do paciente foi feito corretamente 
        ArrayList<Paciente> pacientes = pacienteDAO.buscarPaciente();
        boolean pacienteCadastrado = false;
        for (Paciente p : pacientes) {
            if (p.getNome().equals("Lucilene")) {
                pacienteCadastrado = true;
                break;
            }
        }
        assertTrue(pacienteCadastrado);

    }

    @Test
    public void testBuscarPacienteFiltro() throws SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        // Criando filstro para buscar paciente cadastrado "Lucilene"
        String filtro = "WHERE NOME = 'Lucilene'";

        try {
            ArrayList<Paciente> pacientes = pacienteDAO.buscarPacienteFiltro(filtro);
            assertFalse(pacientes.isEmpty());
        } catch (SQLException ex) {
            fail("Erro ao buscar o paciente com o filtro: " + ex.getMessage());
        }
    }

    @Test
    public void testBuscarPaciente() throws SQLException {
        PacienteDAO pacienteDAO = new PacienteDAO();

        try {
            ArrayList<Paciente> pacientes = pacienteDAO.buscarPaciente();
            assertNotNull(pacientes);
        } catch (SQLException ex) {
            fail("Erro ao buscar paciente: " + ex.getMessage());
        }
    }

}
