package one.innovation.digital.pessoasapi.utils;

import one.innovation.digital.pessoasapi.dto.request.PessoaDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;

import java.time.LocalDate;
import java.util.Collections;

public class PessoaUtils {
    private static final String NOME = "Wiliam";
    private static final String SOBRENOME = "Nascimento";
    private static final String NUMERO_CPF = "369.333.878-79";
    private static final long ID_PESSOA = 1L;
    public static final LocalDate DATA_ANIVERSARIO = LocalDate.of(2010, 10, 1);

    public static PessoaDTO createFakeDTO() {
        return PessoaDTO.builder()
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataAniversario("04-04-2010")
                .telefones(Collections.singletonList(TelefoneUtils.createFakeDTO()))
                .build();
    }

    public static Pessoa createFakeEntity() {
        return Pessoa.builder()
                .id(ID_PESSOA)
                .nome(NOME)
                .sobrenome(SOBRENOME)
                .cpf(NUMERO_CPF)
                .dataAniversario(DATA_ANIVERSARIO)
                .telefones(Collections.singletonList(TelefoneUtils.createFakeEntity()))
                .build();
    }
}
