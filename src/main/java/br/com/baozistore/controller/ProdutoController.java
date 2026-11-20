package br.com.baozistore.controller;
import br.com.baozistore.model.Produto;
import br.com.baozistore.repository.ProdutoRepository;
import br.com.baozistore.exception.RecursoNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/produtos")
public class ProdutoController {
 private final ProdutoRepository repo;
 public ProdutoController(ProdutoRepository repo){this.repo=repo;}
 @PostMapping public ResponseEntity<Produto> criar(@Valid @RequestBody Produto p){p.setId(null);return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(p));}
 @GetMapping public List<Produto> listar(){return repo.findAll();}
 @GetMapping("/{id}") public Produto buscar(@PathVariable Long id){return repo.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Produto "+id+" não encontrado"));}
 @PutMapping("/{id}") public Produto atualizar(@PathVariable Long id,@Valid @RequestBody Produto p){Produto atual=buscar(id);atual.setNome(p.getNome());atual.setPreco(p.getPreco());atual.setEstoque(p.getEstoque());return repo.save(atual);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!repo.existsById(id))throw new RecursoNaoEncontradoException("Produto "+id+" não encontrado");repo.deleteById(id);return ResponseEntity.noContent().build();}
}
