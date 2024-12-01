package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pietakiewicz.sylwester.ZajavkaMed.business.PatientService;
import pietakiewicz.sylwester.ZajavkaMed.domain.Patient;

import java.security.Principal;
import java.time.format.DateTimeFormatter;

@Slf4j
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

    @RequestMapping(value = PROFILE, method = RequestMethod.POST)
    public String updateEmailOrPassword(
            Principal principal, Model model,
            @RequestParam(value = "newEmail", required = false) String newEmail,
            @RequestParam(value = "oldPassword", required = false) String oldPassword,
            @RequestParam(value = "newPassword", required = false) String newPassword,
            @RequestParam(value = "confirmPassword", required = false) String confirmPassword
    ) {

        String userName = principal.getName();
        patientData(model, userName);
        if (newEmail != null) {
            try {
                patientService.updateEmail(userName, newEmail);
                model.addAttribute("changeEmail", "change");
            } catch (RuntimeException e) {
                model.addAttribute("changeEmail", "notChange");
            }
        } else if (oldPassword != null && newPassword != null && confirmPassword != null) {
            try {
                boolean passwordCorrectness = patientService.updatePassword(userName, oldPassword, newPassword, confirmPassword);
                if (passwordCorrectness) {
                    model.addAttribute("changePassword", "change");
                } else {
                    model.addAttribute("changePassword", "incorrectlyPassword");
                }
            } catch (RuntimeException e) {
                model.addAttribute("changePassword", "notChange");
            }
        } else {
            log.info("User send blank form");
        }


        return "profile";
    }
}
