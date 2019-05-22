package ro.ale.finalproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import ro.ale.finalproject.model.Trip;
import ro.ale.finalproject.model.User;
import ro.ale.finalproject.service.AutoLoginService;
import ro.ale.finalproject.service.TripService;
import ro.ale.finalproject.service.UserService;


import javax.validation.Valid;
import java.util.List;

/**
 * Trip Controller handle the request for Trip page
 *
 *@author Alexandra Buda
 */
@Controller
public class TripController {

    @Autowired
    TripService tripService;

    @Autowired
    UserService userService;

    @Autowired
    AutoLoginService autoLoginService;

    /**
     * show the addtrip page
     *
     * @param model is used to provide the attributes for the view
     * @return the addtrip page
     */
    @GetMapping(path = "/add")
    public String showAddTripPage(Model model) {
        model.addAttribute("trip", new Trip());
        return "addtrip";
    }

    /**
     * save the trips details
     *
     * @param firstImg
     * @param secondImg
     * @param trip the model attribute
     * @param bindingResult the argument used to validate the entered data
     * @return the redirect trips page
     */

    @PostMapping(path = "/add")
    public String saveTrip(@RequestParam("uploadFirstPhoto") MultipartFile firstImg,
                           @RequestParam("uploadSecondPhoto") MultipartFile secondImg, @ModelAttribute("trip")
                           @Valid Trip trip, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addtrip";
        }

        try {
            tripService.savePhoto(firstImg);
            tripService.savePhoto(secondImg);
        } catch (Exception e) {
            e.printStackTrace();
            return "addtrip";
        }

        trip.setUser(userService.findByUsername(userService.findLoggedInUser()));
        trip.setFirstPhoto(firstImg.getOriginalFilename());
        trip.setSecondPhoto(secondImg.getOriginalFilename());

        tripService.saveTrip(trip);
        return "redirect:/trips";
    }

    /**
     * show the trips page based on the user id
     *
     * @param tripId
     * @return
     */
    @GetMapping("/trips")
    public ModelAndView showTripPage(@RequestParam(name = "myOption", required = false) Integer tripId) {

        User user = userService.findByUsername(userService.findLoggedInUser());
        List<Trip> trips = tripService.findTripByUser(user.getId());

        if (trips.isEmpty())
            return new ModelAndView("redirect:/add");

        ModelAndView mv = new ModelAndView("trips");
        mv.addObject("trips", trips);

        if (tripId == null) {
            mv.addObject("selectedTrip", trips.get(0));
        } else {
            Trip selectTrip = new Trip();
            for (Trip trip : trips)
                if (trip.getTripId() == tripId)
                    selectTrip = trip;
            mv.addObject("selectedTrip", selectTrip);
        }

        return mv;
    }

    /**
     * deletes the trip based on the trip id
     *
     * @param tripId the trip id which will be deleted
     * @return redirect to trips page
     */
    @PostMapping("/delete")
    public String removeTrip(@RequestParam(name = "idTrip", required = false) Integer tripId) {
        tripService.removeTripById(tripId);
        return "redirect:/trips";
    }
}

