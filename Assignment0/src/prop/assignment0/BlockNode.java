package prop.assignment0;

import java.util.ArrayList;

public class BlockNode implements INode {

	private Tokenizer t;
	private StatementsNode statement;
	
	
	public BlockNode(Tokenizer t) throws ParserException {
		boolean buildStatements = true;
		this.t = t;
		Lexeme l = t.current();
		if(l.token() != Token.LEFT_CURLY) {
			throw new ParserException("No left curly brace in begining of block");
		}
		while(buildStatements) {
			
			statement = new StatementsNode(t);
			//fånga något som kollar att det inte går att göra fler statements
				
		}
		l = t.current();
		if(l.token() != Token.RIGHT_CURLY) {
			throw new ParserException("No right curly brace at the end of block");
		}
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		
	}

}
