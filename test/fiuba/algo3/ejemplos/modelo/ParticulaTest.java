package fiuba.algo3.ejemplos.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ParticulaTest {
	
	@Before
	public void setUp() throws Exception {
		float masa = 1;
		Vector posicion = new Vector(0, 0);
		Vector velocidad = new Vector(1, 1);
		
		Mesa mesa = mock(Mesa.class);
		List<ObjetoPosicionable> objetos = new ArrayList<ObjetoPosicionable>();
		this.pelota = new Particula(masa, posicion, velocidad, mesa);
		
		objetos.add(this.pelota);
		when(mesa.getObjetos()).thenReturn(objetos);
	}
	
	@Test
	public void noDeberiaCambiarPosicionCuandoNoPasaTiempo() {
		Vector posicionInicial = this.pelota.getPosicion();
		this.pelota.vivir(0);
		assertEquals(posicionInicial, this.pelota.getPosicion());
	}
		
	@Test
	public void deberiaCambiarPosicionCuandoPasaTiempo() {
		Vector posicionInicial = this.pelota.getPosicion();
		this.pelota.vivir(1);
		assertEquals(posicionInicial.mas(new Vector(1,1)), this.pelota.getPosicion());
	}
	
	@Test
	public void deberiaDetenerseAlChocarConOtraIgualPeroQuieta() {
		Particula unaPelota = this.crearPelota();
		Particula otraPelota = this.crearPelotaQuieta();

		otraPelota.chocarCon(unaPelota);
		
		Vector velocidadFinal = unaPelota.getVelocidad();
		assertEquals(new Vector(0,0), velocidadFinal);
	}

	@Test
	public void deberiaMoverseCuandoEstaQuietaYUnaIgualLaChoca() {
		Particula unaPelota = this.crearPelotaQuieta();
		Particula otraPelota = this.crearPelota();
		unaPelota.chocarCon(otraPelota);
		Vector velocidadFinal = unaPelota.getVelocidad();
		assertEquals(new Vector(1,1), velocidadFinal);
	}
	
	@Test
	public void deberiaMoverseEnSentidoContrarioCuandoChocaConUnaGiganteQuieta() {
		Particula unaPelota = this.crearPelota();
		Particula otraPelota = this.crearPelotaGiganteYQuieta();
		Vector velocidadInicial = unaPelota.getVelocidad();
		
		unaPelota.chocarCon(otraPelota);
		
		Vector velocidadFinal = unaPelota.getVelocidad();
		assertEquals(velocidadInicial.invertir(), velocidadFinal);
	}

	private Particula crearPelota(){
		float masa = 1;
		Vector posicion = new Vector(0, 0);
		Vector velocidad = new Vector(1, 1);
		Mesa mesa = this.crearMesa();
		return new Particula(masa, posicion, velocidad, mesa);
	}

	private Particula crearPelotaQuieta(){
		float masa = 1;
		Vector posicion = new Vector(0, 0);
		Vector velocidad = new Vector(0, 0);
		Mesa mesa = this.crearMesa();
		return new Particula(masa, posicion, velocidad, mesa);
	}

	private Particula crearPelotaGiganteYQuieta(){
		float masa = 1000000;
		Vector posicion = new Vector(0, 0);
		Vector velocidad = new Vector(0, 0);
		Mesa mesa = this.crearMesa();
		return new Particula(masa, posicion, velocidad, mesa);
	}
	private Particula pelota;
	
	private Mesa crearMesa(){
		Mesa mesa = mock(Mesa.class);
		List<ObjetoPosicionable> objetos = new ArrayList<ObjetoPosicionable>();
		objetos.add(this.pelota);
		when(mesa.getObjetos()).thenReturn(objetos);
		return mesa;
	}

}
