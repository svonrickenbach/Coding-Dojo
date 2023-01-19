public class TestHashmatique {
    
	public static void main(String[] args) {
		Hashmatique hash = new Hashmatique();

        System.out.println("\n---All Title Keys and Lyrics Print---\n");
        String songTitle = hash.hashMappin();

        System.out.println("\n---Single Song Title Print---\n");
        System.out.println(songTitle);
	}
}
