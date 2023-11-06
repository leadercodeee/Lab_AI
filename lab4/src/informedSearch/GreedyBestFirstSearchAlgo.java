package informedSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GreedyBestFirstSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			frontier.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				for (Edge edge : children) {
					Node end = edge.getEnd();
					end.setParent(current);
					if (!frontier.contains(end) && (!explored.contains(end))) {
						frontier.add(end);
						end.setG(current.getG() + edge.getWeight());
					} else if (frontier.contains(end)) {
						double pathCost = end.getH();
						double newPathCost = current.getG() + edge.getWeight();
						if (pathCost > newPathCost) {
							end.setG(newPathCost);
							end.setParent(current);

						}
					}
				}

			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparatorByGn());
		frontier.add(root);
		List<Node> explored = new ArrayList<Node>();
		while (!frontier.isEmpty()) {
			Node current = frontier.poll();
			frontier.add(current); // model.get...
			if (current.getLabel().contains(goal)) { // getH1 ==0
				return current;
			} else {
				List<Edge> children = current.getChildren(); // Sucess...
				for (Edge edge : children) {
					Node end = edge.getEnd();
					if (edge.getEnd().getLabel() == start) {
						end.setParent(current);
						if (!frontier.contains(end) && (!explored.contains(end))) {
							frontier.add(end);
							end.setG(current.getG() + edge.getWeight());//+1
						} else if (frontier.contains(end)) {
							double pathCost = end.getH();
							double newPathCost = current.getG() + edge.getWeight();
							if (pathCost > newPathCost) {
								end.setG(newPathCost);
								end.setParent(current);

							}
						}
					}

				}

			}
		}
		return null;
	}
	
}
