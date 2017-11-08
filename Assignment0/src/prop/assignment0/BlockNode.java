package prop.assignment0;


public class BlockNode implements INode {

	private StatementsNode statement;
	
	
	public BlockNode(Tokenizer t) throws ParserException {
		
		Lexeme l = t.current();
		if(l.token() != Token.LEFT_CURLY) {
			throw new ParserException("Left_Curly_Missing");
		}
		t.moveNext();
		try {
			statement = new StatementsNode(t);
		}
		catch(ParserException pe) {
			if(pe.getMessage().equals("No_Id")) {
				statement = null;
			}
			else {
				throw pe;
			}
		}
		l = t.current();
		if(l.token() != Token.RIGHT_CURLY) {
			throw new ParserException("Right_Curly_Missing");
		}
		t.moveNext();
		l = t.current();
		if(l.token() != Token.EOF) {
			throw new ParserException("EOF_Missing");
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
