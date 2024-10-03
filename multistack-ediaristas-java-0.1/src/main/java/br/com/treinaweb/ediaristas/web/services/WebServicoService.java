package br.com.treinaweb.ediaristas.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.treinaweb.ediaristas.core.exceptions.ServicoNaoEncontradoException;
import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.core.repositories.ServicoRepository;
import br.com.treinaweb.ediaristas.web.dtos.ServicoForm;
import br.com.treinaweb.ediaristas.web.mappers.WebServiceMapper;
import java.util.List;

@Service
public class WebServicoService {
    
    @Autowired
    private ServicoRepository repository;

    @Autowired
    private WebServiceMapper mapper;

    public List<Servico> buscarTodos() {
        return repository.findAll();
    }

    public Servico cadastrar(ServicoForm form) {
        var model = mapper.toModel(form);
        return repository.save(model);
    }

    public Servico buscarPorId(Long id) {
        var servicoEncontrado = repository.findById(id);
        String mensagem = String.format("Servico com ID %d não encontrado!", id);
        if (!servicoEncontrado.isPresent()) throw new ServicoNaoEncontradoException(mensagem);
        return servicoEncontrado.get();
    }

    public Servico editar(ServicoForm form, Long id) {
        var servicoEncontrado = buscarPorId(id);
        var model = mapper.toModel(form);
        model.setId(servicoEncontrado.getId());
        return repository.save(model);
    }

    public void excluirPorId(Long id) {
        var servicoEncontrado = buscarPorId(id);
        repository.delete(servicoEncontrado);
    }
}
