package dk.zbc.rgbconverter.Contracts;

/**
 * this interface represents the contract between MainActivity and MainActivityPresenter
 */
public interface MainActivityContract {

    /**
     * this interface is used by MainActivityPresenter to pass data between MainActivity and MainActivityPresenter
     */
    interface View{

        /**
         * this method gets invoked when the MainActivityPresenter gets colorcode from its model layer
         * @param colorCode : the colorcode in hexadecimal
         */
        void onSuccess(String colorCode);

        /**
         * this method gets invoked when the MainActivityPresenter receives an error from its model layer.
         * @param message   : error message
         */
        void onError(String message);

    }

    /**
     * this interface is used by the MainActivity to pass data to MainActivityPresenter
     */
    interface Presenter{

        /**
         * this method is used to pass rgb values to MainActivityPresenter
         * @param red   : red value in integer min 0, max 255
         * @param green : green value in integer min 0, max 255
         * @param blue  : blue value in integer min 0 , max 255
         */
        void checkRgbValues(int red, int green, int blue);
    }
}
