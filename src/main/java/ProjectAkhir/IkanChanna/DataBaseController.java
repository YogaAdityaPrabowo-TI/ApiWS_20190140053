
package ProjectAkhir.IkanChanna;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam; 


/**
 *
 * @author HP
 */

@CrossOrigin
@RestController
@RequestMapping(value = "/channa")
public class DataBaseController {

    @Autowired
    RipositoryIkanChanna repositoryIkanChanna;
            
    @PostMapping("/addchanna")
    public Channahomestay addchanna(@RequestBody Channahomestay Param)
    {
        repositoryIkanChanna.save(Param);
        return Param;
    }
    
    @GetMapping("/allchanna")
    public List<Channahomestay> allchanna()
    {
        return repositoryIkanChanna.findAll();
    }
    
    @GetMapping("/allchannabyid")
    public Channahomestay getthrift(@RequestParam int id)
    {
        return repositoryIkanChanna.findById(id).get();
    }
    
    @PutMapping("/updatechanna")
    public Channahomestay updatechanna(@RequestBody Channahomestay Param)
    {
       return repositoryIkanChanna.save(Param);
    }
    
    @DeleteMapping("/hapuschanna")
    public List<Channahomestay> hapuschanna(@RequestParam int id)
    {
        repositoryIkanChanna.deleteById(id);
        List<Channahomestay> channalist = repositoryIkanChanna.findAll();
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

