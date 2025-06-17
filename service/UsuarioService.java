package com.example.crud.service;

import com.example.crud.model.Usuario;
import com.example.crud.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> listarTodos() {
        return repository.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Usuario salvar(Usuario usuario) {
        return repository.save(usuario);
    }

    public Usuario atualizar(Long id, Usuario dadosAtualizados) {
        return repository.findById(id).map(usuario -> {
            usuario.setNome(dadosAtualizados.getNome());
            usuario.setEmail(dadosAtualizados.getEmail());
            return repository.save(usuario);
        }).orElse(null);
    }

    public void remover(Long id) {
        repository.deleteById(id);
    }
}
