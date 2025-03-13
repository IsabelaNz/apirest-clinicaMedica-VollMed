package med.voll.api.medico;

import jakarta.persistence.*; // Importa as anotações do JPA
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

@Table(name = "medicos") // Especifica o nome da tabela no banco de dados
@Entity(name = "medicos") // Indica que essa classe representa uma entidade JPA, mapeando-a para a tabela "medicos"
@Getter // Gera automaticamente os métodos getter para todos os atributos
@NoArgsConstructor // Cria um construtor sem argumentos
@AllArgsConstructor // Cria um construtor com todos os argumentos
@EqualsAndHashCode(of = "id") // Gera automaticamente os métodos equals() e hashCode() com base no atributo "id"

public class Medico {

    @Id // Define que este atributo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a estratégia de geração do ID como autoincremento no banco de dados
    private Long id;

    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING) // Mapeia o enum para ser armazenado como texto (STRING) no banco de dados
    private Especialidade especialidade;

    @Embedded // Indica que o atributo endereco é um objeto incorporado dentro da entidade Medico, representando um componente da entidade
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }
}
