package miranda.mb.product.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import miranda.mb.product.models.Produto;
import miranda.mb.product.repositorios.ProdutoRepositoryJPA;

@RestController
@RequestMapping(value = "/api")
@Api (value = "API REST DE CADASTRO DE PRODUTOS")
@CrossOrigin(origins="*")
public class ProdutoResource {

	@Autowired
	ProdutoRepositoryJPA produtoRepositorio ;
	
	@GetMapping("/produtos")
	@ApiOperation(value = "Retorna todos os produtos no DB")
	public List<Produto> listaProdutos(){
	return produtoRepositorio.findAll();
	}
	
	
	@GetMapping("/produto/{id}")
	@ApiOperation(value = "Retorna o produto definido pelo ID \n Recebe um ID como parametro.")
	public Produto listaProdutos(@PathVariable (value="id") Long id){
	return produtoRepositorio.findById(id).get();
	}
	
	@PostMapping("/save")
	@ApiOperation(value = "Salva um produto definido pelo JSON do Produto \n Recebe um JSON da entidade Produto.")
	public Produto salvarProduto(@RequestBody Produto produto) {
		return produtoRepositorio.save(produto);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Deleta um produto definido pelo ID \n Recebe um ID da entidade Produto.")
	public void deletarProduto(@PathVariable (value="id") Long id) {
	produtoRepositorio.delete(produtoRepositorio.findById(id).get());
	}
	
	@PutMapping("/update")
	@ApiOperation(value = "Altera um produto definido pelo JSON \n Recebe um JSON da entidade Produto.")
	public Produto atualizarProduto(@RequestBody Produto produto) {
		return produtoRepositorio.save(produto);
	}
	
}