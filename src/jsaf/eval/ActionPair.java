package jsaf.eval;

public class ActionPair {
	private final String move, fight;
	public ActionPair(String move, String fight) {
		this.move = move;
		this.fight = fight;
	}
	
	public String getMove() {
		return move;
	}
	
	public String getFight() {
		return fight;
	}
	
}