package pietakiewicz.sylwester.ZajavkaMed.api.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pietakiewicz.sylwester.ZajavkaMed.business.AppointmentService;
import pietakiewicz.sylwester.ZajavkaMed.domain.Appointment;
import pietakiewicz.sylwester.ZajavkaMed.domain.AppointmentStatus;

import java.security.Principal;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
public class AppointmentController {

    private final String APPOINTMENT = "/appointment";

    private AppointmentService appointmentService;

    private static List<AppointmentStatus> appointmentStatusList() {
        return List.of(AppointmentStatus.PLANNED, AppointmentStatus.IN_PROGRESS, AppointmentStatus.CANCELED, AppointmentStatus.CANCELED);
    }

    @RequestMapping(value = APPOINTMENT, method = RequestMethod.GET)
    public String appointmentList(Principal principal, Model model){
        String userName = principal.getName();
        List<Appointment> appointments = appointmentService.findAppointmentsByPatientUserName(userName);

        model.addAttribute("appointmentStatus", appointmentStatusList());
        model.addAttribute("appointmentList", appointments);

        return "appointment";
    }

    @RequestMapping(value = APPOINTMENT+"/{filtersValue}", method = RequestMethod.GET)
    public String appointmentList(@PathVariable AppointmentStatus filtersValue, Principal principal, Model model){
        String userName = principal.getName();
        List<Appointment> appointments = appointmentService.findAppointmentsByPatientUserNameWithStatus(userName, filtersValue);

        model.addAttribute("appointmentStatus", appointmentStatusList());
        model.addAttribute("appointmentList", appointments);

        return "appointment";
    }
}