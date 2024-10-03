package br.com.treinaweb.ediaristas.core.exceptions;

import javax.persistence.EntityNotFoundException;

public class ServicoNaoEncontradoException extends EntityNotFoundException {
    
    public ServicoNaoEncontradoException(String msg) {
        super(msg);
    }
}
