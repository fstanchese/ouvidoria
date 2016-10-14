package br.usjt.ouvidoria.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
@NamedQueries({ 
	@NamedQuery(name = "Usuario.buscaUsuario", query = "select u from Usuario u where u.login=:login and u.senha=:senha") 
})
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Long id;	
	
	@NotEmpty(message="O campo Nome é obrigatório.")
	@Size(max=100,message="Tamanho máximo 100 caracteres.")
	@Column(name="nome",length=100,nullable=false)
	private String nome;

	@Size(max=40,message="Tamanho máximo 40 caracteres.")
	@Column(name="login",length=40,nullable=false)
	private String login;

	@NotNull
	@NotEmpty
	@Column(name="senha",length=60,nullable=false)
	private String senha;

	@NotEmpty
	@Column(name="celular",length = 15, nullable = false)
	private String celular;

	@NotNull
	@Email
	@Column(name="email",length = 60, nullable = false)
	private String email;
	
	@NotNull(message = "Tipo do Usuário é obrigatório")
	@Enumerated(EnumType.STRING)
	@Column(name="tipousuario",length=20,nullable=false)
	private TipoUsuario tipoUsuario;

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "area_id")
	@JsonIgnore
	private Area area;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipo) {
		this.tipoUsuario = tipo;
	}

	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nome=" + nome + ", login=" + login + ", senha=" + senha + ", celular=" + celular
				+ ", email=" + email + ", tipoUsuario=" + tipoUsuario + ", area=" + area + "]";
	}
}
