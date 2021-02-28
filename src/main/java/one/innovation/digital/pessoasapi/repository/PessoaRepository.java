package one.innovation.digital.pessoasapi.repository;

import one.innovation.digital.pessoasapi.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
