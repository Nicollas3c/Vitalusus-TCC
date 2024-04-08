package br.itb.projeto.vitalususPlus.rest.controller;

import br.itb.projeto.vitalususPlus.model.entity.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.itb.projeto.vitalususPlus.service.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/vitalusus/usuario/")
public class UsuarioController {
	private UsuarioService usuarioService;

	public UsuarioController(UsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;
	}
	@GetMapping("findAll")
	public ResponseEntity<List<Usuario>> findAll(){
		List<Usuario> usuarios = this.usuarioService.findAll();
		return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
	}
	@GetMapping("findById/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable long id){
		Usuario usuario = this.usuarioService.findById(id);
		return  new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
	}
	@PostMapping("post")
	public ResponseEntity<Usuario> salvarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioSalvo = this.usuarioService.save(usuario);
		return new ResponseEntity<Usuario>(usuarioSalvo, HttpStatus.OK);
	}
	@DeleteMapping("delete")
	public void deletarUsuario(@RequestBody Usuario usuario){
		this.usuarioService.delete(usuario);
	}
	@PutMapping("update")
	public ResponseEntity<Usuario> updateUsuario(@RequestBody Usuario usuario){
		Usuario usuarioUpdatado = this.usuarioService.update(usuario);
		return new ResponseEntity<Usuario>(usuarioUpdatado, HttpStatus.OK);
	}
}
