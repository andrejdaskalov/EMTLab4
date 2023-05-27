package com.adaskalov.parts.rest;

import com.adaskalov.parts.domain.models.Part;
import com.adaskalov.parts.domain.service.PartService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/part")
@AllArgsConstructor
public class PartsController {
    private final PartService partService;

    @GetMapping
    public List<Part> getAll(){
        return partService.getAll();
    }
}
