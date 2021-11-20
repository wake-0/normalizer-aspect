package com.example.normalizeraspect.aspect.argnormalizers;

import com.example.normalizeraspect.model.Vehicle;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Type;

@Component
class VehicleArgNormalizer implements ArgNormalizer<Vehicle> {

    @Override
    public Vehicle normalize(Vehicle obj) {
        Vehicle vehicle = new Vehicle();

        final String plateCountry = obj.getPlateCountry();
        if (StringUtils.hasText(plateCountry)) {
            vehicle.setPlateCountry(plateCountry.toUpperCase());
        }

        vehicle.setPlateValue(obj.getPlateValue());
        return vehicle;
    }

    @Override
    public Type getNormalizedType() {
        return Vehicle.class;
    }
}