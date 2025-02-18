package epicode.gestione.viaggi.aziendali.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@ControllerAdvice è utilizzata per definire una classe che fornisce un comportamento globale per tutti i controller dell'applicazione. Essa consente di gestire le eccezioni, le validazioni e le configurazioni comuni in un unico posto
//CustomErrorController viene utilizzata per specificare un metodo che gestisce le eccezioni lanciate da un controller

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public ResponseEntity<Object> handleError(HttpServletRequest request) {
        RuntimeException exception = (RuntimeException) request.getAttribute("javax.servlet.error.exception");
        throw exception;
    }
}