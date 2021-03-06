package com.clayton.service.booking.impl;


import com.clayton.domain.booking.Booking;
import com.clayton.repositories.booking.BookingRepository;
import com.clayton.service.booking.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("BookingServiceImpl")
public class BookingServiceImpl implements BookingService {

    private BookingServiceImpl service = null;
    @Autowired
    private BookingRepository repository;

    public BookingServiceImpl() {

        //this.repository = BookingRepositoryImpl.getBookingRepo();

    }

    public BookingServiceImpl getService() {

        if (service == null){

            return new BookingServiceImpl();

        }
        return service;

    }

    @Override
    public Set<Booking> getAll() {

        List<Booking> bookingList = (List<Booking>) repository.findAll();
        return new HashSet<>(bookingList);

    }

    @Override
    public Booking create(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public Booking read(Integer integer) {

        return repository.findById(integer).orElse(null);

    }

    @Override
    public Booking update(Booking booking) {
        return repository.save(booking);
    }

    @Override
    public void delete(Integer integer) {

        repository.deleteById(integer);

    }
}
