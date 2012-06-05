package fiuba.algo3.ejemplos.modelo;

import java.util.List;


public class Particula implements ObjetoPosicionable, ObjetoVivo {

	private Vector posicion;
	private Vector velocidad;
	private float masa;
	private Superficie superficie;

	
	public Particula(float masa, Vector posicion, Vector velocidad, Superficie superficie) {
		super();
		this.velocidad = velocidad;
		this.masa = masa;
		this.posicion = posicion;
		this.superficie = superficie;
	}

	@Override
	public void vivir(int tiempoTranscurrido) {
		if(tiempoTranscurrido == 0)
			return;
		
		boolean puedoAvanzar = true;
		Vector nuevaPosicionCandidata = this.posicion.mas(this.velocidad.por(tiempoTranscurrido));
		List<ObjetoPosicionable> objetos = this.superficie.getObjetos();
		for (ObjetoPosicionable objeto : objetos) {
			if(objeto.getPosicion().equals(nuevaPosicionCandidata)) {
				puedoAvanzar = false;
				this.chocarCon(objeto);
			}
		}
		if(puedoAvanzar)
			this.posicion = nuevaPosicionCandidata;
	}

	public Vector getPosicion() {
		return this.posicion;
	}

	public void chocarCon(ObjetoPosicionable otraPelota) {
		if(this.equals(otraPelota))
			return;
		float v1xf = calcularVFinal(this.velocidad.getX(), otraPelota.getVelocidad().getX(), this.masa, otraPelota.getMasa());
		float v1yf = calcularVFinal(this.velocidad.getY(), otraPelota.getVelocidad().getY(), this.masa, otraPelota.getMasa());
		
		float v2xf = calcularVFinal(otraPelota.getVelocidad().getX(), this.velocidad.getX(), otraPelota.getMasa(), this.getMasa());
		float v2yf = calcularVFinal(otraPelota.getVelocidad().getY(), this.velocidad.getY(), otraPelota.getMasa(), this.getMasa());
		
		this.velocidad = new Vector(v1xf, v1yf);
		otraPelota.setVelocidad(new Vector(v2xf, v2yf));
	}

	final static int ROUNDER = 10;
	
	// http://www.sc.ehu.es/sbweb/fisica/
	// dinamica/con_mlineal/choques/choques.htm
	private float calcularVFinal(float v1, float v2, float m1, float m2) {
		float rawResult = ((2 * m2 * v2) + (m1 - m2) * v1) / (m1 + m2);
		return Math.round(rawResult * ROUNDER) / ROUNDER; 
	}
	
	public Vector getVelocidad() {
		return this.velocidad;
	}

	@Override
	public float getMasa() {
		return this.masa;
	}

	@Override
	public void setVelocidad(Vector velocidad) {
		this.velocidad = velocidad;
	}
	
}
