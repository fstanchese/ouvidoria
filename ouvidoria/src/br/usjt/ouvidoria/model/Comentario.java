package br.usjt.ouvidoria.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="comentario")
public class Comentario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;

	@NotEmpty
	@Column(name="descricao")
	@Size(max = 1000, message = "Tamanho máximo 1000 caracteres.")
	private String descricao;
	
	@Temporal(value=TemporalType.TIMESTAMP)
	@Column(name="datacomentario", nullable = true)
	private Date dataComentario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "sugestao_id")
	@JsonIgnore
	private Postagem sugestao;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "usuario_id")
	@JsonIgnore
	private Usuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataComentario() {
		return dataComentario;
	}

	public void setDataComentario(Date dataComentario) {
		this.dataComentario = dataComentario;
	}

	public Postagem getSugestao() {
		return sugestao;
	}

	public void setSugestao(Postagem sugestao) {
		this.sugestao = sugestao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", descricao=" + descricao + ", dataComentario=" + dataComentario + ", sugestao="
				+ sugestao + ", usuario=" + usuario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
