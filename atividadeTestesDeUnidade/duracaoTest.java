package atividadeTestesDeUnidade;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class duracaoTest {
	Torneio jogo = new Torneio();

	@Test
	public void test1() {
		int primeiro = jogo.duracaoJogo(13, 00, 13, 30);
		assertEquals(30,primeiro);
	}
	@Test
	public void test2() {
		int segundo = jogo.duracaoJogo(18, 00, 18, 00);
		assertEquals(1440,segundo);
	}
	@Test
	public void test3() {
		int terceiro = jogo.duracaoJogo(7,8,9,10);
		assertEquals(122,terceiro);
	}


}
