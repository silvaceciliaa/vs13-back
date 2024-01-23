package br.com.dbc.vemser.pessoaapi.enums;

import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;

import java.util.Arrays;

public enum TipoContato {
    RESIDENCIAL(1),
    COMERCIAL(2);

    private Integer tipo;

    TipoContato(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }

    public static TipoContato ofTipo(Integer tipo) throws RegraDeNegocioException {
        return Arrays.stream(TipoContato.values())
                .filter(tp -> tp.getTipo().equals(tipo))
                .findFirst()
                .get();
    }
}
