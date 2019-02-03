import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JLabel;

public class Clock {
	JLabel timelabel;
	JLabel scorelabel;
	JLabel collisionlabel;
	TimerTask timertask;
	int seconds;
	int minutes;
	int timeInMilliSecs;
	Timer timer;
	Score score;

	boolean collisionDetected;

	public Clock() {

		seconds = 0;
		minutes = 0;
		timeInMilliSecs = 0;
		collisionDetected = false;
		timer = new Timer();
		score = new Score();

		scorelabel = new JLabel("Score is " + score.score);
		timelabel = new JLabel(minutes + ":" + seconds);
		collisionlabel = new JLabel("Collision count: " + score.collisionCount);
		// The timer task is a task that is meant to be run every 100
		// miliseconds
		timertask = new TimerTask() {

			@Override
			public void run() {
				timeInMilliSecs++;
				timelabel.repaint();
				collisionlabel.repaint();
				minutes = timeInMilliSecs / 60;
				seconds = (int) timeInMilliSecs % 60;

				// If collision count is greater than 2, reset timer
				// Score stays the same
				if (score.getColCount() >= 2) {
					resetTimer();
					score.resetColCount();
					timelabel.repaint();
				}
				// If the user reaches 90 seconds, reset all counts except for score
				// Score is increased
				if (timeInMilliSecs == 90) {
					resetTimer();
					score.incScore();
					score.resetColCount();
					scorelabel.repaint();
					System.out.print("try");
				}
				// Resets the text labels
				timelabel.setText(minutes + ":" + seconds);
				scorelabel.setText("Score is: " + score.score);
				collisionlabel.setText("Collision count: " + score.collisionCount);
			}
		};

	}

	public void runclock() {
		timer.scheduleAtFixedRate(timertask, 1000, 1000);
	}

	public void resetTimer() {
		seconds = 0;
		minutes = 0;
		timeInMilliSecs = 0;
	}

}