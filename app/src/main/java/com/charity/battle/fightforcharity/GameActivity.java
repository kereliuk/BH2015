package com.charity.battle.fightforcharity;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Scanner;

import static android.widget.Toast.LENGTH_SHORT;
import static android.widget.Toast.makeText;


public class GameActivity extends ActionBarActivity {

    private ImageView rock;
    private ImageView paper;
    private ImageView axe;
    private TextView playAgain;
    private Button accept;
    private Button decline;
    private Context context;
    private int move;
    private int result;
    private int otherMove; //this will be the response from the other user

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        context = getApplicationContext();

        // set view variables
        rock = (ImageView) findViewById(R.id.rock);
        paper = (ImageView) findViewById(R.id.paper);
        axe = (ImageView) findViewById(R.id.Axe);
        playAgain = (TextView) findViewById(R.id.play_again);
        accept = (Button) findViewById(R.id.accept);
        decline = (Button) findViewById(R.id.decline);
        move = 0;

        rock.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                move = 1;
                result = rockPaperAxe(move, otherMove);
            }
        });
        paper.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                move = 2;
                result = rockPaperAxe(move, otherMove);
            }
        });
        axe.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                move = 3;
                result = rockPaperAxe(move, otherMove);
            }
        });
    }


    public int rockPaperAxe(int move, int otherMove) {
        if (move == otherMove) { return 0;}
        switch (move) {
            case 1:
                return (otherMove == 3 ? 1 : -1);
            case 2:
                return (otherMove == 1 ? 1 : -1);
            case 3:
                return (otherMove == 2 ? 1 : -1);
        }

        //should never get here
        return 0;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
