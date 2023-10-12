package modelo;

import java.util.ArrayList;

public class BancoContato {
	
	private static BancoContato instance;
	private ArrayList<Contato> contatos;
	
	public BancoContato() {
		contatos = new ArrayList<>();
	}
	
	public static BancoContato getInstance() {
		if(instance == null) {
			instance = new BancoContato();
		}
		return instance;
	}
	
	public ArrayList<Contato> getContatos() {
		return contatos;
	}
	
	public Contato buscarContato(String nome) {
		for (Contato contato : contatos) {
			if(contato.getNome().equals(nome)) {
				return contato;
			}
		}
		return null;
	}
	
	public Boolean excluirContato(String nome) {
		Contato contato = buscarContato(nome);
		
		if(contato != null) {
			contatos.remove(contato);
			return true;
		}
		
		return false;
	}

}
