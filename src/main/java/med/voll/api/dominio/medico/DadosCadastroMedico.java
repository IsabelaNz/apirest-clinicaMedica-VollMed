package med.voll.api.dominio.medico;

// Importa as anotações de validação do Jakarta Validation (antes conhecido como Hibernate Validator)
import jakarta.validation.Valid;  // Valida se o objeto relacionado (endereço) deve ser validado também
import jakarta.validation.constraints.Email;  // Valida que o campo seja um e-mail válido
import jakarta.validation.constraints.NotBlank;  // Garante que o campo não seja vazio ou nulo
import jakarta.validation.constraints.NotNull;  // Garante que o campo não seja nulo
import jakarta.validation.constraints.Pattern;  // Permite validar um campo com expressão regular
import med.voll.api.dominio.endereco.DadosEndereco;  // Importa a classe DadosEndereco, que contém informações de endereço

// Classe que representa os dados necessários para cadastrar um médico (utilizando o conceito de record)
public record DadosCadastroMedico(

        // O campo "nome" não pode ser nulo nem vazio (não pode conter apenas espaços em branco)
        @NotBlank
        String nome,

        // O campo "email" também não pode ser vazio nem nulo e deve seguir o formato de um e-mail válido
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        // O campo "crm" não pode ser vazio nem nulo, e deve corresponder a uma expressão regular que permite entre 4 e 6 dígitos
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")  // O CRM deve ter entre 4 e 6 dígitos numéricos
        String crm,

        // O campo "especialidade" não pode ser nulo, e é do tipo enum (provavelmente uma lista de especialidades médicas)
        @NotNull
        Especialidade especialidade,

        // O campo "endereco" é do tipo DadosEndereco e deve ser validado recursivamente (validação de seus próprios campos)
        @NotNull
        @Valid
        DadosEndereco endereco) {
    // O record DadosCadastroMedico é uma estrutura de dados imutável que armazena as informações para o cadastro de um médico.
    // Ele garante que os dados são válidos, utilizando as anotações de validação de Bean Validation.
}
