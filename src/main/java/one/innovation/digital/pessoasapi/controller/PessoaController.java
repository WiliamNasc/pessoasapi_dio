package one.innovation.digital.pessoasapi.controller;

import one.innovation.digital.pessoasapi.dto.MessageResponseDTO;
import one.innovation.digital.pessoasapi.entity.Pessoa;
import one.innovation.digital.pessoasapi.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    public MessageResponseDTO criarPessoa(@RequestBody Pessoa pessoa){
        return pessoaService.criarPessoa(pessoa);
    }
}