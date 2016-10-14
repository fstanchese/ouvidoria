package br.usjt.ouvidoria.model;

public enum TipoUsuario {

	SUPERVISOR("Supervisor"), AVALIADOR("Avaliador"), CIDADAO("Cidadão");

	private String descricao;

	TipoUsuario(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
