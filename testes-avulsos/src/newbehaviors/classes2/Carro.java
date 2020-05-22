package newbehaviors.classes2;

public class Carro {

	private Seguradora seguradora;
	private String nome;
	public Seguradora getSeguradora() {
		return seguradora;
	}
	public void setSeguradora(Seguradora seguradora) {
		this.seguradora = seguradora;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNomeSeguradora(Pessoa p)
	{
		if(p != null)
		{
			Carro carro = p.getCarro();
			if(carro != null) {
				Seguradora s = carro.getSeguradora();
				if(s != null)
				{
					return s.getNome();
				}
			}
		}
		return "";
	}
}
