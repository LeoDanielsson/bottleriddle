import model.Bottle;

/**
 * Created by danie_000 on 27/08/2015.
 */
public class BottleManager {
    public void fill(Bottle bottle) {
        bottle.setCurrentVolume(bottle.getMaxVolume());
    }

    public void empty(Bottle bottle) {
        bottle.setCurrentVolume(0);
    }

    public void pour(Bottle source, Bottle destination) {
        int volumeToPour = calculateVolumeToPour(source, destination);

        source.setCurrentVolume(source.getCurrentVolume() - volumeToPour);

        if(destination.getMaxVolume() <= destination.getCurrentVolume() + volumeToPour) {
            destination.setCurrentVolume(destination.getMaxVolume());
        } else {
            destination.setCurrentVolume(destination.getCurrentVolume() + volumeToPour);
        }
    }

    private static int calculateVolumeToPour(Bottle source, Bottle destination) {
        final int spaceInDestination = destination.getMaxVolume() - destination.getCurrentVolume();

        if(source.getCurrentVolume() > spaceInDestination) {
            return spaceInDestination;
        }
        return  source.getCurrentVolume();
    }

}


