package com.eugene.spring.boot.web.customer_service_web.controller;

import com.eugene.spring.boot.web.customer_service_web.dto.AddressDto;
import com.eugene.spring.boot.web.customer_service_web.dto.CustomerDto;
import com.eugene.spring.boot.web.customer_service_web.dto.mappers.CustomerMapper;
import com.eugene.spring.boot.web.customer_service_web.entity.Customer;
import com.eugene.spring.boot.web.customer_service_web.service.AddressService;
import com.eugene.spring.boot.web.customer_service_web.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final AddressService addressService;

    @Autowired
    public CustomerController(CustomerService customerService, AddressService addressService) {
        this.customerService = customerService;
        this.addressService = addressService;
    }


    //-----------------------------Поиск клиента по имени и фамилии ----------------------
    @GetMapping("/search")
    public String searchCustomerByNameAndSurname(@RequestParam("name") String name,
                                                 @RequestParam("surname") String surname, Model model) {
        List<Customer> customerList = customerService.getCustomerByNameAndAddress(name, surname);
        model.addAttribute("customerList", customerList);
        return "customer/customer-index-search";
    }

    //-----------------------------Отображение всех клиентов без ДТО ----------------------

    @GetMapping("/")
    public String getAllCustomers(Model model) {
        List<Customer> customerList = customerService.getAllCustomer();
        List<CustomerDto> customerDtoList = customerList.stream().map(CustomerMapper::toDto).collect(Collectors.toList());
        model.addAttribute("customerDtoList", customerDtoList);
        return "customer/customer-index";
    }

    //-----------------------------Создание клиента с использованием ДТО ----------------------

    @GetMapping("/create")
    public String createCustomer(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        return "customer/customer-add";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customerDto") CustomerDto customerDto,
                               @RequestParam("cityName") String cityName,
                               @RequestParam("streetName") String streetName,
                               @RequestParam("houseNumber") String houseNumber) {

        AddressDto addressDto = new AddressDto();
        addressDto.setCityName(cityName);
        addressDto.setStreetName(streetName);
        addressDto.setHouseNumber(houseNumber);

        customerDto.setAddressDto(addressDto);

        customerService.createCustomer(customerDto);
        return "redirect:/customers/";
    }

    //-----------------------------Удаление клиента ----------------------
    @GetMapping(value = "/delete/")
    public String deleteCustomerById(@RequestParam int id) {
        customerService.deleteCustomer(id);
        return "redirect:/customers/";
    }


    //-----------------------------Обновление фактического адреса клиента  ----------------------
    @RequestMapping("/updateAddressToCustomer")
    public String updateAddressToCustomer(@RequestParam int id, Model model) {
        CustomerDto customerDto = CustomerMapper.toDto(customerService.getCustomerById(id));
        AddressDto addressDto = customerDto.getAddressDto();
        model.addAttribute("customerDto", customerDto);
        model.addAttribute("addressDto", addressDto);

        return "customer/customer-update";
    }


    //    @PostMapping("/saveUpdateAddress")
    @PostMapping("/updateAddressToCustomer/saveUpdateAddress")
    public String saveUpdateAddress(@RequestParam("customerDtoId") int id,
                                    @ModelAttribute("addressDto") AddressDto addressDto) {

        customerService.updateAddressToCustomer(id, addressDto);

        return "redirect:/customers/";
    }

}
