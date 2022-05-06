package dk.zbc.rgbconverter.Contracts;

/**
 * this interface contract is used between MainActivityPresenter and its model layer
 */
public interface PresenterModelContract {

    /**
     * this interface is used by the model layer to pass data to the MainActivityPresenter
     */
    interface Presenter{

        /**
         * this method is used to return the converted hexadecimal value to the MainActivityPresenter
         * @param rgbHexValue   : string value of a colorcode in hex. eg. red = #FF0000
         */
        void onSuccessConvertedToHex(String rgbHexValue);

        /**
         * this method is used to return an error which has occurred when trying to convert to hexadecimal
         * @param error : string value of the error message
         */
        void onErrorConvertedToHex(String error);
    }

    /**
     * this interface is used by the MainActivityPresenter to pass data to RgbConverter
     */
    interface RgbConverter{

        void convertRgbToHex(int red, int green, int blue);
    }
}