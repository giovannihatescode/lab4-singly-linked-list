import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Playlist playlist = new Playlist();
        boolean running = true;

        while (running) {
            System.out.println("\n--- Playlist Manager ---");
            System.out.println("1. Add a song");
            System.out.println("2. Display playlist");
            System.out.println("3. Play next song");
            System.out.println("4. Remove a song");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Enter song title: ");
                    String title = input.nextLine();

                    System.out.print("Enter artist: ");
                    String artist = input.nextLine();

                    playlist.addSong(new Song(title, artist));
                    break;

                case "2":
                    playlist.displayPlaylist();
                    break;

                case "3":
                    playlist.playNext();
                    break;

                case "4":
                    System.out.print("Enter the title to remove: ");
                    String removeTitle = input.nextLine();

                    playlist.removeSong(removeTitle);
                    break;

                case "5":
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Please choose 1 through 5.");
            }
        }

        input.close();
    }
}