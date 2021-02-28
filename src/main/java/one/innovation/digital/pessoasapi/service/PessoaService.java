package one.innovation.digital.pessoasapi.service;

import one.innovation.digital.pessoasapi.dto.response.MessageResponseDTO;
import one.innovation.digital.pessoasapi.dto.request.PessoaDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.exception.PessoaNaoEncontrada;
import one.innovation.digital.pessoasapi.mapper.PessoaMapper;
import one.innovation.digital.pessoasapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<PessoaDTO> listarTodasAsPessoas() {
        List<Pessoa> todasAsPessoas = pessoaRepository.findAll();
        return todasAsPessoas
                .stream()
                .map(pessoaMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PessoaDTO procurarPorId(Long id) throws PessoaNaoEncontrada {
        Pessoa pessoa = pessoaRepository.findById(id).orElseThrow(
                () -> new PessoaNaoEncontrada(id));
        return pessoaMapper.toDTO(pessoa);
    }
}
