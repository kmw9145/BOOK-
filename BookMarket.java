package bookmarket;

import java.util.ArrayList;
import java.util.Scanner;

class Book {
    String id;
    String title;
    String author;
    String publisher;
    int price;

    public Book(String id, String title, String author, String publisher, int price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
    }
    public String toString() {
        return id + ", " + title + ", " + author + ", " + publisher + ", " + price + "원";
    }
}

public class BookMarket {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static ArrayList<Book> cart = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBookList();

        int choice;
        System.out.println("*****************************************");
        System.out.println("*     Welcome to MinWoo Book Market     *");
        System.out.println("*****************************************");

        do {
            System.out.println("\n=========================================");
            System.out.println("1. 도서 목록 보기");
            System.out.println("2. 장바구니 보기");
            System.out.println("3. 장바구니에 도서 추가");
            System.out.println("4. 장바구니 비우기");
            System.out.println("0. 종료");
            System.out.println("=========================================");
            System.out.print(">> 메뉴 선택 : ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBookList();
                    break;
                case 2:
                    displayCart();
                    break;
                case 3:
                    addToCart();
                    break;
                case 4:
                    clearCart();
                    break;
                case 0:
                    System.out.println(">> MinWoo Book Market을 종료합니다.");
                    break;
                default:
                    System.out.println("없는 메뉴입니다. 0번부터 4번까지의 메뉴 중에서 선택하세요.");
                    break;
            }
        } while (choice != 0);

        scanner.close();
    }

    public static void initializeBookList() {
        bookList.add(new Book("ID2401", "쉽게 배우는 자바 프로그래밍 2판", "우종정", "한빛아카데미", 20000));
        bookList.add(new Book("ID2402", "코딩 자율학습 HTML+CSS+자바스크립트", "김기수", "길벗", 30000));
        bookList.add(new Book("ID2403", "Do It! 자료구조와 함께 배우는 알고리즘 입문 - 자바편", "보요시바타", "이지스퍼블리싱", 25000));
    }

    public static void displayBookList() {
        System.out.println(">> 도서 목록");
        System.out.println("------------------------------------------------------------------------");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public static void displayCart() {
        if (cart.isEmpty()) {
            System.out.println(">> 장바구니가 비어 있습니다.");
        } else {
            System.out.println(">> 장바구니");
            System.out.println("------------------------------------------------------------------------");
            for (Book book : cart) {
                System.out.println(book);
            }
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public static void addToCart() {
        displayBookList();
        System.out.print(">> 추가할 도서의 ID를 입력하세요: ");
        String bookId = scanner.next();

        boolean found = false;
        for (Book book : bookList) {
            if (book.id.equals(bookId)) {
                cart.add(book);
                found = true;
                System.out.println(">> 장바구니에 \"" + book.title + "\"이(가) 추가되었습니다.");
                break;
            }
        }
        if (!found) {
            System.out.println("해당 ID의 도서를 찾을 수 없습니다.");
        }
    }

    public static void clearCart() {
        if (cart.isEmpty()) {
            System.out.println(">> 장바구니가 이미 비어 있습니다.");
        } else {
            cart.clear();
            System.out.println(">> 장바구니에 있는 아이템을 모두 삭제하였습니다.");
        }
    }
}