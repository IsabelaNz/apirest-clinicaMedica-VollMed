package med.voll.api.medico;

import jakarta.persistence.*; // Importa as anotações do JPA
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos") // Especifica o nome da tabela no banco de dados
@Entity(name = "medicos") // Indica que essa classe representa uma entidade JPA, mapeando-a para a tabela "medicos"
@AllArgsConstructor // Cria um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Gera automaticamente os métodos equals() e hashCode() com base no atributo "id"

public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Configura a estratégia de geração do ID como autoincremento no banco de dados
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING) // Mapeia o enum para ser armazenado como texto (STRING) no banco de dados
    private Especialidade especialidade;

    private Boolean ativo;

    @Embedded
    // Indica que o atributo endereco é um objeto incorporado dentro da entidade Medico, representando um componente da entidade
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public Medico() {
        // Construtor vazio exigido pelo JPA
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public Long getId() {
        return id;
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
        if (dados.telefone() != null) {
            this.telefone = dados.telefone();
        }
        if (dados.endereco() != null) {
            this.endereco.atualizarInformacoes(dados.endereco());
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}