package modelo;

public class Contato { 
	
	private String nome;
	private String telefoneCelular;
	private String telefoneResidencial;
	private String email;
	private String dataNascimento;
	
	public Contato() {
	}
	
	public Contato(String nome, String telefoneCelular, String telefoneResidencial, String email,
			String dataNascimento) {
		
		if(!validaNome(nome)) {
			throw new IllegalArgumentException("Nome inválido, já utilizado em outro contato.");
		}
		
		this.nome = nome;
		this.telefoneCelular = telefoneCelular;
		this.telefoneResidencial = telefoneResidencial;
		this.email = email;
		this.dataNascimento = dataNascimento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(!validaNome(nome)) {
			throw new IllegalArgumentException("Nome inválido, já utilizado em outro contato.");
		}
		this.nome = nome;	
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getTelefoneResidencial() {
		return telefoneResidencial;
	}

	public void setTelefoneResidencial(String telefoneResidencial) {
		this.telefoneResidencial = telefoneResidencial;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	private Boolean validaNome(String nome) {
		BancoContato bancoContato = BancoContato.getInstance();
		
		if(bancoContato.buscarContato(nome) != null) {
			return false;
		}
		return true;
	}
}
