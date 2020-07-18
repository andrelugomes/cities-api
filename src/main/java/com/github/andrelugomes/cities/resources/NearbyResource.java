package com.github.andrelugomes.cities.resources;

import com.github.andrelugomes.cities.entities.City;
import com.github.andrelugomes.cities.service.DistanceService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/nearby")
public class NearbyResource {

  private DistanceService distanceService;

  public NearbyResource(DistanceService distanceService) {
    this.distanceService = distanceService;
  }

  @GetMapping
  public List<City> nearby(@RequestParam(name = "city_id") final Long cityId,
                           @RequestParam(name = "radius") final Double radius) {

    return distanceService.nearby(cityId, radius);
  }
}
