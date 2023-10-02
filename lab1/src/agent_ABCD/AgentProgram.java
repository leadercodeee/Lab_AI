package agent_ABCD;

import java.util.Random;

import agent_ABCD.Environment.LocationState;

public class AgentProgram {
	public int getIndex(String direction) {
		if (direction == "LEFT") {
			return 1;
		}
		if (direction == "RIGHT") {
			return 2;
		}
		if (direction == "UP") {
			return 3;
		} else {
			return 4;
		}
	}

	public Action getDynamicAction(int index) {
		if (index == getIndex("LEFT")) {
			return Environment.MOVE_LEFT;
		}
		if (index == getIndex("RIGHT")) {
			return Environment.MOVE_RIGHT;
		}
		if (index == getIndex("UP")) {
			return Environment.MOVE_UP;
		} else {
			return Environment.MOVE_DOWN;
		}
	}

// Lab1_Bai1
	public Action execute(Percept p) {// location, status
		Random random = new Random();
		int score = random.nextInt(4);
		if (p.getLocationState() == LocationState.DIRTY) {
			return Environment.SUCK_DIRT;
		} else {
			return getDynamicAction(score);

		}

	}
}
