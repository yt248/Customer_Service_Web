package com.eugene.spring.boot.web.customer_service_web.service;

import com.eugene.spring.boot.web.customer_service_web.model.entity.Address;
import com.eugene.spring.boot.web.customer_service_web.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public List<Address> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    @Transactional
    public void createAddress(Address address) {
        if (address != null) {
            addressRepository.save(address);
        }
    }

    @Override
    @Transactional
    public Address getAddressById(int id) {
        Optional<Address> optional = addressRepository.findById(id);
        Address address = new Address();
        if (optional.isPresent())
            address = optional.get();

        return address;
    }

    @Override
    @Transactional
    public void updateAddress(int id, Address updateAddress) {
        if(addressRepository.existsById(id)){
            updateAddress.setId(id);
            addressRepository.save(updateAddress);
        }
    }

    @Override
    @Transactional
    public void deleteAddress(int id) {
        Address address = getAddressById(id);
        addressRepository.delete(address);
    }


}
