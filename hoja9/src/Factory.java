/**
 * @author JorgeAndres
 * @author carlos calderon
 * @version 1
 * 
 */
public class Factory implements MapeoFactory {

	public Mapeo getMapeo(String tipoMapeo) {
		if ("HS".equalsIgnoreCase(tipoMapeo)) {
			return new Asociacion<String, String>();
		}
		if ("SP".equalsIgnoreCase(tipoMapeo)) {
			return new SplayBST<String, String>();

		}

		return null;
	}

}
