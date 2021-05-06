package jbdc;

public class Pessoa {

	private int idPessoa;
	private String nome;

	public Pessoa() {
		// TODO Auto-generated constructor stub
	}
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}
	
	

	public Pessoa(int idPessoa, String nome) {
		super();
		this.idPessoa = idPessoa;
		this.nome = nome;
	}

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return idPessoa + "-" + nome;
	}

}
