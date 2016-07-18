package dl.subsystem;

import dl.entity.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class ValidatorAbstract implements Validator {

    @Autowired
    protected EntityManager em;
}
