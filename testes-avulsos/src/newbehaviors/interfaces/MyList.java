package newbehaviors.interfaces;

public interface MyList {

	static void sort() {
		System.out.println("dentro do sort");
	}
	
	default void remove() {
		System.out.println("dentro do remove");
	}
}
