package es.softwareprocess.fillercreep;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FillerCreepTextViewActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textinterface);
        
        
        
        Button button = (Button)findViewById(R.id.textdarkenergy);
        button.setOnClickListener(new OnClickListener() {			
        	@Override
        	public void onClick(View arg0) {
        		play(new DarkEnergy());
        	}
        });
        Button dmbutton = (Button)findViewById(R.id.textdarkmatter);
        dmbutton.setOnClickListener(new OnClickListener() {			
        	@Override
        	public void onClick(View arg0) {
        		play(new DarkMatter());
        	}
        });
        Button ebutton = (Button)findViewById(R.id.textenergy);
        ebutton.setOnClickListener(new OnClickListener() {			
        	@Override
        	public void onClick(View arg0) {
        		play(new Energy());
        	}
        });
        Button mbutton = (Button)findViewById(R.id.textmatter);
        mbutton.setOnClickListener(new OnClickListener() {			
        	@Override
        	public void onClick(View arg0) {
        		play(new Matter());
        	}
        });
        updateScores();
    }
    void play(FundamentalStuff choice) {
		FillerCreep fillerCreep = FillerCreepApplication.getFillerCreep();
		fillerCreep.playRoundWithAI(0, choice);
		updateScores();    	
    }
    void updateScores() {
    	TextView score1 = (TextView)findViewById(R.id.textyin);
    	TextView score2 = (TextView)findViewById(R.id.textyang);
    	TextView [] tscores = new TextView[]{ score1, score2 }; 
		FillerCreep fillerCreep = FillerCreepApplication.getFillerCreep();
		int winner = -1;
		if (fillerCreep.gameOver()) {
			winner = fillerCreep.whichPlayerNumberWins();
		}
		int[] scores = fillerCreep.getScores();
		Player[] players = fillerCreep.getPlayers();
		String wins = " wins and ";
		for (int i = 0; i < scores.length; i++) {
			tscores[i].setText(players[i].getName() +(winner==i?wins:"") + " has " + scores[i]);
		}			
    }
}