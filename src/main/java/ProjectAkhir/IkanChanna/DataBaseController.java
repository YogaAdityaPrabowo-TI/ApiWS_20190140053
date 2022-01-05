
package ProjectAkhir.IkanChanna;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 *
 * @author HP
 */

@RestController
@RequestMapping(value = "/channa")
public class DataBaseController {

    @Autowired
    RipositoryIkanChanna repositoryIkanChanna;
            
    @PostMapping(value = "/addchanna")
    public Channa addchanna(@RequestBody Channa Param)
    {
        repositoryIkanChanna.save(Param);
        return Param;
    }
    
    @GetMapping(value = "/allchanna")
    public List<Channa> allchanna()
    {
        return repositoryIkanChanna.findAll();
    }
    
    @PutMapping(value = "/updatechanna")
    public Channa updatechanna(@RequestBody Channa Param)
    {
       return repositoryIkanChanna.save(Param);
    }
    
    @DeleteMapping(value = "/hapuschanna")
    public List<Channa> hapuschanna(@RequestParam int id)
    {
        repositoryIkanChanna.deleteById(id);
        List<Channa> channalist = repositoryIkanChanna.findAll();
        return channalist;
    }
}
    
//    @GetMapping("/channa")
//    @ResponseBody
//    public List<Channa> getChanna(){
//        
//        List<Channa> channa = new ArrayList<>();
//        
//        ChannaJpaController controller = new ChannaJpaController();
//        
//        try{
//            channa = controller.findChannaEntities();
//        } catch (Exception e) {}
//        
//        return channa;
//    }
//}

