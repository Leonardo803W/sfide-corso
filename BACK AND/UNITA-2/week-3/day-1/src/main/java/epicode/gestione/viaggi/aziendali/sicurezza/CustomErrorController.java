package epicode.gestione.viaggi.aziendali.sicurezza;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import corretto
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, Model model) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");

        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString());
            model.addAttribute("statusCode", statusCode);
        }

        if (exception != null) {
            model.addAttribute("errorMessage", exception.getMessage());
        } else {
            model.addAttribute("errorMessage", "An unknown error occurred.");
        }

        return "error"; // Assicurati di avere una vista chiamata "error"
    }
}