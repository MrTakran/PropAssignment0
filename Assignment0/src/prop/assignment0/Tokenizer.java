package prop.assignment0;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.lang.StringBuilder;

public class Tokenizer implements ITokenizer {

	private Scanner scanner;

	private int numberValMin = 48;
	private int numberValMax = 57;

	private int letterValMin = 97;
	private int letterValMax = 122;

	public Tokenizer() {
		scanner = new Scanner();
	}

	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		try
		{
		scanner.open(fileName);
		}
		catch(IOException e)
		{
			throw e;
		}
	}

	@Override
	public Lexeme current() {
		char c = getChar();
		if (c == Scanner.NULL)
		{
			return new Lexeme(c, Token.NULL);
		}
		else if (c == Scanner.EOF)
		{
			return new Lexeme(c, Token.EOF);
		}
		
		Token token = findTypeOfToken(c);
		if (token == Token.INT_LIT || token == Token.IDENT)	
		{
			return getMultipleChars(token, c);
		}
		return new Lexeme(c,token);
	}


	private char getChar() {
		char c = scanner.current();
		while (c == Scanner.NULL) {
			c = scanner.current();
			try {
				moveNext();
			} catch (IOException | TokenizerException e) {
				System.out.println(e);
				return Scanner.NULL;
			}
		} 
		return c;
	}

	private Token findTypeOfToken(char c) {
		int charValue = c;
		if (charValue >= numberValMin && charValue <= numberValMax) {
			return Token.INT_LIT;
		} else if (charValue >= letterValMin && charValue <= letterValMax) {
			return Token.IDENT;
		}
		switch (c) {
		case '{':
			return Token.LEFT_CURLY;
		case '=':
			return Token.ASSIGN_OP;
		case ';':
			return Token.SEMICOLON;
		case '+':
			return Token.ADD_OP;
		case '-':
			return Token.SUB_OP;
		case '*':
			return Token.MULT_OP;
		case '/':
			return Token.DIV_OP;
		case '(':
			return Token.LEFT_PAREN;
		case ')':
			return Token.RIGHT_PAREN;
		case '}':
			return Token.RIGHT_CURLY;
		}
		return Token.NULL;
	}
	
	
	private Lexeme getMultipleChars(Token token, char c)
	{
		StringBuilder sb = new StringBuilder(c);
		boolean addingNumber = token == Token.INT_LIT;
		char nextC;
		while(true)
		{
			try {
				moveNext();
				nextC = scanner.current();
				if (addingNumber && Character.isDigit(nextC) || !addingNumber && Character.isLetter(nextC))
				{
					sb.append(nextC);
				}
				else
				{
					return new Lexeme(sb.toString(),token);
				}
			} catch (IOException | TokenizerException e) {
				System.out.println(e);
				return new Lexeme(sb.toString(),Token.NULL);
			}
		}
		
	}

	@Override
	public void moveNext() throws IOException, TokenizerException {
		try
		{
		scanner.moveNext();
		}
		catch (IOException e)
		{
			throw e;
		}
	}

	@Override
	public void close() throws IOException {
		try
		{
		scanner.close();
		}
		catch (IOException e)
		{
			throw e;
		}
	}
}
