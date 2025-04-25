public class Main {
    public static void main(String[] args) {
        Season s1 = new Season();
        s1.addEpisode(new Episode("S1E1", 1200));
        s1.addEpisode(new Episode("S1E2", 1100));

        Season s2 = new Season();
        s2.addEpisode(new Episode("S2E1", 1300));
        s2.addEpisode(new Episode("S2E2", 1250));

        Series series = new Series();
        series.addSeason(s1);
        series.addSeason(s2);

        System.out.println("== Normal Order ==");
        EpisodeIterator normal = s1.createIterator();
        while (normal.hasNext()) {
            System.out.println(normal.next());
        }

        System.out.println("\n== Reverse Order ==");
        EpisodeIterator reverse = s1.createReverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }

        System.out.println("\n== Shuffle Order ==");
        EpisodeIterator shuffle = s1.createShuffleIterator(42);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\n== Binge All Episodes ==");
        EpisodeIterator binge = series.createBingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}
