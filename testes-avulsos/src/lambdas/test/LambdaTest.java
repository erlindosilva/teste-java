package lambdas.test;

import java.util.function.Predicate;

import comportamentoporparametro.classes.Carro;
import comportamentoporparametro.interfaces.CarroPredicate;

public class LambdaTest {

	public static void main(String[] args) {
		
		CarroPredicate carroPredicate = new CarroPredicate() {
			
			@Override
			public boolean test(Carro carro) {
				// TODO Auto-generated method stub
				return carro.getCor().equals("verde");
			}
		};
		
		CarroPredicate carroPredicate2 = (Carro carro) -> carro.getCor().equals("verde");
		Predicate<Carro> carroPredicate3 = (Carro carro) -> carro.getCor().equals("verde");
		
		System.out.println(carroPredicate.test(new Carro("verde", 2012)));
		System.out.println(carroPredicate2.test(new Carro("verde", 2012)));
		
		System.out.println(carroPredicate3.test(new Carro("verde", 2012)));
		
		Runnable runnable = () -> System.out.println("Dentro do runnable");
		runnable.run();
		
		new Thread(runnable).start();
		
		
	}
	
}
