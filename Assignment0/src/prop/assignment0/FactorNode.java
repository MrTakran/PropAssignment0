package prop.assignment0;

public class FactorNode implements INode {

	private Lexeme intOrId;
	private ExpressionNode expression;
	
	public FactorNode(Tokenizer t) throws ParserException{
		t.moveNext();
		Lexeme l = t.current();
		if(l.token() != Token.INT_LIT && l.token() != Token.IDENT) {
			if(l.token() != Token.LEFT_PAREN) {
				throw new ParserException("No_Left_Parenthesis");
			}
			t.moveNext();
			try {
				expression = new ExpressionNode(t);
			}
			catch(ParserException pe) {
				throw pe;
			}
			t.moveNext();
			l = t.current();
			if(l.token() != Token.RIGHT_PAREN) {
				throw new ParserException("No_Right_Parenthesis");
			}

		}
		else {
			intOrId = t.current();
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
