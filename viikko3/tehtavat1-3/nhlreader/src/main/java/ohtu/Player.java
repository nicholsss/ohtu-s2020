package ohtu;

public class Player implements Comparable<Player> {
    
    private int goals;
    private int assists;
    private String name;
    private int penalties;
    private String team;
    private String nationality;
    private String birthdate;
    
    public int getGoals() {
        return goals;
    }
    
    public void setGoals(int goals) {
        this.goals = goals;
    }
    
    public int getAssists() {
        return assists;
    }
    
    public void setAssists(int assists) {
        this.assists = assists;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public int getPenalties() {
        return penalties;
    }
    
    public void setPenalties(int penalties) {
        this.penalties = penalties;
    }
    
    public String getTeam() {
        return team;
    }
    
    public void setTeam(String team) {
        this.team = team;
    }
    
    public String getNationality() {
        return nationality;
    }
    
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    
    public String getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }
    
    public int getPoints() {
        int points = this.goals + this.assists;
        return points;
    }

    @Override
    public int compareTo(Player player) {
        if (this.goals + this.assists == player.getGoals() + player.getAssists()) {
            return 0;
        } else if (this.goals + this.assists < player.getGoals() + player.getAssists()) {
            return 1;
            
        } else {
            return -1;
        }
        
    }
    
    @Override
    public String toString() {
        int points = this.goals + this.assists;
        return name + "\t" + team + " " + goals + " + " + assists + " = " + points;
    }
    
}
