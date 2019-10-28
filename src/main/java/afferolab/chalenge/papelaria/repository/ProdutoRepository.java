package afferolab.chalenge.papelaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import afferolab.chalenge.papelaria.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}