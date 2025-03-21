package epicode.blog.ecxeptions;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ErrorsPayload {

    private String message;
    private LocalDateTime timestamp;
}

