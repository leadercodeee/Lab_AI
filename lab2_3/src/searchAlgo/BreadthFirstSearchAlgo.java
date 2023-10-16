package searchAlgo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BreadthFirstSearchAlgo implements ISearchAlgo {
	@Override
	public Node execute(Node root, String goal) {
		Queue<Node> fronteir = new LinkedList<Node>();
		fronteir.add(root);
		List<Node> expand = new ArrayList<Node>();
		while (!fronteir.isEmpty()) {
			Node current = fronteir.poll();
			expand.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = new ArrayList<Edge>();
				for (Edge edge : children) {
					if (edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					if (!fronteir.contains(edge.getEnd()) && (!expand.contains(edge.getEnd()))) {
						fronteir.add(edge.getEnd());
					}
				}
			}

		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Queue<Node> fronteir = new LinkedList<Node>();
		fronteir.add(root);
		List<Node> expand = new ArrayList<Node>();
		while (!fronteir.isEmpty()) {
			Node current = fronteir.poll();
			expand.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = new ArrayList<Edge>();
				for (Edge edge : children) {
					if (edge.getEnd().getLabel() == start) {
						edge.getEnd().setParent(null);
					} else {
						edge.getEnd().setParent(current);
					}
					if (!fronteir.contains(edge.getEnd()) && (!expand.contains(edge.getEnd()))) {
						fronteir.add(edge.getEnd());
					}
				}
			}

		}
		return null;

	}

	@Override
	public Node executeTree(Node root, String goal) {
		Queue<Node> fronteir = new LinkedList<Node>();
		fronteir.add(root);
		while (!fronteir.isEmpty()) {
			Node current = fronteir.poll();
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = new ArrayList<Edge>();
				for (Edge edge : children) {
					if (edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}

					fronteir.add(edge.getEnd());
				}
			}
		}
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		Queue<Node> fronteir = new LinkedList<Node>();
		fronteir.add(root);
		while (!fronteir.isEmpty()) {
			Node current = fronteir.poll();
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = new ArrayList<Edge>();
				for (Edge edge : children) {
					if (edge.getEnd().getLabel() == start) {
						edge.getEnd().setParent(null);
					} else {
						edge.getEnd().setParent(current);
					}
					fronteir.add(edge.getEnd());
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String goal, int limitedDepth) {
		// TODO Auto-generated method stub
		return null;
	}
}
