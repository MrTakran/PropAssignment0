package prop.assignment0;

public class StatementsNode implements INode {

	private StatementsNode statement;
	private AssignmentNode assignment;
	public StatementsNode(Tokenizer t) throws ParserException {
		
		
		boolean buildStatements = true;
		
		try {
			assignment = new AssignmentNode(t);
			t.moveNext();
		}
		catch(ParserException pe) {
			throw pe;
		}
		try {
			 statement = new StatementsNode(t);
		}
		catch(ParserException pe){
			if(pe.getMessage().equals("No_Id")) {
				statement = null;
			}
			else {
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
