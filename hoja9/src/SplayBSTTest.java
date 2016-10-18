import static org.junit.Assert.*;

import org.junit.Test;

public class SplayBSTTest {
	public SplayBST<String, String> arbol = new SplayBST<String, String>();

	@Test
	public void testGet() {
		arbol.put("nombre", "name");
		assertEquals(arbol.get("nombre"), "name");
	}

	@Test
	public void testPut() {
		arbol.put("nombre", "name");
		assertEquals(arbol.contains("nombre"), true);
	}

}
