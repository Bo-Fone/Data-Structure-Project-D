
public class ProjectDTester {

	public static void main(String[] args) {
		HeadTailListInterface<Integer> list = new LinkedHeadTailList<>();
		
		// un-comment this line and comment the line above to test the extra credit
		// NOTE: for the extra credit, all lines should match exactly!
		//HeadTailListInterface<Integer> list = new ListHeadTailList<Integer>();
		
		
		// test isEmpty
		System.out.println("********TESTING ISEMPTY AND EMPTY DISPLAY");
		System.out.println("true\n" + list.isEmpty());
		System.out.println();
		System.out.println("[]");
		list.display();
		System.out.println();
		
		// test addFront to empty
		System.out.println("\n\n********TESTING ADD TO FRONT");

		list.addFront(2);
		System.out.println("[2]	head=2	tail=2");
		list.display();
		System.out.println();
		
		
		// test addFront to not empty
		list.addFront(4);
		list.addFront(3);
		System.out.println("[3, 4, 2]	head=3	tail=2");
		list.display();
		System.out.println();
		
		System.out.println("false\n" + list.isEmpty());
		System.out.println();
	
		System.out.println("\n\n********TESTING CLEAR");
		// test clear
		list.clear();
		System.out.println("[]");
		list.display();
		System.out.println();
		
		System.out.println("\n\n********TESTING ADD TO BACK");
		// test addBack to empty
		list.addBack(7);
		System.out.println("[7]	head=7	tail=7");
		list.display();
		System.out.println();
		
		// test addBack to non empty
		list.addBack(10);
		list.addBack(5);
		System.out.println("[7, 10, 5]	head=7	tail=5");
		list.display();
		System.out.println();
		
		System.out.println("\n\n********TESTING CONTAINS");
		// test contains
		System.out.println("2\n"+list.contains(5));
		System.out.println();
		System.out.println("0\n"+list.contains(7));
		System.out.println();
		System.out.println("-1\n"+list.contains(4));
		System.out.println();
		
		
		System.out.println("\n\n********TESTING SIZE");
		// test size
		list.clear();
		for(int i=0; i<32; i++) {
			list.addBack(i);
		}

		System.out.println("32\n" + list.size());
		System.out.println();
		
		System.out.println("\n********TESTING GET ENTRY");
		// test getEntry
		System.out.println("15\n"+list.getEntry(15));
		System.out.println();
		System.out.println("0\n"+list.getEntry(0));
		System.out.println();
		System.out.println("null\n"+list.getEntry(35));
		System.out.println();
		System.out.println("null\n"+list.getEntry(-1));
		System.out.println();
		
		System.out.println("\n\n********TESTING REMOVES");
		// test removes from nonEmpty
		System.out.println("0\n"+list.removeFront());
		System.out.println();
		System.out.println("31\n"+list.removeBack());
		System.out.println();
		System.out.println("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30]	head=1	tail=30");
		list.display();
		System.out.println();
		
		// test removes from empty
		list.clear();
		System.out.println("null\n"+list.removeFront());
		System.out.println();
		System.out.println("null\n"+list.removeBack());
		System.out.println();
		
		// final test of mixed adds and removes
		list.addFront(3);
		list.addBack(2);
		list.addFront(4);
		list.addFront(5);
		list.addBack(3);
		list.addBack(8);
		list.addBack(9);
		list.display();
		System.out.println("[5, 4, 3, 2, 3, 8, 9]\thead=5\ttail=9");
		System.out.println();
	
		list.removeFront();
		list.removeBack();
		list.display();
		System.out.println("[4, 3, 2, 3, 8]\thead=4\ttail=8");
		System.out.println();
		
		System.out.println("********TESTING WITH STRINGS");
		HeadTailListInterface<String> wordList = new LinkedHeadTail<String>();
		wordList.addFront("job!");
		wordList.addFront("Nice");
		wordList.addFront("it!");
		wordList.addFront("did");
		wordList.addFront("You");
		wordList.display();
		System.out.println("[You, did, it!, Nice, job!]\thead=You\ttail=job!");
		System.out.println();
		
		
	
	}

}
