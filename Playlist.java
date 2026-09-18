public class Playlist {
    private static class Node {
        Song song;
        Node next;

        Node(Song song) {
            this.song = song;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private Node currentNode;
    private int size;

    public Playlist() {
        head = null;
        tail = null;
        currentNode = null;
        size = 0;
    }

    public void addSong(Song song) {
        Node newNode = new Node(song);

        if (head == null) {
            head = newNode;
            tail = newNode;
            currentNode = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;
        System.out.println("Added: " + song);
    }

    public void removeSong(String title) {
        Node previous = null;
        Node node = head;

        while (node != null
                && !node.song.getTitle().equalsIgnoreCase(title)) {
            previous = node;
            node = node.next;
        }

        if (node == null) {
            System.out.println("Song not found.");
            return;
        }

        if (previous == null) {
            head = node.next;
        } else {
            previous.next = node.next;
        }

        if (node == tail) {
            tail = previous;
        }

        // If the next song to play is removed, skip it.
        if (currentNode == node) {
            if (node.next != null) {
                currentNode = node.next;
            } else {
                currentNode = head;
            }
        }

        size--;

        if (size == 0) {
            head = null;
            tail = null;
            currentNode = null;
        }

        System.out.println("Removed: " + node.song);
    }

    public void playNext() {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }

        if (currentNode == null) {
            currentNode = head;
        }

        System.out.println("Now playing: " + currentNode.song);

        currentNode = currentNode.next;

        if (currentNode == null) {
            currentNode = head;
        }
    }

    public void displayPlaylist() {
        if (head == null) {
            System.out.println("The playlist is empty.");
            return;
        }

        System.out.println("\nPlaylist (" + size + " songs):");

        Node node = head;
        int number = 1;

        while (node != null) {
            System.out.println(number + ". " + node.song);
            node = node.next;
            number++;
        }
    }
}