package br.com.treinaweb.ediaristas.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import br.com.treinaweb.ediaristas.api.DTOs.responses.ServicoResponse;
import br.com.treinaweb.ediaristas.api.mappers.ApiServicoMapper;
import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.core.repositories.ServicoRepository;

@Service
public class ApiServicoService {

    @Autowired
    private ServicoRepository repository;

    @Autowired
    private ApiServicoMapper mapper;

    public List<ServicoResponse> buscarTodos() {
        /*var servicos = repository.findAll();
        var response = new ArrayList<ServicoResponse>();
        for (Servico servico : servicos) {
            var servicoResponse = mapper.toResponse(servico);
            response.add(servicoResponse);
        }
        return response;*/
        var servicoSort = Sort.sort(Servico.class);
        var ordenacao = servicoSort.by(Servico::getPosicao).ascending();
        return repository.findAll(ordenacao).stream().map(mapper::toResponse).toList();
    }
}