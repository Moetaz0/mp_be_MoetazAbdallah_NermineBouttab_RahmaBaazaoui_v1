package soa.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Facture;
import soa.entities.Reglement;
import soa.entities.ReglementFacture;
import soa.repository.FactureR;
import soa.repository.ReglementFactureRepository;
import soa.repository.ReglementRepository;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/gr")
public class GR {

    @Autowired
    private ReglementRepository R;
    @Autowired
    private ReglementFactureRepository RF;
    @Autowired
    private FactureR F;

    @GetMapping(value = "reglement/getAll", produces = { MediaType.APPLICATION_JSON_VALUE })
    public List<Reglement> getAll() {
        return R.findAll();
    }

    @GetMapping(value = "reglement/get/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public Reglement getReglement(@PathVariable Long id) {
        return R.findById(id).orElse(null);
    }


    @DeleteMapping(value = "reglement/delete/{id}")
    public ResponseEntity<String> deleteReglement(@PathVariable Long id) {
        try {
            R.deleteById(id);
            return new ResponseEntity<>("Reglement with ID " + id + " deleted successfully", HttpStatus.OK);
        } catch (EmptyResultDataAccessException e) {
            // This exception is thrown if the entity with the specified ID is not found
            return new ResponseEntity<>("Reglement with ID " + id + " not found", HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            // Handle other exceptions (e.g., database connectivity issues)
            return new ResponseEntity<>("Error deleting Reglement with ID " + id, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "reglement/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }
            ,produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Reglement saveReglement(@RequestBody Reglement r) {
        try {
            return R.save(r);
        }
        catch (Exception e) {
            // Log the exception
            e.printStackTrace();

        }
        return r;
    }

    @PutMapping(value = "reglement/update/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Reglement updateReglement(@RequestBody Reglement r,@PathVariable Long id) {
        Optional<Reglement> update = R.findById(id);
        if (update.isPresent())
        {
            Reglement reglement = update.get();
            reglement.setMp(r.getMp());
            reglement.setDate(r.getDate());
            reglement.setType(r.getType());
            reglement.setCode(r.getCode());
            return R.save(reglement);

        }
        return null;
    }
    @PostMapping(value = "reglementFacture/add", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE },
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public ResponseEntity<?> saveReglementFacture(@RequestBody ReglementFacture r) {
        try {


            Facture facture = F.findById(r.getfacture().getIdF()).orElse(null);
            Reglement reglement = R.findById(r.getReglement().getId()).orElse(null);

            // Check if Facture or Reglement not found
            if (facture == null || reglement == null) {
                return ResponseEntity.badRequest().body("Facture or Reglement not found"+facture);
            }

            // Create and save ReglementFacture
            ReglementFacture reglementFacture = new ReglementFacture(facture, reglement, r.getMp());
            RF.save(reglementFacture);

            // Return a success response
            return ResponseEntity.ok("ReglementFacture added successfully");
        } catch (DataAccessException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error while saving ReglementFacture");
        }


    }
    @GetMapping(value = "reglementFacture/getAll", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public List<ReglementFacture> getAllRF() {
        return RF.findAll();
    }


}
