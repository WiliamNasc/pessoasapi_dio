package one.innovation.digital.pessoasapi.service;

import one.innovation.digital.pessoasapi.dto.response.MessageResponseDTO;
import one.innovation.digital.pessoasapi.dto.request.PessoaDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.mapper.PessoaMapper;
import one.innovation.digital.pessoasapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO criarPessoa(PessoaDTO pessoaDTO){
        Pessoa pessoaASerSalva = pessoaMapper.toModel(pessoaDTO);
        Pessoa pessoaSalva = pessoaRepository.save(pessoaASerSalva);

        return MessageResponseDTO
                .builder()
                .mensagem("Pessoa com o ID: " + pessoaSalva.getId() + " , criada com sucesso!")
                .build();
    }
}
