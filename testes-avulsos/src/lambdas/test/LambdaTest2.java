package lambdas.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

import comportamentoporparametro.classes.Carro;

public class LambdaTest2 {

	public static void main(String[] args) {
		
		forEach(Arrays.asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> System.out.println(s));
		List<Integer> list = map(Arrays.asList("William", "DevDojo", "facebook.com/devdojobr"), (String s) -> s.length());
		System.out.println(list);
		
		List<String> listCores = map(Arrays.asList(new Carro("Preto", 2011), new Carro("Preto", 2011), new Carro("Preto", 2011)), (Carro c) -> c.getCor());
		System.out.println(listCores);
		
		Predicate<Integer> pares = (Integer i) -> i % 2 == 0;
		IntPredicate impares = (int i) -> i % 2 == 1;
		System.out.println(pares.test(1000));
		System.out.println(impares.test(1000));
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
