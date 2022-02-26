package one.digitalinnovation.padroesprojetosrping.service.impl;

import one.digitalinnovation.padroesprojetosrping.model.Telefone;
import one.digitalinnovation.padroesprojetosrping.model.TelefoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TelefoneService {

    @Autowired
    private TelefoneRepository telefoneRepository;

    public Iterable<Telefone> buscarTodos(){
        return this.telefoneRepository.findAll();
    }

    public Telefone buscarPorId(Long id){
        Optional<Telefone> telefone = telefoneRepository.findById(id);
        return telefone.get();
    }

    public void inserir(Telefone telefone){
        if(telefone == null){
            throw new IllegalArgumentException("Telefone precisa ser preenchido.");
        }
        telefoneRepository.save(telefone);
    }

    public void atualizar(Long id, Telefone telefone){
        Optional<Telefone> telefoneBd = telefoneRepository.findById(id);
        if(telefoneBd.isPresent()){
            telefoneRepository.save(telefone);
        }
    }

    public void deletar(Long id){
        telefoneRepository.deleteById(id);
    }

}
