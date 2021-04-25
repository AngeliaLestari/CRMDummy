package sg.edu.iss.club.controller;

import javax.persistence.Id;
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
import sg.edu.iss.club.service.CustomerService;
import sg.edu.iss.club.service.CustomerServiceImpl;
import sg.edu.iss.club.service.ServiceService;
import sg.edu.iss.club.service.ServiceServiceImpl;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService mservice;
    @Autowired
    private ServiceService fservice;

    @Autowired
    public void setCustomerService(CustomerServiceImpl mserviceImpl, ServiceServiceImpl fserviceImpl)
    {
        this.mservice = mserviceImpl;
        this.fservice = fserviceImpl;
    }

    @RequestMapping(value = "/list")
    public String list(Model model) {
        model.addAttribute("customer", mservice.findAllCustomer());
        model.addAttribute("service",fservice.findAllServices());
        return "customer";
    }

    @RequestMapping(value = "/add")
    public String addForm(Model model) {
        //ArrayList<Service> service = fservice.findAllServices();
        model.addAttribute("service",fservice.findAllServices());
        model.addAttribute("customer", mservice.findAllCustomer());
        model.addAttribute("customer", new Customer());
        return "customer-form";
    }

    @RequestMapping(value = "/edit/{id}")
    public String editForm(@PathVariable("id") Integer id, Model model) {
        model.addAttribute("customer", mservice.findCustomerById(id));
        model.addAttribute("service",fservice.findAllServices());
        return "customer-form";
    }

    @RequestMapping(value = "/save")
    public String saveCustomer (@ModelAttribute("customer") @Valid Customer customer, @Valid Service service,
                                BindingResult bindingResult, Model model){
                                //@RequestParam Integer Id)
        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        Service properService =
                fservice
                .findServiceById(service.getServiceId())
                .orElse(service);
        customer.setService(properService);


        mservice.saveCustomer(customer);

        //customer.setService(fservice.findServiceById(Id).get());
        return "forward:/customer/list";

    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteCustomer (@PathVariable("id") Integer id) {
        mservice.deleteCustomer(mservice.findCustomerById(id));
        return "forward:/customer/list";
    }

}
