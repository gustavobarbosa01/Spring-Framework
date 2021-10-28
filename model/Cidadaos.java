package br.com.cadastro.gustavo.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citizens")
public class Cidadaos {

	private long id;
    	private String cpf;
	private String nome;
	private String endereco;
	private String sexo;
	
	public Cidadaos() {
		
	}
	
	public Cidadaos(String cpf, String nome, String endereco, String sexo) {
		this.nome = cpf;
        	this.nome = nome;
		this.endereco = endereco;
		this.sexo = sexo;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "cpf", nullable = false)
	public String getCpf(){
		return cpf;
	}
	public void setCpf(String cpf){
		this.cpf = cpf;
	}

	@Column(name = "name", nullable = false)
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "address", nullable = false)
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name = "sex", nullable = false)
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public String toString() {
		return "Cidadaos2 [c2id=" + id + ", cpf=" + cpf + ", nome=" + nome + ", endereco=" + endereco + ", sexo=" + sexo
				+ "]";
	}
	
}
