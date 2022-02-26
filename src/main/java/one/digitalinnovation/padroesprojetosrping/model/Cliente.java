package one.digitalinnovation.padroesprojetosrping.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public final class Cliente {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String nome;

    @ManyToOne
    private Endereco endereco;

    @OneToOne
    private Telefone telefone;

    @OneToMany
    private Set<Categoria> categoriasPreferencia;

    private Cliente(Builder clienteBuilder){
        this.nome = clienteBuilder.nome;
        this.endereco = clienteBuilder.endereco;
        this.telefone = clienteBuilder.telefone;
        this.categoriasPreferencia = clienteBuilder.categorias;
    }

    public Cliente(){
    }

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

    public Endereco getEndereco() {
        return endereco;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public Set<Categoria> getCategoriasPreferencia() {
        return categoriasPreferencia;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Telefone setTelefone(){
        return telefone;
    }

    public void setTelefone(Telefone telefone){
        this.telefone = telefone;
    }

    public void addCategoria(Categoria categoria){
        categoriasPreferencia.add(categoria);
    }

    public static class Builder {

        private final String nome;
        private final Endereco endereco;
        private Telefone telefone;
        private Set<Categoria> categorias;

        public Builder(Endereco endereco, String nome){
            if(endereco == null || nome == null){
                throw new IllegalArgumentException("Nome e endereco sao obrigatorios.");
            }
            this.endereco = endereco;
            this.nome = nome;
        }

        public Builder comTelefone(Telefone telefone){
            this.telefone = telefone;
            return this;
        }

        public Builder comCategoria(Set<Categoria> categorias){
            this.categorias = categorias;
            return this;
        }

        public Cliente build(){
            return new Cliente(this);
        }

    }
}
