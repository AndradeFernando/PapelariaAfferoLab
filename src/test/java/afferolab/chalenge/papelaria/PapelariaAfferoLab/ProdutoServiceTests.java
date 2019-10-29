package afferolab.chalenge.papelaria.PapelariaAfferoLab;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import afferolab.chalenge.papelaria.entity.Produto;
import afferolab.chalenge.papelaria.service.ProdutoService;
import lombok.extern.log4j.Log4j2;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

@Log4j2
@Category(APIIntegrationTests.class)
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProdutoServiceTests {
	
	@Autowired
	ProdutoService produtoService;
	
    @Autowired
    private MockMvc mockMvc;

	@Test 
	public void contextLoads() {
	  
		assertThat(produtoService).isNotNull();
	 }
	 
	 @Test 
	 public void testFindAll() {
	 
		 try {
			mockMvc.perform(get("/produtos")).andExpect(status().isOk()).andExpect(content().json("[{\"id\":4,\"codigoDeBarras\":\"3456789098765\",\"nome\":\"Borracha Branca e Azul e Verde\",\"descricao\":\"Borracha  Branca de celulose\",\"categoria\":\"Borracha\",\"quantidade\":23443434,\"criacao\":null,\"atualizacao\":\"2019-10-28\"},{\"id\":21,\"codigoDeBarras\":\"1234567898765\",\"nome\":\"Papel A4\",\"descricao\":\"Papel A4 para impressão a laser\",\"categoria\":\"Papel\",\"quantidade\":234,\"criacao\":\"2019-10-28\",\"atualizacao\":\"2019-10-28\"},{\"id\":22,\"codigoDeBarras\":\"1111111111111\",\"nome\":\"Papel A4\",\"descricao\":\"Papel A4 para impressão a laser\",\"categoria\":\"Papel\",\"quantidade\":234,\"criacao\":null,\"atualizacao\":\"2019-10-28\"}]"));
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	  }
	 
	 @Test 
	 public void testFindById() {
	  		 
		Produto produto = new Produto("Papel A4","Papel A4 para impressão a laser","Papel", "1234567898765",234);
		produtoService.save(produto);
		Optional<Produto> prodAux = produtoService.findById(produto.getId());
		given(produtoService.findById(produto.getId())).willReturn(prodAux);
		 
	  }
	 
	 @Test 
	 public void testDelete() {
	  		 

	  }
	 
	 @Test 
	 public void createAndUpdate() {
		 

		 
	  }
	 
	 @Test 
	 public void delete() {
	  		 

	  }
}
