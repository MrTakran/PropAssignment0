package prop.assignment0;

public class ExpressionNode implements INode {
	
	private TermNode term;
	private ExpressionNode expression;
	
	public ExpressionNode(Tokenizer t) throws ParserException {
		try {
			term = new TermNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		t.moveNext();
		Lexeme l = t.current();
		if(l.token() == Token.ADD_OP || l.token() == Token.SUB_OP) {
			t.moveNext();
			try {
				expression = new ExpressionNode(t);
			}
			catch(ParserException pe) {
				throw pe;
			}
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
