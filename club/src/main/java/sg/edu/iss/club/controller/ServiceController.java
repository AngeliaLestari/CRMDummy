package sg.edu.iss.club.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.edu.iss.club.domain.Customer;
import sg.edu.iss.club.domain.Service;
import sg.edu.iss.club.service.ServiceService;
import sg.edu.iss.club.service.ServiceServiceImpl;

@Controller
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private ServiceService fservice;

    @Autowired
    public void setFacilityService(ServiceServiceImpl fserviceImpl) {
        this.fservice = fserviceImpl;
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("service", fservice.findAllServices());
        return "service";
    }

    @RequestMapping(value = "/add")
    public String addForm(Model model) {
        //model.addAttribute("service",fservice.findAllServices());
        model.addAttribute("service", new Service());
        return "service-form";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("service", fservice.findServiceById(id));
        return "service-form";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteService (@PathVariable("id") Integer id) {

        fservice.deleteService(fservice.findServiceByIdNotOptional(id));
        return "forward:/service/list";
    }


    @RequestMapping(value = "/save")
    public String saveCustomer (@ModelAttribute("service")  @Valid Service service,
                                BindingResult bindingResult, Model model){

        if (bindingResult.hasErrors()) {
            return "service-form";
        }
        fservice.saveService(service);
        return "forward:/service/list";

    }

}
