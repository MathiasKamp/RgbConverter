package dk.zbc.rgbconverter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.graphics.Color;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import dk.zbc.rgbconverter.Contracts.MainActivityContract;

/**
 * MainActivity of an RgbCalculator application
 */
public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    Slider slider_red, slider_green, slider_blue;
    Button btn_showColor;
    private static final String TAG = "MainActivity";
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private MainActivityContract.Presenter presenter;


    /**
     * Instance of a onSliderTouchListener
     */
    @SuppressLint("RestrictedApi")
    private final Slider.OnSliderTouchListener onSliderTouchListener = new Slider.OnSliderTouchListener(){
        @Override
        public void onStartTrackingTouch(@NonNull Slider slider) {

        }

        /**
         * This method gets invoked when a user stops dragging the slider ball.
         * I check in this method which slider that was dragged so that i can use this method for all 3 sliders.
         * @param slider    : return the slider and its new value
         */
        @Override
        public void onStopTrackingTouch(@NonNull Slider slider) {

            int sliderValue = Math.round(slider.getValue());

            if (slider == slider_red) {
                red = sliderValue;
            }

            if (slider == slider_blue) {
                blue = sliderValue;
            }

            if (slider == slider_green) {
                green = sliderValue;
            }
            presenter.checkRgbValues(red,blue,green);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        slider_red = findViewById(R.id.slider_red);
        slider_green = findViewById(R.id.slider_green);
        slider_blue = findViewById(R.id.slider_blue);
        btn_showColor = findViewById(R.id.btn_showColor);
        presenter = new MainActivityPresenter(this);


        slider_red.addOnSliderTouchListener(onSliderTouchListener);
        slider_blue.addOnSliderTouchListener(onSliderTouchListener);
        slider_green.addOnSliderTouchListener(onSliderTouchListener);

    }

    @Override
    public void onSuccess(String colorCode) {

        Log.d(TAG, "onSuccess: " + colorCode);

        btn_showColor.setBackgroundColor(Color.parseColor(colorCode));
    }

    @Override
    public void onError(String message) {

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}