package prop.assignment0;

import java.util.TreeMap;
import java.util.Set;

public class BlockNode implements INode {

	private StatementsNode statement;
	private Lexeme lCurly;
	private Lexeme rCurly;
	private Lexeme endOfFile;
	
	public BlockNode(Tokenizer t) throws ParserException {
		
		lCurly = t.current();
		if(lCurly.token() != Token.LEFT_CURLY) {
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
		rCurly = t.current();
		if(rCurly.token() != Token.RIGHT_CURLY) {
			throw new ParserException("Right_Curly_Missing");
		}
		t.moveNext();
		endOfFile = t.current();
		if(endOfFile.token() != Token.EOF) {
			throw new ParserException("EOF_Missing");
		}
	}
	@Override
	public Object evaluate(Object[] args) throws Exception {
		StringBuilder sb = new StringBuilder();
		TreeMap<String, Double> valuesMap = new TreeMap<String, Double>();
		statement.evaluate(new Object[] {(Object)valuesMap});
		Set<String> keys = valuesMap.keySet();
		for(String key : keys) {
			sb.append(key + " = " + valuesMap.get(key) +"\n");
		}
		
		return sb.toString();
	}

	@Override
	public void buildString(StringBuilder builder, int tabs) {
		TabInserter.tabber(builder, tabs, "BlockNode");
		TabInserter.tabber(builder, tabs, lCurly.toString());
		statement.buildString(builder, tabs + 1);
		TabInserter.tabber(builder, tabs, rCurly.toString());
	}

}
