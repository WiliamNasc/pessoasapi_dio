package one.innovation.digital.pessoasapi.service;

import one.innovation.digital.pessoasapi.dto.MessageResponseDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
    private PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    public MessageResponseDTO criarPessoa(Pessoa pessoa){
        Pessoa pessoaSalva = pessoaRepository.save(pessoa);
        return MessageResponseDTO
                .builder()
                .mensagem("Pessoa com o ID: " + pessoaSalva.getId() + " , criada com sucesso!")
                .build();
    }
}
