package com.clayton.controller.booking;


import com.clayton.domain.booking.Booking;
import com.clayton.service.booking.impl.BookingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    @Qualifier("BookingServiceImpl")
    private BookingServiceImpl bookingService;


    @PostMapping("/new")
    public Booking create(@RequestBody Booking booking){

        return bookingService.create(booking);

    }

    @GetMapping(path = "/find/{id}")
    public Booking findById(@PathVariable int id){

        Booking bk = bookingService.read(id);
        return bk;

    }

    @PutMapping("/update")
    public void update(@RequestBody Booking booking){

        bookingService.update(booking);

    }

    @DeleteMapping(path ="/delete/{id}")
    public void delete(@PathVariable int id){

        bookingService.delete(id);

    }

    @GetMapping("/getAll")
    public Set<Booking> getAll(){

        return bookingService.getAll();

    }


}
