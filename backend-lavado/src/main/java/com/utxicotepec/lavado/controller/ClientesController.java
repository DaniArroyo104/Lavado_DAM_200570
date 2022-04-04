package com.utxicotepec.lavado.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utxicotepec.lavado.model.Clientes;
import com.utxicotepec.lavado.repository.repositoryClientes;

@RestController
@RequestMapping("/api")
public class ClientesController {
	@Autowired
	
	repositoryClientes repClientes;
	@GetMapping("/clientes")
	
	public ResponseEntity<List<Clientes>> getAllClientes (@RequestParam(required = false) String nombre) {
		try {
			List<Clientes> cliente=new ArrayList<Clientes>();
			if(nombre==null)
				repClientes.findAll().forEach(cliente::add);
			else
				repClientes.findByNombre(nombre).forEach(cliente::add);
			if(cliente.isEmpty()) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(cliente, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	/*peticion get por id*/
	@GetMapping("/clientes/{idcliente}")
	public ResponseEntity<Clientes> getClienteById(@PathVariable("idcliente") long idcliente){
		Optional<Clientes> clienteData = repClientes.findById(idcliente);
		if (clienteData.isPresent()) {
			return new ResponseEntity<>(clienteData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*peticion post*/
	@PostMapping("/clientes")
	public ResponseEntity<Clientes> createCliente(@RequestBody Clientes cliente){
		try {
			Clientes _cliente = repClientes
					.save(new Clientes(
							cliente.getNombre(),
							cliente.getApaterno(),
							cliente.getAmaterno(),
							cliente.getDireccion(),
							cliente.getTelefono(),
							cliente.getCorreo(),
							cliente.getFecha_registro(),
							cliente.getStatus()
							));
			return new ResponseEntity<>( _cliente, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/clientes/{idcliente}")
	public ResponseEntity<HttpStatus> deleteCliente(@PathVariable("idcliente") long idcliente){
		try {
			repClientes.deleteById(idcliente);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/clientes/{idcliente}")
	public ResponseEntity<Clientes> updateCliente(@PathVariable("idcliente") long idcliente, @RequestBody Clientes cliente){
	Optional<Clientes> clienteData = repClientes.findById(idcliente);
	if (clienteData.isPresent()) {
		Clientes _cliente = clienteData.get();
		_cliente.setNombre(cliente.getNombre());
		_cliente.setApaterno(cliente.getApaterno());
		_cliente.setAmaterno(cliente.getAmaterno());
		_cliente.setDireccion(cliente.getDireccion());
		_cliente.setTelefono(cliente.getTelefono());
		_cliente.setCorreo(cliente.getCorreo());
		_cliente.setFecha_registro(cliente.getFecha_registro());
		_cliente.setStatus(cliente.getStatus());
		return new ResponseEntity<>(repClientes.save(_cliente), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
