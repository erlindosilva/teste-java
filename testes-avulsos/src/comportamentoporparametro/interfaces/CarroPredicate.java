package comportamentoporparametro.interfaces;

import comportamentoporparametro.classes.Carro;

@FunctionalInterface
public interface CarroPredicate {
	boolean test(Carro carro);
}
