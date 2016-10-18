
import static org.junit.Assert.assertEquals;

import org.junit.Test;
/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
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
