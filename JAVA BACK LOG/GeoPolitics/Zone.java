package GeoPolitics;

public class Zone {

    public static GeoPoliticalZones findZone(String stateName) {

        for (GeoPoliticalZones zone : GeoPoliticalZones.values()) {
            for (String state : zone.getStates()) {
                if (state.equalsIgnoreCase(stateName)) {
                    return zone;
                }
            }

    }
        return null;
    }
}