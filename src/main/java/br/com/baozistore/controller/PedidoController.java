package br.com.baozistore.controller;
import br.com.baozistore.model.Pedido;
import br.com.baozistore.repository.*;
import br.com.baozistore.exception.RecursoNaoEncontradoException;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/pedidos")
public class PedidoController {
 private final PedidoRepository pedidos; private final ClienteRepository clientes; private final ProdutoRepository produtos;
 public PedidoController(PedidoRepository p,ClienteRepository c,ProdutoRepository pr){pedidos=p;clientes=c;produtos=pr;}
 private void validar(Pedido p){
  if(p.getClienteId()==null || !clientes.existsById(p.getClienteId())) throw new RecursoNaoEncontradoException("Cliente informado não existe");
  if(p.getProdutoId()==null || !produtos.existsById(p.getProdutoId())) throw new RecursoNaoEncontradoException("Produto informado não existe");
  if(p.getQuantidade()==null || p.getQuantidade()<1) throw new IllegalArgumentException("Quantidade deve ser maior que zero");
 }
 @PostMapping public ResponseEntity<Pedido> criar(@Valid @RequestBody Pedido p){p.setId(null);validar(p);return ResponseEntity.status(HttpStatus.CREATED).body(pedidos.save(p));}
 @GetMapping public List<Pedido> listar(){return pedidos.findAll();}
 @GetMapping("/{id}") public Pedido buscar(@PathVariable Long id){return pedidos.findById(id).orElseThrow(()->new RecursoNaoEncontradoException("Pedido "+id+" não encontrado"));}
 @PutMapping("/{id}") public Pedido atualizar(@PathVariable Long id,@Valid @RequestBody Pedido p){Pedido atual=buscar(id);validar(p);atual.setClienteId(p.getClienteId());atual.setProdutoId(p.getProdutoId());atual.setQuantidade(p.getQuantidade());return pedidos.save(atual);}
 @DeleteMapping("/{id}") public ResponseEntity<Void> excluir(@PathVariable Long id){if(!pedidos.existsById(id))throw new RecursoNaoEncontradoException("Pedido "+id+" não encontrado");pedidos.deleteById(id);return ResponseEntity.noContent().build();}
}
