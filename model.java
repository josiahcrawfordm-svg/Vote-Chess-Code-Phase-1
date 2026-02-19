package model;
import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    public String username, team, title;
    public int bullet, blitz, rapid, daily, tokens;
    public boolean hasVoted = false, left=false;

    public Player(String username, String team, int bullet, int blitz, int rapid, int daily, String title) {
        this.username = username;
        this.team = team;
        this.bullet = bullet; this.blitz = blitz; this.rapid = rapid; this.daily = daily;
        this.title = title;
        this.tokens = calculateTokens();
    }

    private int calculateTokens() {
        if(title != null && !title.isEmpty()) return 12;
        int highest = Math.max(Math.max(bullet, blitz), Math.max(rapid, daily));
        if(highest>=2500) return 10;
        if(highest>=2300) return 9;
        if(highest>=2100) return 8;
        if(highest>=1900) return 7;
        if(highest>=1700) return 6;
        if(highest>=1500) return 5;
        if(highest>=1200) return 4;
        if(highest>=800) return 3;
        return 2;
    }
}
