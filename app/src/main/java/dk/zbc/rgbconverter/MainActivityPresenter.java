package dk.zbc.rgbconverter;

import dk.zbc.rgbconverter.Contracts.MainActivityContract;
import dk.zbc.rgbconverter.Contracts.PresenterModelContract;

/**
 * this class represents the presenter between MainActivity and models
 */

public class MainActivityPresenter implements MainActivityContract.Presenter, PresenterModelContract.Presenter {

    private final MainActivityContract.View view;

    private final PresenterModelContract.RgbConverter rgbConverter;

    public MainActivityPresenter(MainActivityContract.View view)
    {
        this.view = view;
        this.rgbConverter = new RgbConverter(this);
    }

    /**
     * this method collects the rgb values from MainActivity and pass it along to RgbConverter
     * @param red   : red value in integer min 0, max 255
     * @param green : green value in integer min 0, max 255
     * @param blue  : blue value in integer min 0 , max 255
     */
    @Override
    public void checkRgbValues(int red, int green, int blue) {

        rgbConverter.convertRgbToHex(red, green,blue);
    }

    /**
     * this method collects the colorcode returned from the RgbConverter and passes the colorcode string along to MainActivity
     * @param rgbHexValue   : string value of a colorcode in hex. eg. red = #FF0000
     */
    @Override
    public void onSuccessConvertedToHex(String rgbHexValue) {

        view.onSuccess(rgbHexValue);
    }

    /**
     * this method collects the error code returned from the RgbConverter and passes it along to the MainActivity
     * @param error : string value of the error message
     */
    @Override
    public void onErrorConvertedToHex(String error) {

        view.onError(error);
    }
}
