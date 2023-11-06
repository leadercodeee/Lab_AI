package informSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IPuzzleAlgo {

	@Override
	public Node execute(Puzzle model) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(PuzzleUtils.HeuristicComparatorByH);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			frontier.add(model.getInitialState()); // model.get...
			if (current.getH() == 0) { // getH1 == 0
				return current;
			} else {
				List<Node> children = model.getSuccessors(current); // Sucess...
				for (Node successor : children) {
					if (!frontier.contains(successor) && (!explored.contains(successor))) {
						current.setG(current.getG() + current.getH());
						frontier.add(current);
					}
				}
 
			}
		}
		return null;
	}

}
