package prop.assignment0;

import java.io.IOException;

public class Tokenizer implements ITokenizer {

	private Scanner scanner;

	private int numberValMin = 48;
	private int numberValMax = 57;
	
	private int letterValMin = 97;
	private int letterValMax = 122;
			
	
	public Tokenizer() {
		scanner = new Scanner();
	}

	public void open(String fileName) throws IOException, TokenizerException {
		scanner.open(fileName);
	}

	public Lexeme current() {
		try {
			moveNext();
		} 
		catch (IOException | TokenizerException e) {
			System.out.println(e);
			return new Lexeme(null, Token.NULL);
		}
		char c = scanner.current();
		Token token = findTypeOfToken(c);

		return null;
	}
	
	private Token findTypeOfToken(char c)
	{
		int charValue = c;
		if (charValue >= numberValMin && charValue <= numberValMax)
		{
			return Token.INT_LIT;
		}
		else if (charValue >= letterValMin && charValue <= letterValMax)
		{
			return Token.IDENT;
		}
		switch(c)
		{
			case '':
				
				break;
		}

		return Token.NULL;
	}

	public void moveNext() throws IOException, TokenizerException {
		scanner.moveNext();
	}

	public void close() throws IOException {
		scanner.close();
	}
}