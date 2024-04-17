
package dao;

import java.util.ArrayList;
import modelo.Convenio;
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
public class ConvenioDAOTest {

    public ConvenioDAOTest() {
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
    public void testBuscarcConvenios() throws SQLException {
        ConvenioDAO convenioDAO = new ConvenioDAO();

        try {
            ArrayList<Convenio> convenios = convenioDAO.buscarcConvenios();
            assertNotNull(convenios);
        } catch (SQLException ex) {
            fail("Erro ao buscar o convênio: " + ex.getMessage());
        }
    }

    @Test
    public void testBuscarConvenioFiltro() throws SQLException {
        ConvenioDAO convenioDAO = new ConvenioDAO();

        // Criando um filtro para buscar convenio
        String filtro = "Unimed";

        try {
            Convenio convenio = convenioDAO.buscarConvenioFiltro(filtro);
            assertNotNull(convenio);
        } catch (SQLException ex) {
            fail("Erro ao buscar convênio com o filtro: " + ex.getMessage());
        }
    }

    @Test
    public void testBuscarFiltroNaoExistente() throws SQLException {
        ConvenioDAO convenioDAO = new ConvenioDAO();

        // Criando um filtro para buscar convenio não existente
        String filtro = "NomeNãoExistente";

        try {
            Convenio convenio = convenioDAO.buscarConvenioFiltro(filtro);
            assertNull(convenio);
        } catch (SQLException ex) {
            fail("Erro ao buscar convênio com filtro: " + ex.getMessage());
        }
    }

}
