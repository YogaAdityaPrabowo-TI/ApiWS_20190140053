
package ProjectAkhir.IkanChanna;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author HP
 */

@RestController
@RequestMapping(value = "/channa")
public class DataBaseController {

    @GetMapping("/channa")
    @ResponseBody
    public List<Channa> getChanna(){
        
        List<Channa> channa = new ArrayList<>();
        
        ChannaJpaController controller = new ChannaJpaController();
        
        try{
            channa = controller.findChannaEntities();
        } catch (Exception e) {}
        
        return channa;
    }
}

