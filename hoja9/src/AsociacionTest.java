import static org.junit.Assert.*;

import org.junit.Test;

public class AsociacionTest {
	public Asociacion<String, String> arbol = new Asociacion<String, String>();

	/**
	 * 
	 */
	@Test
	public void testGet() {
		arbol.put("nombre", "name");
		assertEquals(arbol.get("nombre"), "name");
	}

	/**
	 * 
	 */
	@Test
	public void testPut() {
		arbol.put("nombre", "name");
		assertEquals(arbol.contains("nombre"), true);
	}

}
