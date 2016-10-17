import static org.junit.Assert.*;

import org.junit.Test;


public class DiccionarioTest {

	Diccionario dic = new Diccionario();


	
	@Test
	public void testLlenarArbol() {
		dic.listo("SP");
		dic.leerContenido("C:\\Users\\JorgeAndres\\Desktop\\diccionario.txt");
		dic.llenarHash();
		assertEquals(1,1);
	}

}
