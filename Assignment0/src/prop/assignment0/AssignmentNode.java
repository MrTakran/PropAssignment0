package prop.assignment0;

public class AssignmentNode implements INode {

	private ExpressionNode expression;
	
	public AssignmentNode(Tokenizer t) throws ParserException{
		t.moveNext();
		Lexeme l = t.current();
		if(l.token() != Token.IDENT) {
			throw new ParserException("No_Id");
		}
		t.moveNext();
		l = t.current();
		if(l.token() != Token.ASSIGN_OP) {
			throw new ParserException("Assign_Operator_Missing");
		}
		t.moveNext();
		l = t.current();
		try {
			expression = new ExpressionNode(t);
		}
		catch(ParserException pe) {
			throw pe;
		}
		t.moveNext();
		l = t.current();
		if(l.token() != Token.SEMICOLON) {
			throw new ParserException("No_Semicolon");
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
