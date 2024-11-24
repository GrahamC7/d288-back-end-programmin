package com.d288.demo.bootstrap;

import com.d288.demo.dao.CustomerRepository;
import com.d288.demo.dao.DivisionRepository;
import com.d288.demo.entities.Customer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(DivisionRepository divisionRepository, CustomerRepository customerRepository) {
        this.divisionRepository = divisionRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() == 1) {
            Customer customer = new Customer("Graham", "Cracker", "1234 Heresville Pl", "56789", "(123) 567-8293", divisionRepository.findById(31L).get());
            Customer customer2 = new Customer("Bethany", "Howl", "900 Therestown Blvd", "92940", "(938) 849-8349", divisionRepository.findById(32L).get());
            Customer customer3 = new Customer("Edna", "Mae", "4829 VeryFarAway Ave", "92380", "(994) 739-9374", divisionRepository.findById(103L).get());
            Customer customer4 = new Customer("Samuel", "Tee", "80 WhereEvenIsThat Rd", "27291", "(759) 489-2901", divisionRepository.findById(47L).get());
            Customer customer5 = new Customer("Savannah", "Pompson", "903 Geewiz Way", "45778", "(356) 432-7789", divisionRepository.findById(102L).get());
            customerRepository.save(customer);
            customerRepository.save(customer2);
            customerRepository.save(customer3);
            customerRepository.save(customer4);
            customerRepository.save(customer5);

        }
    }
}
