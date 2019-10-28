package afferolab.chalenge.papelaria.service;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import afferolab.chalenge.papelaria.entity.Produto;
import afferolab.chalenge.papelaria.repository.ProdutoRepository;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProdutoService {
	
	@Autowired
    private ProdutoRepository produtoRespository;

    public List<Produto> findAll() {
        return produtoRespository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRespository.findById(id);
    }

    public Produto save(Produto stock) {
        return produtoRespository.save(stock);
    }

    public void deleteById(Long id) {
    	produtoRespository.deleteById(id);
    }
}