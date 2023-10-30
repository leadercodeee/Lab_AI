package informedSearch;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class AStarSearchAlgo implements IInformedSearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparableByGnHn());
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
						end.setH(current.getH() + edge.getWeight());
					} else if (frontier.contains(end)) {
						double pathCost = end.getH();
						double newPathCost = current.getH() + edge.getWeight();
						if (pathCost > newPathCost) {
							end.setH(newPathCost);
							end.setParent(current);
						}
						if(frontier.contains(edge)) {
							frontier.remove(edge);
						}
						frontier.add(current);
					}
				}

			}

		}
		return null;
	}
	@Override
	public Node execute(Node root, String start, String goal) {
		PriorityQueue<Node> frontier = new PriorityQueue<Node>(new NodeComparableByGnHn());
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
					if(edge.getBegin().getLabel()==start)
					end.setParent(current);
					if (!frontier.contains(end) && (!explored.contains(end))) {
						frontier.add(end);
						end.setH(current.getH() + edge.getWeight());
					} else if (frontier.contains(end)) {
						double pathCost = end.getH();
						double newPathCost = current.getH() + edge.getWeight();
						if (pathCost > newPathCost) {
							end.setH(newPathCost);
							end.setParent(current);
						}
						if(frontier.contains(edge)) {
							frontier.remove(edge);
						}
						frontier.add(current);
					}
				}

			}

		}
		return null;
	}
	@Override
	public boolean isAdmissibleH(Node root, String goal) {
		// TODO Auto-generated method stub
		return false;
	}



	

}
