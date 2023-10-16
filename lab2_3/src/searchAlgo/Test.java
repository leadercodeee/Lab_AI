package searchAlgo;

public class Test {
	public static void main(String[] args) {
		Node nodeS = new Node("S");
		Node nodeA = new Node("A");
		Node nodeB = new Node("B");
		Node nodeC = new Node("C");
		Node nodeD = new Node("D");
		Node nodeE = new Node("E");
		Node nodeF = new Node("F");
		Node nodeG = new Node("G");
		Node nodeH = new Node("H");
		nodeS.addEdge(nodeA, 5);
		nodeS.addEdge(nodeB, 2);
		nodeS.addEdge(nodeC, 4);
		nodeA.addEdge(nodeD, 9);
		nodeA.addEdge(nodeE, 4);
		nodeB.addEdge(nodeG, 6);
		nodeC.addEdge(nodeF, 2);
		nodeD.addEdge(nodeH, 7);
		nodeE.addEdge(nodeG, 6);
		nodeF.addEdge(nodeG, 1);
		System.out.println("Graph search ");
		ISearchAlgo algo1 = new BreadthFirstSearchAlgo();
		Node result = algo1.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result));
		System.out.println("------------------------------");
		ISearchAlgo algo2 = new BreadthFirstSearchAlgo();
		Node result2 = algo2.execute(nodeS, "S", "G");
		System.out.println(NodeUtils.printPath(result2));
		System.out.println("------------------------------");
		
		ISearchAlgo algo5 = new DepthFirstSearchAlgo();
		Node result5 = algo5.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result5));
		System.out.println("------------------------------");
		ISearchAlgo algo6 = new DepthFirstSearchAlgo();
		Node result6 = algo6.execute(nodeS, "S", "G");
		System.out.println(NodeUtils.printPath(result6));
		System.out.println("------------------------------");
		
		System.out.println("Tree Search");

		ISearchAlgo algo3 = new BreadthFirstSearchAlgo();
		Node result3 = algo3.executeTree(nodeS,"G");
		System.out.println(NodeUtils.printPath(result3));
		System.out.println("------------------------------");
		ISearchAlgo algo4 = new BreadthFirstSearchAlgo();
		Node result4 = algo4.executeTree(nodeS, "S", "G");
		System.out.println(NodeUtils.printPath(result4));
		System.out.println("------------------------------");

		ISearchAlgo algo7 = new DepthFirstSearchAlgo();
		Node result7 = algo7.executeTree(nodeS, "G");
		System.out.println(NodeUtils.printPath(result7));
		System.out.println("------------------------------");
		ISearchAlgo algo8 = new UniformCostSearchAlgo();
		Node result8 = algo8.execute(nodeS, "S", "G");
		System.out.println(NodeUtils.printPath(result8));
		System.out.println("------------------------------");
		
		System.out.println("UniformCostSearch");

		ISearchAlgo algo9 = new UniformCostSearchAlgo();
		Node result9 = algo9.execute(nodeS, "G");
		System.out.println(NodeUtils.printPath(result9));
		System.out.println("------------------------------");

		ISearchAlgo algo10 = new UniformCostSearchAlgo();
		Node result10 = algo10.execute(nodeS, "S", "G");
		System.out.println(NodeUtils.printPath(result10));
		System.out.println("Path cost: " + result10.getPathCost());
		System.out.println("------------------------------");

	}

}
