package one.digitalinnovation.padroesprojetosrping.service.impl;

import one.digitalinnovation.padroesprojetosrping.model.Categoria;
import one.digitalinnovation.padroesprojetosrping.model.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Iterable<Categoria> buscarTodos(){
        return this.categoriaRepository.findAll();
    }

    public Categoria buscarPorId(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.get();
    }

    public void inserir(Categoria categoria){
        if(categoria == null){
            throw new IllegalArgumentException("Categoria precisa ser preenchida.");
        }
        categoriaRepository.save(categoria);
    }

    public void atualizar(Long id, Categoria categoria){
        Optional<Categoria> categoriaBd = categoriaRepository.findById(id);
        if(categoriaBd.isPresent()){
            categoriaRepository.save(categoria);
        }
    }

    public void deletar(Long id){
        categoriaRepository.deleteById(id);
    }

}
