package afferolab.chalenge.papelaria.PapelariaAfferoLab;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import afferolab.chalenge.papelaria.controller.ProdutoController;
import afferolab.chalenge.papelaria.entity.Produto;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Category(APIIntegrationTests.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoControllerTests {
	
	@Autowired
	ProdutoController produtoController;

	@Test 
	public void contextLoads() {
	  
		assertThat(produtoController).isNotNull();
	 }
	 
	 @Test 
	 public void testFindAll() {
	  		 
		 assertThat(produtoController.findAll()).isNotNull();
	  }
	 
	 @Test 
	 public void testFindById() {
	  		 
		 assertThat(produtoController.findById(new Long(1))).isNotNull(); 
	  }
	 
	 @Test 
	 public void createAndUpdate() {
		 
		 Produto produto = new Produto("Papel A4","Papel A4 para impressão a laser","Papel", "1234567898765",234);  		 
		 assertThat(produtoController.create(produto)).isNotNull();		 
		 
		 produto = new Produto(produto.getId(), "Papel A4","Papel A4 para impressão a laser","Papel", "1111111111111",234);  		 
		 assertThat(produtoController.update(produto.getId(),produto)).isNotNull();
		 
	  }
	 
	 @Test 
	 public void delete() {
	  		 
		 assertThat(produtoController.delete(new Long(1))).isNotNull();
	  }
}
