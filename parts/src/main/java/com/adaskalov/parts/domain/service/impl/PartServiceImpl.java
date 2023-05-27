package com.adaskalov.parts.domain.service.impl;

import com.adaskalov.parts.domain.exceptions.PartNotFoundException;
import com.adaskalov.parts.domain.models.Part;
import com.adaskalov.parts.domain.models.PartNumber;
import com.adaskalov.parts.domain.repository.PartRepository;
import com.adaskalov.parts.domain.service.PartService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartService {

    private final PartRepository repository;

    public PartServiceImpl(PartRepository repository) {
        this.repository = repository;
    }

    @Override
    public Part findById(PartNumber id) throws PartNotFoundException {
        return repository.findById(id).orElseThrow(PartNotFoundException::new);
    }

    @Override
    public Part createProduct(Part part) {
        return repository.save(part);
    }

    @Override
    public Part cartItemAdded(PartNumber partNumber, int quantity) throws PartNotFoundException {
        Part part = repository.findById(partNumber).orElseThrow(PartNotFoundException::new);
        part.removeNumberInStock(quantity);
        return part;
    }

    @Override
    public Part cartItemRemoved(PartNumber partNumber, int quantity) throws PartNotFoundException {
        Part part = repository.findById(partNumber).orElseThrow(PartNotFoundException::new);
        part.addNumberInStock(quantity);
        return part;
    }

    @Override
    public List<Part> getAll() {
        return repository.findAll();
    }
}
