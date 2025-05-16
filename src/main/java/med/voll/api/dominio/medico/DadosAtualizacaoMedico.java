package med.voll.api.dominio.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.dominio.endereco.DadosEndereco;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
