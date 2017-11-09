package prop.assignment0;

public class FactorNode implements INode {

	private Lexeme intOrId;
	private Lexeme lParen;
	private Lexeme rParen;
	private ExpressionNode expression;
	private boolean hasIntOrId = false;
	
	
	public FactorNode(Tokenizer t) throws ParserException{
		t.moveNext();
		intOrId = t.current();
		if(intOrId.token() != Token.INT_LIT && intOrId.token() != Token.IDENT) {
			if(intOrId.token() != Token.LEFT_PAREN) {
				System.out.println(intOrId.toString());
				throw new ParserException("No_Left_Parenthesis");
			}
			lParen = intOrId;
			try {
				expression = new ExpressionNode(t);
			}
			catch(ParserException pe) {
				throw pe;
			}
			//t.moveNext();
			rParen = t.current();
			if(rParen.token() != Token.RIGHT_PAREN) {
				throw new ParserException("No_Right_Parenthesis");
			}
		}
		else {
			hasIntOrId = true;
			intOrId = t.current();
		}
				
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		
		return null;
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "FactorNode");
		if(hasIntOrId) {
			TabInserter.tabber(builder, tabs + 1, intOrId.toString());
		}
		else {
			TabInserter.tabber(builder, tabs + 1, lParen.toString());
			expression.buildString(builder, tabs + 1);
			TabInserter.tabber(builder, tabs + 1, rParen.toString());
		}
		
		
	}

}
