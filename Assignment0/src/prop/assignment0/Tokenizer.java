package prop.assignment0;

import java.io.IOException;
import java.lang.StringBuilder;
import java.util.ArrayList;

public class Tokenizer implements ITokenizer {

	private Scanner scanner;

	private int numberValMin = 48;
	private int numberValMax = 57;

	private int letterValMin = 97;
	private int letterValMax = 122;

	private boolean moveToNext = true;
	private ArrayList<Lexeme> allLexemes = new ArrayList<Lexeme>();
	private int currentLexeme = 0;

	public Tokenizer() {
		scanner = new Scanner();
	}

	public void buildLexemes() throws TokenizerException {
		Lexeme lastBuilt = null;
		char c;
		do {
			try {
				eatWhiteSpace();
				c = scanner.current();
			} catch (TokenizerException e) {
				throw e;
			}

			Token token = findTypeOfToken(c);
			if (token == Token.INT_LIT || token == Token.IDENT) {
				lastBuilt = getMultipleChars(token, c);
			} else {
				lastBuilt = new Lexeme(c, token);
			}

			allLexemes.add(lastBuilt);
			if (moveToNext) {
				try {
					scanner.moveNext();
				} catch (IOException e) {
					throw new TokenizerException(e.getMessage());
				}
			} else {
				moveToNext = true;
			}
		} while (lastBuilt != null && lastBuilt.token() != Token.EOF);
	}

	@Override
	public void open(String fileName) throws IOException, TokenizerException {
		try {
			scanner.open(fileName);
		} catch (IOException e) {
			System.out.println(e);
			throw e;
		}
	}

	@Override
	public Lexeme current() {
		if (currentLexeme >= allLexemes.size()) {
			currentLexeme = allLexemes.size() - 1;
		}
		return allLexemes.get(currentLexeme);
	}

	private Token findTypeOfToken(char c) {
		int charValue = c;

		if (charValue >= numberValMin && charValue <= numberValMax) {
			return Token.INT_LIT;
		}

		else if (charValue >= letterValMin && charValue <= letterValMax) {
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
		case Scanner.EOF:
			return Token.EOF;
		}
		return Token.NULL;
	}

	private void eatWhiteSpace() throws TokenizerException {
		while (Character.isWhitespace(scanner.current()) || scanner.current() == Scanner.NULL) {
			try {
				scanner.moveNext();
			} catch (IOException e) {
				throw new TokenizerException(e.getMessage());
			}
		}
	}

	private Lexeme getMultipleChars(Token token, char c) {
		StringBuilder sb = new StringBuilder();
		boolean addingNumber = token == Token.INT_LIT;
		char nextC;
		while (true) {
			try {
				nextC = scanner.current();
				if (addingNumber && Character.isDigit(nextC) || !addingNumber && Character.isLetter(nextC)) {
					sb.append(nextC);
				} else {
					moveToNext = false;
					return new Lexeme(sb.toString(), token);
				}
				scanner.moveNext();
			} catch (IOException e) {
				System.out.println(e);
				return new Lexeme(sb.toString(), Token.NULL);
			}
		}
	}

	@Override
	public void moveNext() {
		currentLexeme++;
	}

	@Override
	public void close() throws IOException {
		try {
			scanner.close();
		} catch (IOException e) {
			throw e;
		}
	}
}
