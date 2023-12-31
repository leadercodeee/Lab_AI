package agent_AB;

import agent_AB.Environment.LocationState;

public class AgentProgram {
	private int score;

	public AgentProgram(int score) {
		this.score = 0;
	}

	public int getScore() {
		return score;
	}

	// Lab1_Bai1
	public Action execute(Percept p) {// location, status
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
			return Environment.MOVE_RIGHT;
		} else if (p.getAgentLocation() == Environment.LOCATION_A) {
			return Environment.MOVE_LEFT;
		}
		return NoOpAction.NO_OP;
	}

}
