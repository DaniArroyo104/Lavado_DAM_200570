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

import com.utxicotepec.lavado.model.Ventas;
import com.utxicotepec.lavado.repository.repositoryVentas;


@RestController
@RequestMapping("/api")
public class VentasController {

	@Autowired
	
	repositoryVentas repVentas;
	@GetMapping("/ventas")
	
	public ResponseEntity<List<Ventas>> getAllVentas (@RequestParam(required = false) String fecha) {
		try {
			List<Ventas> venta=new ArrayList<Ventas>();
			if(fecha==null)
				repVentas.findAll().forEach(venta::add);
			else
				repVentas.findByFecha(fecha).forEach(venta::add);
			if(venta.isEmpty()) {
				return new ResponseEntity<> (HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(venta, HttpStatus.OK);
			
		}catch(Exception e) {
			return new ResponseEntity<> (null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		}
	
	/*peticion get por id*/
	@GetMapping("/ventas/{idventa}")
	public ResponseEntity<Ventas> getVentaById(@PathVariable("idventa") long idventa){
		Optional<Ventas> ventaData = repVentas.findById(idventa);
		if (ventaData.isPresent()) {
			return new ResponseEntity<>(ventaData.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*peticion post*/
	@PostMapping("/ventas")
	public ResponseEntity<Ventas> createVenta(@RequestBody Ventas ventas){
		try {
			Ventas _venta = repVentas
					.save(new Ventas(
							ventas.getFecha(),
							ventas.getIdtrabajador(),
							ventas.getIdcajero(),
							ventas.getIdservicio(),
							ventas.getIdvehiculo(),
							ventas.getStatus()
							));
			return new ResponseEntity<>( _venta, HttpStatus.CREATED);
		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/ventas/{idventa}")
	public ResponseEntity<HttpStatus> deleteVenta(@PathVariable("idventa") long idventa){
		try {
			repVentas.deleteById(idventa);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/ventas/{idventa}")
	public ResponseEntity<Ventas> updateVenta(@PathVariable("idventa") long idventa, @RequestBody Ventas venta){
	Optional<Ventas> ventaData = repVentas.findById(idventa);
	if (ventaData.isPresent()) {
		Ventas _venta = ventaData.get();
		_venta.setFecha(venta.getFecha());
		_venta.setIdtrabajador(venta.getIdtrabajador());
		_venta.setIdcajero(venta.getIdcajero());
		_venta.setIdservicio(venta.getIdservicio());
		_venta.setIdvehiculo(venta.getIdvehiculo());
		_venta.setStatus(venta.getStatus());
		return new ResponseEntity<>(repVentas.save(_venta), HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
