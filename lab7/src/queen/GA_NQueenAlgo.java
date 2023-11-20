package queen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GA_NQueenAlgo {
	public static final int POP_SIZE = 100;// Population size
	public static final double MUTATION_RATE = 0.03;
	public static final int MAX_ITERATIONS = 1000;
	List<Node> population = new ArrayList<Node>();
	Random rd = new Random();

	// initialize the individuals of the population
	public void initPopulation() {
		for (int i = 0; i < POP_SIZE; i++) {
			Node ni = new Node();
			ni.generateBoard();
			population.add(ni);
		}
	}

	public Node execute() {
		List<Node> new_population = new ArrayList<Node>();
		Node result = new Node();
		for (int i = 0; i < POP_SIZE; i++) {
			for (int j = 0; j < MAX_ITERATIONS; j++) {
				Node x = getParentByTournamentSelection();
				Node y = getParentByTournamentSelection();
				Node child = reproduce(x, y);
				if(child.getH()==0) {
					return child;
				}
				new_population.add(child);
			}
			Collections.sort(new_population);
			if(new_population.get(0).getH() < this.population.get(0).getH()) {
				result = new Node(new_population.get(0));
				this.population = new_population;
			}
		}
		return result;
	}

	// Mutate an individual by selecting a random Queen and
	// move it to a random row.
	public void mutate(Node node) {
		int i = rd.nextInt(Node.N);
		int r = rd.nextInt(Node.N);
		node.setRow(i, r);
	}

//Crossover x and y to reproduce a child
	public Node reproduce(Node x, Node y) {
		int c = rd.nextInt(Node.N);
		Node result = new Node();
		result.generateBoard();
		for (int i = 0; i < c; i++) {
			if( i <= c) { 
				result.setRow(i, x.getRow(i));
			}else {
				result.setRow(i, y.getRow(i));
			}
			
		}

		return result;
	}

//Select K individuals from the population at random and 
//select the best out of these to become a parent.
	public Node getParentByTournamentSelection() {
		Node result = new Node(getParentByRandomSelection());
		  for (int i = 1; i < 3; i++) {
			  Node temp = new Node(getParentByRandomSelection());
			  if(temp.getH() < result.getH()) {
				  result = new Node(temp);
			  }
			
		}

		return result;
	}

//Select a random parent from the population
	public Node getParentByRandomSelection() {
		int randomIndex = rd.nextInt(POP_SIZE);
		return this.population.get(randomIndex);
	}
}
