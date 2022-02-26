package one.digitalinnovation.padroesprojetosrping.controller;

import one.digitalinnovation.padroesprojetosrping.model.Cliente;
import one.digitalinnovation.padroesprojetosrping.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Iterable<Cliente>> buscarTodos(){
        return ResponseEntity.ok(clienteService.buscarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(clienteService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
        Cliente.Builder clienteBuilder = new Cliente.Builder(cliente.getEndereco(), cliente.getNome());
        if(cliente.getTelefone() != null){
            clienteBuilder.comTelefone(cliente.getTelefone());
        }
        if(cliente.getCategoriasPreferencia() != null){
            clienteBuilder.comCategoria(cliente.getCategoriasPreferencia());
        }
        Cliente clienteBd = clienteBuilder.build();
        clienteService.inserir(clienteBd);
        return ResponseEntity.ok(clienteBd);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
        clienteService.atualizar(id, cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        clienteService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
