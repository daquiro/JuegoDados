package org.example.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView iv_cpu, iv_player;

    TextView tv_cpu, tv_player;

    Random r;

    int cpuPoints = 0, playerPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iv_cpu = (ImageView) findViewById(R.id.iv_cpu);
        iv_player = (ImageView) findViewById(R.id.iv_player);

        tv_cpu = (TextView) findViewById(R.id.tv_cpu);
        tv_player = (TextView) findViewById(R.id.tv_player);

        r = new Random();
        iv_player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int cpuThrow = r.nextInt(6) + 1;
                int playerThrow = r.nextInt(6) + 1;

                setImageCPU(cpuThrow);
                setImagePlayer(playerThrow);

                if (cpuThrow > playerThrow) {
                    cpuPoints++;
                }
                if (playerThrow > cpuThrow) {
                    playerPoints++;
                }

                if (playerThrow == cpuThrow) {
                    Toast.makeText(MainActivity.this, "Draw!", Toast.LENGTH_SHORT).show();
                }

                tv_cpu.setText("CPU: " + cpuPoints);
                tv_player.setText("YOU: " + playerPoints);

                Animation rotate = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
                iv_cpu.startAnimation(rotate);
                iv_player.startAnimation(rotate);

            }
        });

    }

    public void setImageCPU(int num) {
        switch (num) {
            case 1:
                iv_cpu.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_cpu.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_cpu.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_cpu.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_cpu.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_cpu.setImageResource(R.drawable.dice6);
                break;
        }
    }

    public void setImagePlayer(int num) {
        switch (num) {
            case 1:
                iv_player.setImageResource(R.drawable.dice1);
                break;
            case 2:
                iv_player.setImageResource(R.drawable.dice2);
                break;
            case 3:
                iv_player.setImageResource(R.drawable.dice3);
                break;
            case 4:
                iv_player.setImageResource(R.drawable.dice4);
                break;
            case 5:
                iv_player.setImageResource(R.drawable.dice5);
                break;
            case 6:
                iv_player.setImageResource(R.drawable.dice6);
                break;
        }
    }

    static final String STATE_CPUPOINTS_SCORE = "cpuPoints";
    static final String STATE_PLAYERPOINTS_SCORE = "playerPoints";

    @Override public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(STATE_CPUPOINTS_SCORE, cpuPoints);
        savedInstanceState.putInt(STATE_PLAYERPOINTS_SCORE, playerPoints);
        super.onSaveInstanceState(savedInstanceState);
    }


}
