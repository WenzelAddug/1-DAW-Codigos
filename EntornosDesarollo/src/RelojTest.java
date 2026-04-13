import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RelojTest {

	@Test
	void testMostrarFormato24ConCeros() {
		Reloj r = new Reloj(1, 2, 3);
		assertEquals("01:02:03", r.mostrar());
	}

	@Test
	void testMostrarFormato24HoraNormal() {
		Reloj r = new Reloj(22, 30, 23);
		assertEquals("22:30:23", r.mostrar());
	}

	@Test
	void testMostrarFormato12AM() {
		Reloj r = new Reloj(10, 30, 23);
		r.cambiarFormato24(false);
		assertEquals("10:30:23 am", r.mostrar());
	}

	@Test
	void testMostrarFormato12PM() {
		Reloj r = new Reloj(22, 30, 23);
		r.cambiarFormato24(false);
		assertEquals("10:30:23 pm", r.mostrar());
	}

	@Test
	void testCambiarFormato24VolverA24h() {
		Reloj r = new Reloj(22, 30, 23);

		r.cambiarFormato24(false);
		assertEquals("10:30:23 pm", r.mostrar());

		r.cambiarFormato24(true);
		assertEquals("22:30:23", r.mostrar());
	}

	@Test
	void testTictacIncrementaUnSegundo() {
		Reloj r = new Reloj(0, 0, 0);
		r.tictac();
		assertEquals("00:00:01", r.mostrar());
	}

	@Test
	void testTictacCambiaMinuto() {
		Reloj r = new Reloj(12, 0, 59);
		r.tictac();
		assertEquals("12:01:00", r.mostrar());
	}

	@Test
	void testTictacCambiaHora() {
		Reloj r = new Reloj(12, 59, 59);
		r.tictac();
		assertEquals("13:00:00", r.mostrar());
	}

	@Test
	void testTictacCambioDeDia() {
		Reloj r = new Reloj(23, 59, 59);
		r.tictac();
		assertEquals("00:00:00", r.mostrar());
	}

	@Test
	void testComparar() {
		Reloj r1 = new Reloj(1, 0, 0);
		Reloj r2 = new Reloj(0, 59, 0);

		assertEquals(60, r1.comparar(r2));
		assertEquals(-60, r2.comparar(r1));
		assertEquals(0, r1.comparar(new Reloj(1, 0, 0)));
	}
}
