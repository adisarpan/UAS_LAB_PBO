/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cashier;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author VIVOBOOK
 */
public class Cashier {

    
   private final Scanner scanner;
    private final Product[] products;
    private final ShoppingCart shoppingCart;

    public Cashier() {
        scanner = new Scanner(System.in);
        products = new Product[]{
                new Product("Buku", 3000),
                new Product("Pulpen", 2000),
                new Product("Pensil", 1500),
                new Product("Penghapus", 1000),
                new Product("Aqua gelas", 500),
        };
        shoppingCart = new ShoppingCart();
    }

    public void run() {
        // Mulai
        System.out.println("Selamat datang di Ilkom mart");

        double total = 0;
        boolean doneShopping = false;
        while (!doneShopping) {
            // Untuk menampilkan daftar produk
            for (int i = 0; i < products.length; i++) {
                System.out.println((i + 1) + ". " + products[i]);
            }

            // Untuk menambahkan produk ke keranjang
            System.out.print("Masukkan Kode Produk: ");
            int productCode = scanner.nextInt();

            // Jika produk valid, tambahkan produk ke keranjang
            if (productCode > 0 && productCode <= products.length) {
                shoppingCart.addItem(products[productCode - 1]);
            } else {
                // Jika produk tidak valid
                System.out.println("Kode produk tidak valid.");
            }

            // Pertanyaan untuk pelanggan
            System.out.print("Apakah kamu ingin belanja lagi ? (Y/N): ");
            String input = scanner.next();

            // Hitung total belanjaan pelanggan
            if (input.equalsIgnoreCase("Y")) {
                total = shoppingCart.calculateTotal();
            } else if (input.equalsIgnoreCase("N")) {
                doneShopping = true;
            }
        }

        // Tampilkan total harga
        System.out.println("Total Belanja: Rp" + total);

        // Ucapan Terimakasih kepada pelanggan
        System.out.println("Terimakasih telah berbelanja di Ilkom mart!!");
    }

    public static void main(String[] args) {
        // Buat kasir baru dan jalankan
        Cashier cashier = new Cashier();
        cashier.run();
    }
}

class Product {

    private String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - Rp" + price;
    }
}

class ShoppingCart {

    private Product[] products;
    private double total;

    public ShoppingCart() {
        products = new Product[0];
        total = 0;
    }

    public void addItem(Product product) {
        products = Arrays.copyOf(products, products.length + 1);
        products[products.length - 1] = product;
        total += product.price;
    }

    public double calculateTotal() {
        return total;
    }
}

    

