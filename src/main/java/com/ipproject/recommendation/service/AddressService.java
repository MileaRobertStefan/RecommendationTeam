package com.ipproject.recommendation.service;

import com.ipproject.recommendation.models.Address;
import com.ipproject.recommendation.models.Contact;
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

    public Address getOneAddress(UUID id) {
        return repository.findAddressById(id);
    }

    public Address createOrUpdate(Address address, String city, String country, String streetName, Integer streetNumber) {
        address.setCity(city);
        address.setCountry(country);
        address.setId(UUID.randomUUID());
        address.setStreetName(streetName);
        address.setStreetNumber(streetNumber);

        address = repository.save(address);
        return address;
    }


}
