package one.innovation.digital.pessoasapi.service;

import one.innovation.digital.pessoasapi.dto.request.PessoaDTO;
import one.innovation.digital.pessoasapi.dto.response.MessageResponseDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.repository.PessoaRepository;
import one.innovation.digital.pessoasapi.utils.PessoaUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PessoaServiceTest {
    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    @Test
    void DadoUmaPessoaDTOEntaoRetornarMensagemCriada() {
        PessoaDTO pessoaDTO = PessoaUtils.createFakeDTO();
        Pessoa esperaSalvarPessoa = PessoaUtils.createFakeEntity();
        Mockito.when(pessoaRepository.save(esperaSalvarPessoa))
                .thenReturn(esperaSalvarPessoa);

        MessageResponseDTO mensagemSucessoEsperada = criaMessageResponse(esperaSalvarPessoa.getId());
        MessageResponseDTO mensagemSucesso = pessoaService.criarPessoa(pessoaDTO);

        Assertions.assertEquals(mensagemSucessoEsperada, mensagemSucesso);
    }

    private MessageResponseDTO criaMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .mensagem("Pessoa com o ID: " + id)
                .build();
    }
}
