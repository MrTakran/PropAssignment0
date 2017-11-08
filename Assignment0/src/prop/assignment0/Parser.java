package prop.assignment0;

import java.io.IOException;

public class Parser implements IParser {
	
	private Tokenizer t = new Tokenizer();

	@Override
	public void open(String fileName) throws IOException, TokenizerException
	{
		t.open(fileName);
	}
	@Override
	public INode parse() throws IOException, TokenizerException, ParserException
	{
		try
		{
			t.buildLexemes();
			return new BlockNode(t);
		}
		catch (Exception e)
		{
			throw e;
		}
	}
	@Override
	public void close() throws IOException 
	{
		t.close();
	}
}
