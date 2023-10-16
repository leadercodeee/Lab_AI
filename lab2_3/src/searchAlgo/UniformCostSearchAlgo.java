package searchAlgo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class UniformCostSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
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
						end.setPathCost(current.getPathCost() + edge.getWeight());
					} else if (frontier.contains(end)) {
						double pathCost = end.getPathCost();
						double newPathCost = current.getPathCost() + edge.getWeight();
						if (pathCost > newPathCost) {
							end.setPathCost(newPathCost);
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
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparator());
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
					if (edge.getEnd().getLabel() == start) {
						end.setParent(null);
					} else {
						end.setParent(current);
					}
					if (!frontier.contains(end) && (!explored.contains(end))) {
						frontier.add(end);
						end.setPathCost(current.getPathCost() + edge.getWeight());
					} else if (frontier.contains(end)) {
						double pathCost = end.getPathCost();
						double newPathCost = current.getPathCost() + edge.getWeight();
						if (pathCost > newPathCost) {
							end.setPathCost(newPathCost);
							end.setParent(current);

						}
					}
				}

			}

		}
		return null;

	}

	@Override
	public Node executeTree(Node root, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}

}
