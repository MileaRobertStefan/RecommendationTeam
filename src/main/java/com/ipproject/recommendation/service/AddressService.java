package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.User;
import com.ipproject.recommendation.repository.AddressRepository;
import com.ipproject.recommendation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AddressService {

    @Autowired
    private AddressRepository repository;

    public List<Address> getAllAddresses() {
        List<Address> addresses = repository.findAll();
        if (addresses.size() > 0) {
            return addresses;
        } else {
            return new ArrayList<>();
        }
    }


    public Address createOrUpdate(Address address){
        address.setCity("Tecuci");
        address.setCountry("Romanica");
        address.setId(UUID.randomUUID());
        address.setStreetName("da");
        address.setStreetNumber(1);

        address = repository.save(address);
        return address;
    }


}
