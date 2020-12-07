package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {

    ArrayList<Matcher> list;

    public QueryBuilder() {
        list = new ArrayList<>();
        list.add(new All());
    }

    public Matcher build() {
        
        Matcher[] arr = list.toArray(new Matcher[list.size()]);
        list = new ArrayList<>();
        return new And(arr);
    }

    public QueryBuilder playsIn(String team) {
        list.add(new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int value, String category) {
        list.add(new HasAtLeast(value, category));
        return this;
    }

    public QueryBuilder hasFewerThan(int value, String category) {
        list.add(new HasFewerThan(value, category));
        return this;
    }

    public QueryBuilder oneOf(Matcher ...match) {
        list.add(new Or(match));

        return this;

    }

}
