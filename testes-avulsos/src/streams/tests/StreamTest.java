package streams.tests;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import streams.classes.Pessoa;

public class StreamTest {

	public static void main(String[] args) {
		//Pegar os 3 primeiros nomes das pessoas com menos de 25 anos
		//Ordenados por nome
		List<Pessoa> pessoas = Pessoa.bancoDeDados();
		
		//ordenar
		System.out.println(pessoas);
		List<Pessoa> pessoas1 = pessoas.stream().sorted(Comparator.comparing(Pessoa::getNome))
			.collect(Collectors.toList());
		System.out.println(pessoas1);
		
		//filtrar, ordenar, limitar
		List<String> nomes = pessoas.stream()
				.filter(p -> p.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.map(Pessoa::getNome)
				.collect(Collectors.toList());
		System.out.println(nomes);
		
		//filtrar, ordenar, limitar
		List<Pessoa> pessoas2 = pessoas.stream()
				.filter(p -> p.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.collect(Collectors.toList());
		
		System.out.println(pessoas2);
		
		//filtrar, ordenar, limitar
		List<Pessoa> pessoas3 = pessoas.stream()
				.filter(p -> p.getIdade() < 25)
				.sorted(Comparator.comparing(Pessoa::getNome))
				.limit(3)
				.skip(1)
				.collect(Collectors.toList());
		
		System.out.println("com skip = " + pessoas3);
		
		//contar
		System.out.println(pessoas.stream()
				.filter(p -> p.getIdade() < 25)
				.count());
		
		//contar distintivamente
		System.out.println(pessoas.stream()
				.distinct()
				.filter(p -> p.getIdade() < 25)
				.count());
		
		//iterar na lista
		pessoas.stream().forEach(System.out::println);
	}

}
