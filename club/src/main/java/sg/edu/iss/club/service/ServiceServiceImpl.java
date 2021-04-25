package sg.edu.iss.club.service;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import sg.edu.iss.club.domain.Service;
import sg.edu.iss.club.repo.ServiceRepository;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

    @Autowired
    ServiceRepository frepo;

    @Transactional
    public boolean saveService(Service service) {
        if (frepo.save(service) != null) return true;
        else return false;
    }

    @Transactional
    public ArrayList<Service> findAllServices() {
        return (ArrayList<Service>) frepo.findAll();
    }

    @Transactional
    public Optional<Service> findServiceById(Integer Id) {
        return frepo.findById(Id);
    }

    @Transactional
    public Service findServiceByIdNotOptional (Integer Id)
    {
        return frepo.findById(Id).get();
    }

    @Transactional
    public void deleteService(Service service)
    {
        frepo.delete(service);
    }
}