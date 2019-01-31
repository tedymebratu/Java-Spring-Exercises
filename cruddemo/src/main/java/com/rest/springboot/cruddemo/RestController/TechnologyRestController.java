package com.rest.springboot.cruddemo.RestController;

import com.rest.springboot.cruddemo.Entity.Technology;
import com.rest.springboot.cruddemo.Entity.User;
import com.rest.springboot.cruddemo.Service.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TechnologyRestController {
    private TechnologyService technologyService;

    @Autowired
    public TechnologyRestController(TechnologyService theTechnologyService){
        technologyService=theTechnologyService;
    }

    //List technologies
    @GetMapping("/technologies")
    public List<Technology> findAll(){
        return technologyService.findAll();
    }

    //List technology by id
    @GetMapping("/technologies/{technologyId}")
    public Technology getTechnolog(@PathVariable int technologyId){
        Technology technology= technologyService.findById(technologyId);

        if(technology == null){
            throw new RuntimeException("Technology id not found - "+ technologyId);
        }

        return technology;
    }

    //Add technology
    @PostMapping("/technologies")
    public Technology addTechnology(@RequestBody Technology theTechnology){
        theTechnology.setId(0);
        technologyService.save(theTechnology);

        return theTechnology;
    }

    //Modify technology
    @PutMapping("/technologies/{technologyId}")
    public Technology updateTechnology(@PathVariable int technologyId){
       Technology theTechnology= technologyService.findById(technologyId);

        if(theTechnology == null) {
            throw new RuntimeException("User Id not found "+technologyId);
        }

        technologyService.save(theTechnology);
        return theTechnology;
    }

    //Delete technology
    @DeleteMapping("/technologies/{technologyId")
    public String deleteTechnology(@PathVariable int technologyId){
        Technology theTechnology=technologyService.findById(technologyId);

        if(theTechnology == null) {
            throw new RuntimeException("Technology id not found - "+ technologyId);
        }

        technologyService.deleteById(technologyId);

        return "Deleted technology id -"+technologyId;
    }
}
