package streams.tests;

import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import streams.classes.Pessoa;

public class StreamTest6Collectors1 {

	public static void main(String[] args) {
		
		List<Pessoa> pessoas = Pessoa.bancoDeDados();
		System.out.println(pessoas.stream().count());
		System.out.println(pessoas.stream().collect(Collectors.counting()));
		
		Optional<Pessoa> max = pessoas.stream().max(Comparator.comparing(Pessoa::getSalario));
		System.out.println(max.get().getSalario());
		Optional<Pessoa> collectMax = pessoas.stream().collect(Collectors.maxBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(collectMax.get().getSalario());
		
		Optional<Pessoa> collectMin = pessoas.stream().collect(Collectors.minBy(Comparator.comparing(Pessoa::getSalario)));
		System.out.println(collectMin.get().getSalario());
		
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).sum());
		System.out.println(pessoas.stream().collect(Collectors.summingDouble(Pessoa::getSalario)));
		
		System.out.println(pessoas.stream().mapToDouble(Pessoa::getSalario).average());
		System.out.println(pessoas.stream().collect(Collectors.averagingDouble(Pessoa::getSalario)));
		
		DoubleSummaryStatistics summaryStatistics = pessoas.stream().collect(Collectors.summarizingDouble(Pessoa::getSalario));
		System.out.println(summaryStatistics);
		
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining()));
		System.out.println(pessoas.stream().map(Pessoa::getNome).collect(Collectors.joining(", ")));
	}

}
