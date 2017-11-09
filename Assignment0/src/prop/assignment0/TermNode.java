package prop.assignment0;

public class TermNode implements INode {

	private FactorNode factor;
	private Lexeme multOrDiv;
	private TermNode term;
	private boolean hasMultOrDiv = true;
	
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
			
			try {
				term = new TermNode(t);
			}
			catch(ParserException pe){
				throw pe;
			}
			
		}
		else {
			hasMultOrDiv = false;
		}
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "TermNode");
		factor.buildString(builder, tabs + 1);
		if(hasMultOrDiv) {
			TabInserter.tabber(builder, tabs + 1, multOrDiv.toString());
			term.buildString(builder, tabs + 1);
		}
	}

}
