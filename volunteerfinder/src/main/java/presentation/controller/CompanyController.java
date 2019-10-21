package presentation.controller;

import logic.Factory;
import model.Company;
import model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import presentation.view.CompanyViewModel;
import presentation.view.UserViewModel;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @PostMapping("")
    public ResponseEntity postCompany(@RequestBody CompanyViewModel companyViewModel) {
        Company company = new Company(companyViewModel.getName(),companyViewModel.getDescription(), companyViewModel.getImage());
        if (Factory.getCompanyLogic().postUser(company))
            return ResponseEntity.status(200).body("uploaded company to the database");
        return ResponseEntity.status(400).body("Something went Wrong");
    }

}
