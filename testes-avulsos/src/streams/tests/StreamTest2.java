package streams.tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static java.util.Arrays.asList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest2 {

	public static void main(String[] args) {
		List<List<String>> nomes = new ArrayList<>();
		nomes.add(asList("DevDojo", "Valeu por aumentar a letra"));
		nomes.add(asList("William", "pq vc demorou 180 aulas para isso?"));
		System.out.println(nomes);
		
		//System.out.println(nomes.stream().flatMap(l->l.stream()));
		Stream<String> stringStream = nomes.stream().flatMap(Collection::stream);
		stringStream.forEach(System.out::println);
		
		List<String> listString = nomes.stream().flatMap(Collection::stream)
				.collect(Collectors.toList());
		System.out.println(listString);
		
		List<String> palavras = asList("Ola", "Goku");
		String[] split = palavras.get(0).split("");
		System.out.println(Arrays.toString(split));
		
		List<String[]> collect1 = palavras.stream().map(p->p.split("")).collect(Collectors.toList());
		Stream<String> stream = Arrays.stream((String[]) palavras.toArray());
		System.out.println(collect1);
		System.out.println(stream);
		
		List<String> collect2 = palavras.stream()   //Stream<String>
				.map(p->p.split(""))				//Stream<String[]>
				.flatMap(Arrays::stream)			//Stream<String>
				.collect(Collectors.toList());
		System.out.println(collect2);
	}

}
