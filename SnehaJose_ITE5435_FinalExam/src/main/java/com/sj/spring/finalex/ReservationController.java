
package com.sj.spring.finalex;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationRepository repository;
  public ReservationController(ReservationRepository repository) {
  this.repository = repository;
}

    // Thymeleaf Form page
  @GetMapping("/")
  public String showForm(Model model) {
      Reservation reservation = new Reservation();
      reservation.setCustomer(new Customer()); 
      model.addAttribute("reservation", reservation);
      return "reservation_form";
  }


    // Handling form submission 
    @PostMapping("/reserve")
    public String submitReservation(@ModelAttribute Reservation reservation) {
        // Set customer and payment data from form input
        reservation.setCustomer(new Customer(null, reservation.getCustomer().getFirstName(),
                reservation.getCustomer().getLastName(), reservation.getCustomer().getPhoneNumber()));
        reservation.setPayment(new Payment(null, 150 * reservation.getPassengers(), reservation.getDate())); 
        repository.save(reservation);  // Save reservation to MongoDB
        return "success";  
    }

    // RESTful POST - Accept JSON input,Jackson handles it
    @PostMapping("/api/reserve")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        reservation.setCustomer(new Customer(null, reservation.getCustomer().getFirstName(),
                reservation.getCustomer().getLastName(), reservation.getCustomer().getPhoneNumber()));
        reservation.setPayment(new Payment(null, 150 * reservation.getPassengers(), reservation.getDate())); 
        Reservation savedReservation = repository.save(reservation);  // Save reservation to MongoDB
        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);  // Return saved reservation as JSON
    }

    //Return reservation as JSON
    @GetMapping("/api/reservations/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable String id) {
        Reservation reservation = repository.findById(id).orElse(null);
        if (reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 if reservation not found
        }
        return new ResponseEntity<>(reservation, HttpStatus.OK);  // Return reservation as JSON with 200 OK
    }
}
