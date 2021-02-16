import cleancode.Airport;
import cleancode.models.ClassificationLevel;
import cleancode.models.ExperimentalTypes;
import cleancode.models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import cleancode.planes.ExperimentalPlane;
import cleancode.planes.MilitaryPlane;
import cleancode.planes.PassengerPlane;
import cleancode.planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    @Test
    public void testGetTransportMilitaryPlanes() {
        Airport airport = new Airport(planes);

        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        List<MilitaryPlane> transportMilitaryPlanesFromTheList = airport.getMilitaryPlanes();
        transportMilitaryPlanesFromTheList.removeIf(militaryPlane -> militaryPlane.getType() != MilitaryType.TRANSPORT);
        Assert.assertEquals(transportMilitaryPlanes, transportMilitaryPlanesFromTheList);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        Airport airport = new Airport(planes);

        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        List<PassengerPlane> passengerPlanes = airport.getPassengerPlanes();
        PassengerPlane planeWithMaxPassengerCapacity = passengerPlanes.get(0);
        for (PassengerPlane passengerPlane : passengerPlanes) {
            if (passengerPlane.getPassengersCapacity() > planeWithMaxPassengerCapacity.getPassengersCapacity()) {
                planeWithMaxPassengerCapacity = passengerPlane;
            }
        }
        Assert.assertEquals(planeWithMaxPassengerCapacity, expectedPlaneWithMaxPassengersCapacity);
    }

    @Test
    public void testSortByMaxLoadCapacity() {
        Airport airport = new Airport(planes);

        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        for (int i = 1; i < planesSortedByMaxLoadCapacity.size(); i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane previousPlane = planesSortedByMaxLoadCapacity.get(i - 1);
            Assert.assertFalse(previousPlane.getMaxLoadCapacity() > currentPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        Airport airport = new Airport(planes);

        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes();
        Assert.assertNotEquals(bomberMilitaryPlanes.size(), 0);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        Airport airport = new Airport(planes);

        List<ExperimentalPlane> ExperimentalPlanes = airport.getExperimentalPlanes();
        for(ExperimentalPlane experimentalPlane : ExperimentalPlanes){
            Assert.assertNotSame(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
        }
    }
}
