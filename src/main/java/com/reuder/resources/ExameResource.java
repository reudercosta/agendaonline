package com.reuder.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reuder.domain.Agenda;
import com.reuder.domain.Exame;
import com.reuder.service.ExameService;

@RestController
@RequestMapping(value = "/exames")
public class ExameResource {
	
	@Autowired
	private ExameService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Exame obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
}
	/*
	 * @PreAuthorize("hasAnyRole('ADMIN')")
	 * 
	 * @RequestMapping(method = RequestMethod.POST) public ResponseEntity<Void>
	 * insert(@Valid @RequestBody CategoriaDTO objDTO) { Categoria obj =
	 * service.fromDTO(objDTO); obj = service.insert(obj); URI uri =
	 * ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand
	 * (obj.getId()).toUri();
	 * 
	 * return ResponseEntity.created(uri).build(); }
	 * 
	 * @PreAuthorize("hasAnyRole('ADMIN')")
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.PUT) public
	 * ResponseEntity<?> update(@Valid @RequestBody CategoriaDTO
	 * objDTO, @PathVariable Integer id) { Categoria obj = service.fromDTO(objDTO);
	 * obj.setId(id); obj = service.update(obj);
	 * 
	 * return ResponseEntity.noContent().build();
	 * 
	 * }
	 * 
	 * @PreAuthorize("hasAnyRole('ADMIN')")
	 * 
	 * @RequestMapping(value = "/{id}", method = RequestMethod.DELETE) public
	 * ResponseEntity<Void> delete(@PathVariable Integer id) { service.delete(id);
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @RequestMapping(method = RequestMethod.GET) public
	 * ResponseEntity<List<CategoriaDTO>> findAll() { List<Categoria> list =
	 * service.findAll(); List<CategoriaDTO> listDTO = list.stream().map(obj -> new
	 * CategoriaDTO(obj)).collect(Collectors.toList()); return
	 * ResponseEntity.ok().body(listDTO);
	 * 
	 * }
	 * 
	 * 
	 * @RequestMapping(value="/page", method = RequestMethod.GET) public
	 * ResponseEntity<Page<CategoriaDTO>> findPage(
	 * 
	 * @RequestParam(value="page", defaultValue="0") Integer page,
	 * 
	 * @RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage,
	 * 
	 * @RequestParam(value="orderBy", defaultValue="nome") String orderBy,
	 * 
	 * @RequestParam(value="direction", defaultValue="ASC") String direction) {
	 * 
	 * Page<Categoria> list = service.findPage(page, linesPerPage, orderBy,
	 * direction); Page<CategoriaDTO> listDTO = list.map(obj -> new
	 * CategoriaDTO(obj)); return ResponseEntity.ok().body(listDTO);
	 * 
	 * }
	 * 
	 * }
	 * }
	 */

