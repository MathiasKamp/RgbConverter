package dk.zbc.rgbconverter;


import dk.zbc.rgbconverter.Contracts.PresenterModelContract;

/**
 * this class represents an RgbConverter which can convert rgb integer values to an hexadecimal string value
 */

public class RgbConverter implements PresenterModelContract.RgbConverter {

    PresenterModelContract.Presenter presenter;

    public RgbConverter(PresenterModelContract.Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * this method gets invoked by MainActivityPresenter and returns the hexadecimal value to MainActivityPresenter
     * @param red   : red value in integer min 0, max 255
     * @param green : green value in integer min 0, max 255
     * @param blue  : blue value in integer min 0 , max 255
     */
    @Override
    public void convertRgbToHex(int red, int green, int blue) {

        try{
        presenter.onSuccessConvertedToHex(String.format("#%02x%02x%02x", red, green ,blue));

        }catch (Exception e) {

            presenter.onErrorConvertedToHex("error converting : red:" + red + "green :"+ green + "blue :" + blue);
        }
    }
}
