import java.util.*;

public class LibraryApp {
    static class Book {
        String id, title, author;
        boolean borrowed = false;
        Book(String id, String title, String author) {
            this.id = id; this.title = title; this.author = author;
        }
        public String toString() {
            return "["+id+"] "+title+" by "+author+(borrowed?" (Borrowed)":" (Available)");
        }
    }

    static class Member {
        String id, name;
        Member(String id, String name) { this.id=id; this.name=name; }
        public String toString() { return "["+id+"] "+name; }
    }

    static Map<String,Book> books = new LinkedHashMap<>();
    static Map<String,Member> members = new LinkedHashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Basic Library Management ===");
        while(true){
            System.out.println("\n1) Add Book  2) List Books  3) Borrow  4) Return  5) Add Member  6) List Members  0) Exit");
            String choice = sc.nextLine().trim();
            switch(choice){
                case "1": addBook(); break;
                case "2": listBooks(); break;
                case "3": borrowBook(); break;
                case "4": returnBook(); break;
                case "5": addMember(); break;
                case "6": listMembers(); break;
                case "0": System.out.println("Goodbye!"); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    static void addBook(){
        System.out.print("Title: "); String t=sc.nextLine();
        System.out.print("Author: "); String a=sc.nextLine();
        String id="BK-"+(books.size()+1);
        books.put(id,new Book(id,t,a));
        System.out.println("Added "+books.get(id));
    }
    static void listBooks(){ books.values().forEach(System.out::println); }
    static void borrowBook(){
        System.out.print("Book ID: "); String id=sc.nextLine();
        Book b=books.get(id);
        if(b!=null && !b.borrowed){ b.borrowed=true; System.out.println("Borrowed "+b); }
        else System.out.println("Not available.");
    }
    static void returnBook(){
        System.out.print("Book ID: "); String id=sc.nextLine();
        Book b=books.get(id);
        if(b!=null && b.borrowed){ b.borrowed=false; System.out.println("Returned "+b); }
        else System.out.println("Not borrowed.");
    }
    static void addMember(){
        System.out.print("Name: "); String n=sc.nextLine();
        String id="MB-"+(members.size()+1);
        members.put(id,new Member(id,n));
        System.out.println("Added "+members.get(id));
    }
    static void listMembers(){ members.values().forEach(System.out::println); }
}
