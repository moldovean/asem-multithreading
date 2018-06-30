package club.cheapok.control;public class CarFactory{	public CarFactory()	{	}private club.cheapok.entity.Car createCar(final club.cheapok.boundary.Specification specification) {
        club.cheapok.entity.Car car = new club.cheapok.entity.Car();
        car.setId(java.util.UUID.randomUUID().toString());
        car.setColor(specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }}