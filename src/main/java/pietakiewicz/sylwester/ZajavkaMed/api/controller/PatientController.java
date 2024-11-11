package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pietakiewicz.sylwester.ZajavkaMed.business.PatientService;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.security.Principal;

@Controller
@AllArgsConstructor
public class PatientController {

    private final String PATIENT = "/patient";

    private final PatientService patientService;

    @GetMapping(value = PATIENT)
    public String homePage(Principal principal, Model model){
        Patient patient = patientService.findPatientByUserName(principal.getName());

        model.addAttribute("patient", patient);

        return "profile";
    }
}
