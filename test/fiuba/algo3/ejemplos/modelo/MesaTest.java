package fiuba.algo3.ejemplos.modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class MesaTest {

	@Test
	public void deberiaDevolverFalseCuandoEstaFueraDeLimitesEnXeY() {
		Mesa mesa = new Mesa(100,100);
		boolean resultado = mesa.estaEnLosLimites(new Vector(200,200));
		assertFalse(resultado);
	}

	@Test
	public void deberiaDevolverFalseCuandoEstaFueraDeLimitesEnX() {
		Mesa mesa = new Mesa(100,100);
		boolean resultado = mesa.estaEnLosLimites(new Vector(200,20));
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseCuandoEstaFueraDeLimitesEnY() {
		Mesa mesa = new Mesa(100,100);
		boolean resultado = mesa.estaEnLosLimites(new Vector(20,200));
		assertFalse(resultado);
	}
	
	@Test
	public void deberiaDevolverTrueCuandoEstaDentroDeLimites() {
		Mesa mesa = new Mesa(100,100);
		boolean resultado = mesa.estaEnLosLimites(new Vector(20,20));
		assertTrue(resultado);
	}
	
	@Test
	public void deberiaDevolverFalseCuandoEstaJustoEnElLimite() {
		Mesa mesa = new Mesa(100,100);
		boolean resultado = mesa.estaEnLosLimites(new Vector(100,100));
		assertFalse(resultado);
	}
}
