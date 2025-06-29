import static org.junit.Assert.*;

import org.junit.Test;

public class assertionsTest {

	@Test
	public void test() {
		assertions obj = new assertions();
		int res = obj.square(5);
		
		assertEquals(25, res);
		
		assertTrue(30 > res);
		
		assertFalse(15 > res);
		
		assertNull(null);
		
		assertNotNull(obj);
	}

}
