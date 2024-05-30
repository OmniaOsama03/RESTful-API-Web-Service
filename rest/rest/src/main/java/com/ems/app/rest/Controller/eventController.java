package com.ems.app.rest.Controller;

import com.ems.app.rest.Model.Event;
import com.ems.app.rest.Respository.EventRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class eventController
{
    @GetMapping("/")
    public String getPage()
    {
        return "Hello there!";
    }


}
