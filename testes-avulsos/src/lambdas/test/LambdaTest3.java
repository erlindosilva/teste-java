package lambdas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

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
		//Collections.sort(carros, ComparadorCarro::comparePorCor);
		
		//instance method reference
		ComparadorCarro comparadorCarro = new ComparadorCarro();
		Collections.sort(carros, comparadorCarro::comparePorAno);
		
		System.out.println(carros);
		
		List<String> nomes = Arrays.asList("William", "DevDojo","Anna","Brennon");
		
		//nomes.sort((s1,s2) -> s1.compareTo(s2));
		nomes.sort(String::compareTo);
		
		System.out.println(nomes);
		
		//Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger = Integer::parseInt;
		System.out.println(stringToInteger.apply("10"));
		
		//BiPredicate<List<String>, String> contains = (lista, elemento) -> lista.contains(elemento);
		BiPredicate<List<String>, String> contains = List::contains;
		System.out.println(contains.test(nomes, "William"));
		
		
		//constructor method reference
		Supplier<ComparadorCarro> comparadorCarroSupplier = ComparadorCarro::new;
		Collections.sort(carros, comparadorCarroSupplier.get()::comparePorAno);
		
		System.out.println(carros);
		
		//BiFunction<String,Integer,Carro> carroBiFunction = (s,i) -> new Carro(s,i);
		BiFunction<String,Integer,Carro> carroBiFunction = Carro::new;
		System.out.println(carroBiFunction.apply("Preto", 2000));
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
