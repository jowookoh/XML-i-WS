package sesta.projekat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sesta.projekat.model.KategorijaSmestaja;
import sesta.projekat.model.TipSmestaja;
import sesta.projekat.service.KategorijaSmestajaService;
import sesta.projekat.service.TipSmestajaService;

import java.util.List;

@RestController
@RequestMapping(TipKategorijeController.KATEGORIJA_URI)
public class TipKategorijeController {

	public static final String KATEGORIJA_URI = "kategorija";

	@Autowired
	private KategorijaSmestajaService kategorijaService;

	@GetMapping
	public ResponseEntity getAll(){
		List<KategorijaSmestaja> kategorijeSmestaja = kategorijaService.getAll();
		return ResponseEntity.ok(kategorijeSmestaja);
	}

	@GetMapping(value = "{id}")
	public ResponseEntity getOne(@PathVariable final Long id){
		KategorijaSmestaja ks = kategorijaService.findOne(id);
		if (ks == null){
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(ks);
	}

	@DeleteMapping(value = "{id}")
	public ResponseEntity deleteOne(@PathVariable final Long id){
		KategorijaSmestaja ks = kategorijaService.findOne(id);
		if (ks == null){
			return ResponseEntity.notFound().build();
		}
		kategorijaService.deleteOne(ks);
		return ResponseEntity.ok().build();
	}

	@PostMapping
	public ResponseEntity create(@RequestBody KategorijaSmestaja ks){
		ks = kategorijaService.save(ks);
		return ResponseEntity.ok(ks);
	}

	@PutMapping(value = "{id}")
	public ResponseEntity update(@RequestBody KategorijaSmestaja ks, @PathVariable Long id){
		KategorijaSmestaja ksUpdated = kategorijaService.findOne(id);
		if (ksUpdated == null) {
			return ResponseEntity.notFound().build();
		}
		ksUpdated.setNaziv(ks.getNaziv());
		ksUpdated = kategorijaService.save(ksUpdated);
		return ResponseEntity.ok(ksUpdated);
	}


}
