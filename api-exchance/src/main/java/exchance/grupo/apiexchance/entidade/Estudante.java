package exchance.grupo.apiexchance.entidade;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.br.CPF;

import java.util.List;

@Entity
public class Estudante {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudante;


    private String nome;


    private Integer idade;


    private String descricao;



    private String email;



    private String senha;


    private String telefone;


    private String cpf;


    @ManyToOne
    private Localidade localidade;

    @OneToMany(mappedBy = "estudante")
    private List<Reserva> reservas;

    @OneToMany(mappedBy = "proprietario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "estudante")
    private List<Imagem> imagens;



    public Integer getIdEstudante() {
        return idEstudante;
    }

    public void setIdEstudante(Integer idEstudante) {
        this.idEstudante = idEstudante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Localidade getLocalidade() {
        return localidade;
    }

    public void setLocalidade(Localidade localidade) {
        this.localidade = localidade;
    }
}
