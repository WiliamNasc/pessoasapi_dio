package one.innovation.digital.pessoasapi.controller;

import one.innovation.digital.pessoasapi.dto.response.MessageResponseDTO;
import one.innovation.digital.pessoasapi.dto.request.PessoaDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.exception.PessoaNaoEncontrada;
import one.innovation.digital.pessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoa")
public class PessoaController {

    private PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService){
        this.pessoaService = pessoaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO){
        return pessoaService.criarPessoa(pessoaDTO);
    }

    @GetMapping
    public List<PessoaDTO> listarTodasAsPessoas(){
        return pessoaService.listarTodasAsPessoas();
    }

    @GetMapping("/{id}")
    public PessoaDTO procurarPorId(@PathVariable Long id) throws PessoaNaoEncontrada {
        return pessoaService.procurarPorId(id);
    }

    @PutMapping("/{id}")
    public MessageResponseDTO atualizarPorId(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) throws PessoaNaoEncontrada {
        return pessoaService.atualizarPorId(id, pessoaDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void detetarPorId(@PathVariable Long id) throws PessoaNaoEncontrada {
        pessoaService.deletarPorId(id);
    }
}