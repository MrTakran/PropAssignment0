package prop.assignment0;

public final class TabInserter {

	private TabInserter() {}
	static public void tabber(StringBuilder builder, int tabs, String text){
		for(int i = 0; i < tabs; i++) {
			builder.append("\t");
			
		}
		builder.append(text + "\n");
		
	}
}
