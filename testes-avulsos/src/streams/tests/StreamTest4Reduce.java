package streams.tests;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import streams.classes.Pessoa;

public class StreamTest4Reduce {

	public static void main(String[] args) {
		Optional<Integer> reduce = getStream().reduce((x,y) -> x+y);
		System.out.println(reduce.get());
		
		Integer reduce2 = getStream().reduce(0,(x,y) -> x+y);
		System.out.println(reduce2);
		
		Optional<Integer> reduce3 = getStream().reduce(Integer::sum);
		System.out.println(reduce3.get());
		
		Optional<Integer> mult1 = getStream().reduce((x,y) -> x * y);
		System.out.println(mult1.get());
		
		Integer mult2 = getStream().reduce(1,(x,y) -> x * y);
		System.out.println(mult2);
		
		Integer mult3 = getStream().reduce(2,(x,y) -> x * y);
		System.out.println(mult3);
		
		Integer mult4 = getStream().reduce(0,(x,y) -> x * y);
		System.out.println(mult4);
		
		Optional<Integer> max1 = getStream().reduce((x,y) -> x > y ? x : y);
		System.out.println(max1.get());
		
		Optional<Integer> max2 = getStream().reduce(Integer::max);
		System.out.println(max1.get());
		
		
		Stream<Pessoa> streamPessoa = Pessoa.bancoDeDados().stream();
		Optional<Double> somaSalario = streamPessoa.filter(p -> p.getSalario() > 4000)
				.map(Pessoa::getSalario)
				.reduce(Double::sum);
		System.out.println(somaSalario.get());
		
		streamPessoa = Pessoa.bancoDeDados().stream();
		Double somaDouble = streamPessoa.filter(p -> p.getSalario() > 4000)
				.mapToDouble(Pessoa::getSalario)
				.sum();
		System.out.println(somaDouble);
		
		streamPessoa = Pessoa.bancoDeDados().stream();
		Stream<Double> doubleStream = streamPessoa.filter(p -> p.getSalario() > 4000)
				.mapToDouble(Pessoa::getSalario)
				.boxed();
		
		System.out.println(doubleStream);
		
		streamPessoa = Pessoa.bancoDeDados().stream();
		OptionalDouble maxDouble = streamPessoa
				.mapToDouble(Pessoa::getSalario)
				.max();
		System.out.println(maxDouble.getAsDouble());
	}

	private static Stream<Integer> getStream() {
		return Arrays.asList(1,2,3,4,5,6).stream();
	}

}
