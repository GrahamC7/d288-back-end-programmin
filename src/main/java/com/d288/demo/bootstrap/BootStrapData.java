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

            Customer graham = new Customer();
            graham.setFirstName("Graham");
            graham.setLastName("Cracker");
            graham.setAddress("1234 Heresville Pl");
            graham.setPostal_code("56789");
            graham.setPhone("(123) 567-8293");
            graham.setDivision(divisionRepository.getReferenceById(51L));

            Customer beth = new Customer();
            beth.setFirstName("Beth");
            beth.setLastName("Howl");
            beth.setAddress("900 Therestown Blvd");
            beth.setPostal_code("23216");
            beth.setPhone("(938) 849-8349");
            beth.setDivision(divisionRepository.getReferenceById(52L));

            Customer edna = new Customer();
            edna.setFirstName("Edna");
            edna.setLastName("Mae");
            edna.setAddress("4829 VeryFarAway Ave");
            edna.setPostal_code("89274");
            edna.setPhone("(3214) 231-6543");
            edna.setDivision(divisionRepository.getReferenceById(53L));

            Customer sam = new Customer();
            sam.setFirstName("Sam");
            sam.setLastName("Tee");
            sam.setAddress("80 WhereEvenIsThat Rd");
            sam.setPostal_code("64346");
            sam.setPhone("(875) 354-7675");
            sam.setDivision(divisionRepository.getReferenceById(54L));

            Customer savannah = new Customer();
            savannah.setFirstName("Savannah");
            savannah.setLastName("Pompson");
            savannah.setAddress("903 Geewiz Way");
            savannah.setPostal_code("43252");
            savannah.setPhone("(745) 563-4342");
            savannah.setDivision(divisionRepository.getReferenceById(55L));

            customerRepository.save(graham);
            customerRepository.save(beth);
            customerRepository.save(edna);
            customerRepository.save(sam);
            customerRepository.save(savannah);
        }
    }
}
