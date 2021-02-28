package one.innovation.digital.pessoasapi.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO {
    private String mensagem;
}
