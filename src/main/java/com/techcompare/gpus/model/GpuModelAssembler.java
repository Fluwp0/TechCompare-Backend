package com.techcompare.gpus.model;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;
import com.techcompare.gpus.controller.GpuController;

@Component
public class GpuModelAssembler implements RepresentationModelAssembler<Gpu, EntityModel<Gpu>> {

    @Override
    public EntityModel<Gpu> toModel(Gpu gpu) {
        return EntityModel.of(gpu,
                linkTo(methodOn(GpuController.class).one(gpu.getId())).withSelfRel(),
                linkTo(methodOn(GpuController.class).all()).withRel("gpus")
        );
    }
}
