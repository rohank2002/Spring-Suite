package accademy.ennate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DuplicateEmail extends RuntimeException{
    public DuplicateEmail(String message){
        super(message);
    }
}
