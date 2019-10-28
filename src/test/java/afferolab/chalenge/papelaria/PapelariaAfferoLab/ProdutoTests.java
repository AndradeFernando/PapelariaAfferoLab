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
import lombok.extern.log4j.Log4j2;

@Log4j2
@Category(APIIntegrationTests.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoTests {
	
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
	 public void testDelete() {
	  		 
		 assertThat(produtoController.delete(new Long(1))).isNotNull();
	  }
}
