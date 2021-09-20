package chang.ben.lab02embellishments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    int n = 0;
    boolean playing = false;
    TextView tv, tv2;
    EditText e_boy;
    Button buttonboy, buttonman, buttonsound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.text_box);
        tv2 = findViewById(R.id.text);
        e_boy = findViewById(R.id.edit_guy);
        buttonboy = findViewById(R.id.editor);
        buttonboy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tv.setText(e_boy.getText());
            }
        });
        Resources res = getResources();
        String[] chromatic = res.getStringArray(R.array.cyclist);
        buttonman = findViewById(R.id.stringcycle);
        buttonman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = (n+1)%chromatic.length;
                tv2.setText(chromatic[n]);
            }
        });

        MediaPlayer[] playarray = new MediaPlayer[12];
        playarray[0] = MediaPlayer.create(this, R.raw.a);
        playarray[1] = MediaPlayer.create(this, R.raw.bb);
        playarray[2] = MediaPlayer.create(this, R.raw.b);
        playarray[3] = MediaPlayer.create(this, R.raw.c);
        playarray[4] = MediaPlayer.create(this, R.raw.db);
        playarray[5] = MediaPlayer.create(this, R.raw.d);
        playarray[6] = MediaPlayer.create(this, R.raw.eb);
        playarray[7] = MediaPlayer.create(this, R.raw.e);
        playarray[8] = MediaPlayer.create(this, R.raw.f);
        playarray[9] = MediaPlayer.create(this, R.raw.gb);
        playarray[10] = MediaPlayer.create(this, R.raw.g);
        playarray[11] = MediaPlayer.create(this, R.raw.ab);
        buttonsound = findViewById(R.id.player);
        buttonsound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!playing) {
                    playarray[n].start();
                    buttonsound.setText("Stop");
                    playing = true;
                }
                else {
                    playarray[n].stop();
                    buttonsound.setText("Play");
                    playing = false;
                    playarray[n].reset();
                }

            }
        });


    }
}