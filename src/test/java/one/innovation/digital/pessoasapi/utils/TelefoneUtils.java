package one.innovation.digital.pessoasapi.utils;

import one.innovation.digital.pessoasapi.dto.request.TelefoneDTO;
import one.innovation.digital.pessoasapi.entity.Telefone;
import one.innovation.digital.pessoasapi.enums.TipoTelefone;

public class TelefoneUtils {
    private static final String NUMERO_TELEFONE = "1199999-9999";
    private static final TipoTelefone TIPO_TELEFONE = TipoTelefone.CELULAR;
    private static final long ID_TELEFONE = 1L;

    public static TelefoneDTO createFakeDTO() {
        return TelefoneDTO.builder()
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }

    public static Telefone createFakeEntity() {
        return Telefone.builder()
                .id(ID_TELEFONE)
                .numero(NUMERO_TELEFONE)
                .tipo(TIPO_TELEFONE)
                .build();
    }
}
