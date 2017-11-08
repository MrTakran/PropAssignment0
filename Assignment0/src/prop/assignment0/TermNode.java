package prop.assignment0;

public class TermNode implements INode {

	private FactorNode factor;
	private Lexeme multOrDiv;
	private TermNode term;
	
	public TermNode(Tokenizer t) throws ParserException {
		try {
			factor = new FactorNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		t.moveNext();
		multOrDiv = t.current();
		if(multOrDiv.token() == Token.MULT_OP || multOrDiv.token() == Token.DIV_OP) {
			t.moveNext();
			try {
				term = new TermNode(t);
			}
			catch(ParserException pe){
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
