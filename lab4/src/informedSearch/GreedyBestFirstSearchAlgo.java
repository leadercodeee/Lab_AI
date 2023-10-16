package informedSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		frontier.add(root);
		List<Node> expand = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			expand.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = new ArrayList<Edge>();
				for (Edge edge : children) {
					if (edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					if (!frontier.contains(edge.getEnd()) && (!expand.contains(edge.getEnd()))) {
						frontier.add(edge.getEnd());
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

}
