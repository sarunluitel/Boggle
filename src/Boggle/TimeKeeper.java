package Boggle;

import java.util.Timer;
import java.util.TimerTask;

class TimeKeeper
{

  private static int seconds=180;//3 minutes
  static int minutes=0;
  static int remSec =0;


  static void startTime()
  {
    Timer timer= new Timer();
    timer.scheduleAtFixedRate(new TimerTask()
    {

      public void run() {
        seconds--;
        minutes=seconds/60;
        remSec = seconds-minutes*60;
        System.out.println(remSec);
        //  lblTimer.setText("Time remain: "+remSec);
      }
    }, 1000, 1000);

  }

}
