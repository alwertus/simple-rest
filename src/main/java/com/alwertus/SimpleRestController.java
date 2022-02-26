package com.alwertus;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class SimpleRestController {

    @GetMapping("")
    public List<RestResponse> keke() {
        return Arrays.asList(
                new RestResponse(0L,"title00", "descr0"),
                new RestResponse(1L, "title11", "descr1"),
                new RestResponse(2L, "title22", "descr2")
                );
    }
}
