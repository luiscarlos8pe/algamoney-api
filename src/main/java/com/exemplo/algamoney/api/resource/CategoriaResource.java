package com.exemplo.algamoney.api.resource;


import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.exemplo.algamoney.api.event.RecursoCriadoEvent;
import com.exemplo.algamoney.api.model.Categoria;
import com.exemplo.algamoney.api.repository.CategoriaRepository;

@RestController
@RequestMapping("/categorias")
public class CategoriaResource {
	
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@GetMapping
	public List<Categoria> listar() {
		return categoriaRepository.findAll();
	}
	
	@PostMapping  // esse metodo trata argumentos nao validos
	//@ResponseStatus(HttpStatus.CREATED)//ao termizar a ezecução deste metodo eu quero q retorno HttpStatus.CREATED (status:201 create)
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) { // @valid valida se o objeto esta null ou vazio
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
					
			
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<Object> buscarPeloCodigo(@PathVariable Long codigo) {
		Optional<Categoria> categoria = categoriaRepository.findById(codigo);
		 /*if (categoria != null && !categoria.isEmpty())
			return ResponseEntity.ok(categoria);
		else
			return ResponseEntity.notFound().build();*/
		return categoria != null ? ResponseEntity.ok(categoria) : ResponseEntity.notFound().build();
	} 
	
}
