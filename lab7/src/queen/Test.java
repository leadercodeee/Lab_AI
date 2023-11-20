package queen;

public class Test {
	public static void main(String[] args) {
		GA_NQueenAlgo GA = new GA_NQueenAlgo();
		Node result = new Node();
		
		System.out.println("-------------reproduce--------------------");
		//Testing for reproduce
		Node x = new Node();
		x.displayBoard();

		Node y = new Node();
		y.displayBoard();

		GA.reproduce(x, y);
		
		//Testing for matate()
		System.out.println("----Matate----");
		GA.mutate(result);
		result.displayBoard();
		
		//Testing for method getParentByTournamentSelection()
		System.out.println("------------getParentByTournamentSelection----------------");
		GA.initPopulation();
		result = new Node(GA.getParentByTournamentSelection());
		result.displayBoard();
		System.out.println(" index H : =" + result.getH());
		
		//Testing for method getParentByRandomSelection()
		System.out.println("------------getParentByRandomSelection--------------------");
		result = new Node(GA.getParentByRandomSelection());
		result.displayBoard();
		
		//Testing for method excute()
		System.out.println("------------------excute-----------------------------------");
		result = new Node(GA.execute());
		result.displayBoard();
		

	}

}
