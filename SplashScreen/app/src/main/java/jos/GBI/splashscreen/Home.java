package jos.GBI.splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class Home extends AppCompatActivity {
    ViewFlipper v_flipper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        int images [] ={R.drawable.pemandangan, R.drawable.pemandangan2, R.drawable.pemandangan3, R.drawable.pemandangan4};
        v_flipper=findViewById(R.id.v_flipper);

        //for loop
        for(int image:images){
            flipperImages(image);
        }


    }
    public void flipperImages (int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000); //3sec
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

}
