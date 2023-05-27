package com.adaskalov.parts.domain.service;

import com.adaskalov.parts.domain.exceptions.PartNotFoundException;
import com.adaskalov.parts.domain.models.Part;
import com.adaskalov.parts.domain.models.PartNumber;

import java.util.List;

public interface PartService {
    Part findById(PartNumber id) throws PartNotFoundException;

    Part createProduct(Part part);


    Part cartItemAdded(PartNumber partNumber, int quantity) throws PartNotFoundException;

    Part cartItemRemoved(PartNumber partNumber, int quantity) throws PartNotFoundException;
    List<Part> getAll();
}
