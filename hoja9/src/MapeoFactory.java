/**
 * @author Jorge Azmitia, 15202
 * @author Carlos Calderon,15219
 * @version 1.0
 * Interfaz para patron Factory.
 * 
 */
public interface MapeoFactory {
	/**
	 * @param tipoMapeo	El tipo de mapeo requerido.
	 * @return	La instaciacion del mapeo.
	 */
	Mapeo getMapeo(String tipoMapeo);
}
