package br.com.treinaweb.ediaristas.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.FieldError;
import java.util.List;
import br.com.treinaweb.ediaristas.core.enums.TipoUsuario;
import br.com.treinaweb.ediaristas.core.exceptions.SenhasNaoConferemException;
import br.com.treinaweb.ediaristas.core.exceptions.UsuarioJaCadastradoException;
import br.com.treinaweb.ediaristas.core.exceptions.UsuarioNaoEncontradoException;
import br.com.treinaweb.ediaristas.core.models.Usuario;
import br.com.treinaweb.ediaristas.core.repositories.UsuarioRepository;
import br.com.treinaweb.ediaristas.web.dtos.UsuarioCadastroForm;
import br.com.treinaweb.ediaristas.web.dtos.UsuarioEdicaoForm;
import br.com.treinaweb.ediaristas.web.mappers.WebUsuarioMapper;

@Service
public class WebUsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private WebUsuarioMapper mapper;

    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    public Usuario cadastrar(UsuarioCadastroForm form) {
        var senha = form.getSenha();
        var confirmacaoSenha = form.getConfirmacaoSenha();
        if (!senha.equals(confirmacaoSenha)) {
            var msg = "Os dois campos de senha não conferem";
            var fieldError = new FieldError(form.getClass().getName(), "confirmacaoSenha", form.getConfirmacaoSenha(),
                    false, null, null, msg);
            throw new SenhasNaoConferemException(msg, fieldError);
        }
        var model = mapper.toModel(form);
        model.setTipoUsuario(TipoUsuario.ADMIN);
        validarCamposUnicos(model);
        return repository.save(model);
    }

    public Usuario buscarPorId(Long id) {
        var msg = String.format("Usuário com ID %d não encontrado!", id);
        return repository.findById(id).orElseThrow(() -> new UsuarioNaoEncontradoException(msg));
    }

    public UsuarioEdicaoForm buscarFormPorId(Long id) {
        var usuario = buscarPorId(id);
        return mapper.toForm(usuario);
    }

    public Usuario editar(UsuarioEdicaoForm form, Long id) {
        var usuario = buscarPorId(id);
        var model = mapper.toModel(form);
        model.setId(usuario.getId());
        model.setSenha(usuario.getSenha());
        model.setTipoUsuario(usuario.getTipoUsuario());
        validarCamposUnicos(model);
        return repository.save(model);
    }

    public void excluirPorId(Long id) {
        var usuario = buscarPorId(id);
        repository.delete(usuario);
    }

    private void validarCamposUnicos(Usuario usuario) {
        if (repository.isEmailJaCadastrado(usuario.getEmail(), usuario.getId())) {
            var msg = "Já existe um usuário cadastrado com esse e-mail!";
            var fieldError = new FieldError(usuario.getClass().getName(), "email", usuario.getEmail(), false, null, null, msg);
            throw new UsuarioJaCadastradoException(msg, fieldError);
        }
    }
}
