package GameObjects;

import MenuComponents.GameUpgradesPanel;

public class Stats {
    public    int Score;
    public    int Money;
    public    int Time;

    public Stats(){
        Score = 0;
        Money = 50;
        Time = 0;
    }

    public void UpdateStat(int addScore, int addMoney, int addTime){
        Score += addScore;
        Money += addMoney;
        Time += addTime;
    }
}
