package streams.tests;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest5GerandoStreams {
	public static void main(String[] args) {
		IntStream.rangeClosed(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
		System.out.println();
		IntStream.range(1, 50).filter(n -> n % 2 == 0).forEach(n -> System.out.print(n + " "));
		System.out.println();
		
		Stream<String> stringStream = Stream.of("William", "DevDojo", "Acessem");
		stringStream.map(String::toUpperCase)
			.forEach(s -> System.out.print(s + " "));
		
		Stream<String> vazio = Stream.empty();
		
		int nums[] = {1,2,3,4,5};
		OptionalDouble avg = Arrays.stream(nums).average();
		System.out.print(avg.getAsDouble());
		
		System.out.println();
		
		try(Stream<String> lines = Files.lines(Paths.get("/home/erlindo.silva/eFiles/irrelevantes/Teste.txt"), Charset.defaultCharset()))
		{
			lines.flatMap(s -> Arrays.stream(s.split("\n")))
				.filter(p -> p.contains("File"))
				.forEach(System.out::println);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		Stream.iterate(1, n -> n + 2).limit(10).forEach(System.out::println);
		
		//Fibonacci
		Stream.iterate(new int[] {0, 1}, a -> new int[] { a[1], a[0] + a[1] } )
			.limit(5)
			.forEach(t -> System.out.println(Arrays.toString(t)));
		
		Stream.iterate(new int[] {0, 1}, a -> new int[] { a[1], a[0] + a[1] } )
		.limit(10)
		.map(a -> a[0])
		.forEach(System.out::println);
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
		ThreadLocalRandom t = ThreadLocalRandom.current();
		Stream.generate(() -> t.nextInt(1, 100)).limit(10).forEach(System.out::println);
	}
}
