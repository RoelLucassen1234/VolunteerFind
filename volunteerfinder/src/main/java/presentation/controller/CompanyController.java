package presentation.controller;

import logic.Factory;
import model.Company;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import presentation.view.CompanyViewModel;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @PostMapping("")
    public ResponseEntity postCompany(@RequestBody CompanyViewModel companyViewModel) {
        Company company = new Company(companyViewModel.getName(),companyViewModel.getDescription(), companyViewModel.getImage());
        if (Factory.getCompanyLogic().postCompany(company))
            return ResponseEntity.status(200).body("uploaded company to the database");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

    @GetMapping("/{companyId}")
    public ResponseEntity getCompany(@PathVariable int companyId) {

        Company company = Factory.getCompanyLogic().getCompany(companyId);
        if (company != null) {
            return ResponseEntity.ok(company);
        }
        return ResponseEntity.status(404).body("company does not exist.");
    }

    @DeleteMapping("/delete/{companyId}")
    public ResponseEntity deleteCompany(@PathVariable int companyId) {
        if (Factory.getCompanyLogic().deleteCompany(companyId)) {
            return ResponseEntity.ok("company was deleted");
        }
        return ResponseEntity.status(404).body("company was not deleted or never existed in the first place");
    }


}
