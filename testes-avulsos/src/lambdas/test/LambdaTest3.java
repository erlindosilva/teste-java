package lambdas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import comportamentoporparametro.classes.Carro;
import comportamentoporparametro.classes.ComparadorCarro;

public class LambdaTest3 {

	public static void main(String[] args) {
		forEach(Arrays.asList("William", "DevDojo", "facebook.com/devdojobr"), System.out::println);
		List<Carro> carros = Arrays.asList(new Carro("Vermelho", 1999), new Carro("Azul", 2005), new Carro("Preto", 1985));
		
//		Collections.sort(carros, new Comparator<Carro>()
//		{
//
//			@Override
//			public int compare(Carro o1, Carro o2) {
//				return o1.getCor().compareTo(o2.getCor());
//			}
//	
//		});
		
		//using lambda
		//Collections.sort(carros, (o1, o2) -> o1.getCor().compareTo(o2.getCor()));
		
		//static method reference
		Collections.sort(carros, ComparadorCarro::comparePorCor);
		
		System.out.println(carros);
	}
	
	public static <T> void forEach(List<T> list, Consumer<T> c)
	{
		for(T e : list)
		{
			c.accept(e);
		}
	}
	
	public static <T,R> List<R> map(List<T> list, Function<T, R> f)
	{
		List<R> result = new ArrayList<>();
		
		for(T e : list)
		{
			result.add(f.apply(e));
		}
		
		return result;
	}

}
