package comportamentoporparametro.predicate;

import java.util.Calendar;

import comportamentoporparametro.classes.Carro;
import comportamentoporparametro.interfaces.CarroPredicate;

public class CarrosDezAnosRecentePredicate implements CarroPredicate {

	@Override
	public boolean test(Carro carro) {
		return (carro.getAno() > (Calendar.getInstance().get(Calendar.YEAR) - 10));
	}

}
