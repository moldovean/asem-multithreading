package club.cheapok.boundary;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("carsJson")
public class CarJSONResource {

    @Inject
    CarManufacturer carManufacturer;

    @GET
    public JsonArray getCars() {
        return carManufacturer.retrieveCars()
                              .stream()
                              .map(car -> Json.createObjectBuilder()
                                              .add("engine", car.getEngineType().name())
                                              .add("color", car.getColor().name())
                                              .build())
                              .collect(JsonCollectors.toJsonArray());

    }
}
