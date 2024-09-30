package com.codigos.projetopoo.repository;

import java.util.ArrayList;
import java.util.List;
import com.codigos.projetopoo.model.Diarista;

public class DiaristaRepository implements IRepository<Diarista, Long> {

    private List<Diarista> diaristas;
    private Long idAtual;

    public DiaristaRepository() {
        diaristas = new ArrayList<>();
        idAtual = 1L;
    }

    @Override
    public List<Diarista> buscarTodos() {
        return diaristas;
    }

    @Override
    public Diarista cadastrar(Diarista model) {
        model.setId(idAtual);
        diaristas.add(model);
        this.idAtual++;
        return model;
    }

    @Override
    public Diarista buscarPorId(Long id) {
        for (Diarista diarista : diaristas) {
            if (diarista.getId().equals(id)) {
                return diarista;
            }
        }
        return null;
    }

    @Override
    public boolean excluirPorId(Long id) {
        var diaristaEncontrada = buscarPorId(id);
        if (diaristaEncontrada != null) {
            this.diaristas.remove(diaristaEncontrada);
            return true;
        }
        return false;
    }    
}
