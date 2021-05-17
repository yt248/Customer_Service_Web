package com.eugene.spring.boot.web.customer_service_web.service;


import com.eugene.spring.boot.web.customer_service_web.model.entity.Address;

import java.util.List;

public interface AddressService {

    /**
     * @return Получение всех адресов
     */
    List<Address> getAllAddress();

    /**
     * @param address Добавление нового адреса
     */
    void createAddress(Address address);

    /**
     * @param id - адреса для получения
     * @return полученный адрес
     */
    Address getAddressById(int id);

    /**
     * @param id            адреса для изменения
     * @param updateAddress измененный адрес
     */
    void updateAddress(int id, Address updateAddress);

    /**
     * @param id адреса для удаления
     */
    void deleteAddress(int id);

}
