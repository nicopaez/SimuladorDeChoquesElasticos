package fiuba.algo3.ejemplos.modelo;

import java.util.List;

public interface Superficie {

	boolean estaEnLosLimites(Vector punto);
	List<ObjetoPosicionable> getObjetos();
}
