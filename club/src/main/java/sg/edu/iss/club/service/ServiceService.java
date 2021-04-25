package sg.edu.iss.club.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import sg.edu.iss.club.domain.Service;

public interface ServiceService {
    public boolean saveService (Service service);

    public ArrayList<Service> findAllServices();
    public Optional <Service> findServiceById (Integer Id);

    public Service findServiceByIdNotOptional (Integer Id);

    public void deleteService(Service service);
}
