package br.usjt.ouvidoria.model;

public enum Status {

	ABERTO("Aberto"), FECHADO("Fechado"), BLOQUEADO("Bloqueado"), CANCELADO("Cancelado");

	private String descricao;

	Status(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
