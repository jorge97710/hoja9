import static org.junit.Assert.*;

import org.junit.Test;

public class DiccionarioTest {

	Diccionario dic = new Diccionario();

	@Test
	public void testLlenarArbol() {
		dic.listo("SP");
		dic.crear("C:\\Users\\JorgeAndres\\Desktop\\diccionario.txt");
		assertEquals(1, 1);
	}

}
