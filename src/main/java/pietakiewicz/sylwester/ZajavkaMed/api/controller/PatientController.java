package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pietakiewicz.sylwester.ZajavkaMed.business.PatientService;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

@Controller
@AllArgsConstructor
public class PatientController {

    private final String PATIENT = "/patient";
    private final String PROFILE = "/profile";

    private final PatientService patientService;

    private void patientData(Model model, String userName) {
        Patient patient = patientService.findPatientByUserName(userName);
        model.addAttribute("patient", patient);
        model.addAttribute("username", "@"+ userName);
        model.addAttribute("dateOfBirthday", patient.getBirthday().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
    }

    @RequestMapping(value = PROFILE, method = RequestMethod.GET)
    public String profile(Principal principal, Model model){

        String userName = principal.getName();
        patientData(model, userName);
        model.addAttribute("changeEmail", "");

        return "profile";
    }

    @RequestMapping(value = PROFILE+"/change-email", method = RequestMethod.POST)
    public String updateEmail(@RequestParam("newEmail") String newEmail, Principal principal, Model model){

        String userName = principal.getName();
        patientData(model, userName);
        try {
            patientService.updateEmail(userName, newEmail);
            model.addAttribute("changeEmail", "change");
        } catch (RuntimeException e) {
            model.addAttribute("changeEmail", "notChange");
        }
        return "profile";
    }
}
