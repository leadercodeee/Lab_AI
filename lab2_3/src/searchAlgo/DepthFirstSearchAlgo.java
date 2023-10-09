package searchAlgo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearchAlgo implements ISearchAlgo {

	@Override
	public Node execute(Node root, String goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		List<Node> expand = new ArrayList<Node>();
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			expand.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				List<Edge> copy = new ArrayList<Edge>(children);
				Collections.reverse(copy);
				for (Edge edge : copy) {
					if (edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					if (!stack.contains(edge.getEnd()) && !expand.contains(edge.getEnd()))
						;
					stack.push(edge.getEnd());
				}
			}
		}
		return null;
	}

	@Override
	public Node execute(Node root, String start, String goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		List<Node> expand = new ArrayList<Node>();
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			expand.add(current);
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				List<Edge> copy = new ArrayList<Edge>(children);
				Collections.reverse(copy);
				for (Edge edge : children) {
					if (edge.getEnd().getLabel() == start) {
						edge.getEnd().setParent(null);
					} else {
						edge.getEnd().setParent(current);
					}
					if (!stack.contains(edge.getEnd()) && !expand.contains(edge.getEnd()))
						;
					stack.push(edge.getEnd());
				}
			}
		}
		return null;

	}

	@Override
	public Node executeTree(Node root, String goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				List<Edge> copy = new ArrayList<Edge>(children);
				Collections.reverse(copy);
				for (Edge edge : copy) {
					if (edge.getEnd().getParent() == null) {
						edge.getEnd().setParent(current);
					}
					stack.push(edge.getEnd());
				}
			}
		}
		return null;
	}

	@Override
	public Node executeTree(Node root, String start, String goal) {
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current.getLabel().contains(goal)) {
				return current;
			} else {
				List<Edge> children = current.getChildren();
				List<Edge> copy = new ArrayList<Edge>(children);
				Collections.reverse(copy);
				for (Edge edge : children) {
					if (edge.getEnd().getLabel() == start) {
						edge.getEnd().setParent(null);
					} else {
						edge.getEnd().setParent(current);
					}
					stack.push(edge.getEnd());
				}
			}
		}
		return null;
	}
}
