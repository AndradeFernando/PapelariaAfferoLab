package afferolab.chalenge.papelaria.controller;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import afferolab.chalenge.papelaria.entity.Produto;
import afferolab.chalenge.papelaria.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor

public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        if (!produtoService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
            log.info("testing git hub");
            
        } else {
        	produto.setId(id);
        }

        log.info(produto.getId() + "-" + produto.getNome());
        return ResponseEntity.ok(produtoService.save(produto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!produtoService.findById(id).isPresent()) {
            ResponseEntity.badRequest().build();
        }

        produtoService.deleteById(id);

        return ResponseEntity.ok().build();
    }
	
    @GetMapping
    public ResponseEntity<List<Produto>> findAll() {
	
    	List<Produto> prods = produtoService.findAll();
        return ResponseEntity.ok(produtoService.findAll());
    }
    
    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.save(produto));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(@PathVariable Long id) {
        Optional<Produto> stock = produtoService.findById(id);
        if (!stock.isPresent()) {
            ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(stock.get());
    }
    
}
