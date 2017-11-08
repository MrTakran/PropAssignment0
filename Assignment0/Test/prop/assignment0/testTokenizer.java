package prop.assignment0;

import org.junit.Test;

public class testTokenizer {

	@Test
	public void testTokenizer()
	{
		System.out.println();
		Tokenizer t = new Tokenizer();
		try
		{
			t.open("C:\\Users\\ntiadmin\\Desktop\\Assignment0-Code\\Assignment0\\src\\program2.txt");
			t.buildLexemes();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
