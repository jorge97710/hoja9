import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
public class DiccionarioTest {

	Diccionario dic = new Diccionario();

	@Test
	public void testLlenarArbol() {
		dic.listo("SP");
		dic.crear("C:\\Users\\JorgeAndres\\Desktop\\diccionario.txt");
		assertEquals(1, 1);
	}

}
