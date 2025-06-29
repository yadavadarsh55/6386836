import static org.junit.Assert.*;

import org.junit.Test;

public class additionTest {

	@Test
	public void test() {
		addition a = new addition();
		int res = a.add(2, 3);
		
		assertEquals(5, res);
	}

}
