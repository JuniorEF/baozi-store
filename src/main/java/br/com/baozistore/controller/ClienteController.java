package br.com.baozistore.controller;
import br.com.baozistore.model.Cliente;
import br.com.baozistore.repository.ClienteRepository;
import br.com.baozistore.exception.RecursoNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/clientes")
public class ClienteController {
 private final ClienteRepository repo;
 public ClienteController(ClienteRepository repo){this.repo=repo;}
 @PostMapping public ResponseEntity<Cliente> criar(@Valid @RequestBody Cliente c){c.setId(null);return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(c));}
 @GetMapping public List<Cliente> listar(){return repo.findAll();}
 @GetMapping("/{id}") public Cliente buscar(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Cliente "+id+" não encontrado"));}
 @PutMapping("/{id}") public Cliente atualizar(@PathVariable Long id,@Valid @RequestBody Cliente c){Cliente atual=buscar(id);atual.setNome(c.getNome());atual.setClienteDesde(c.getClienteDesde());return repo.save(atual);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))throw new RecursoNaoEncontradoException("Cliente "+id+" não encontrado");repo.deleteById(id);return ResponseEntity.noContent().build();}
}
