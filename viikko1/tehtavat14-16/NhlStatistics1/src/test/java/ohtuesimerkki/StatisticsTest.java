package ohtuesimerkki;

import static org.junit.Assert.*;


import org.junit.Before;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;

public class StatisticsTest {
 
    Reader readerStub = new Reader() {
 
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();
 
            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));
 
            return players;
        }
    };
 
    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void getSpecificPlayer(){
        assertEquals("Gretzky", stats.search("Gretzky").getName());
        assertNull(stats.search("null"));
    }
    @Test
    public void playerAmountInTeam(){
        assertEquals(1, stats.team("PIT").size());
    }
    @Test
    public void topScorePlayer(){
       assertTrue(stats.topScorers(1).get(0).getName().equals("Gretzky"));
    }
    
  
}
