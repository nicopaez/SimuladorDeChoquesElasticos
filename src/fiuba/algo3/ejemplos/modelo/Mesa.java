package fiuba.algo3.ejemplos.modelo;

import java.util.ArrayList;
import java.util.List;

public class Mesa implements Superficie, ObjetoPosicionable {

	private int ancho;
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	private int alto;
	
	private List<ObjetoPosicionable> posicionables;
	
	public Mesa(int ancho, int alto) {
		super();
		this.ancho = ancho;
		this.alto = alto;
		this.posicion = new Vector(0,0);
		this.posicionables = new ArrayList<ObjetoPosicionable>();
	}

	public void agregarObjetoPosicionable(ObjetoPosicionable objetoPosicionable) {
		this.posicionables.add(objetoPosicionable);
	}

	@Override
	public boolean estaEnLosLimites(Vector punto) {
		if(Math.abs(punto.getX()) >= (this.ancho/2) || Math.abs(punto.getY()) >= (this.alto/2))
			return false;
		return true;
	}

	@Override
	public List<ObjetoPosicionable> getObjetos() {
		return this.posicionables;
	}

	@Override
	public Vector getPosicion() {
		return this.posicion;
	}

	private Vector posicion;
	
	@Override
	public Vector getVelocidad() {
		return this.velocidad;
	}

	private Vector velocidad;
	
	@Override
	public float getMasa() {
		return Float.MAX_VALUE;
	}

	@Override
	public void setVelocidad(Vector vector) {
		this.velocidad = vector;
	}

}
