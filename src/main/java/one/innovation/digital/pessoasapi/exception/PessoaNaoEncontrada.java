package one.innovation.digital.pessoasapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PessoaNaoEncontrada extends Exception {
    public PessoaNaoEncontrada(Long id) {
        super("Pessoa com o ID " + id + " , não encontrada.");
    }
}
