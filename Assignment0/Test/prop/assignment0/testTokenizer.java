package prop.assignment0;

import org.junit.Test;

public class testTokenizer {

	@Test
	public void testTokenizer()
	{
		Tokenizer t = new Tokenizer();
		try
		{
			t.open("C:\\Users\\ntiadmin\\Desktop\\Assignment0-Code\\TESTCHAR.txt");
			t.current();
			System.out.println("Really");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
