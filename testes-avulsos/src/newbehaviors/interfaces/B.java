package newbehaviors.interfaces;

public interface B {
	
	default void oi() {
		System.out.println("Dentro de oi do B");
	}

}
