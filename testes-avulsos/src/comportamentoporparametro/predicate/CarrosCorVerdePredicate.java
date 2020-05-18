package comportamentoporparametro.predicate;

import comportamentoporparametro.classes.Carro;
import comportamentoporparametro.interfaces.CarroPredicate;

public class CarrosCorVerdePredicate implements CarroPredicate {

	@Override
	public boolean test(Carro carro) {
		return (carro.getCor().equals("verde"));
	}

	
	
}
