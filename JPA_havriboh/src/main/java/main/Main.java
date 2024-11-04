package main;

import dao.DigitalDao;
import dao.OrderDao;
import dao.PhysicalDao;
import dao.ProductDao;
import entities.Order;
import entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Main {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApplicationPU");
    private static EntityManager em = emf.createEntityManager();

    public static void main(String[] args) {
        try {
            System.out.println("start");
            //createOrder();
            //updateOrder();
            //deleteOrder();
            //createDigital();
            //updateDigitalVersion();
            //deleteDigital();
            //createPhysical();
            //updatePhysicalColor();
            //updatePhysicalWeight();
            //deletePhysical();
            //createProduct();
            //updateProduct();
            //deleteProduct();
            // protectedTransaction(); ( TODO: for repeat work you have to change data )
            // printManyToMany();
            System.out.println("end");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            closeEntityManager(em, emf);
        }
    }


    public static void closeEntityManager(EntityManager em, EntityManagerFactory emf) {
        em.close();
        emf.close();
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ApplicationPU");
        return emf.createEntityManager();
    }

    public static void printManyToMany() {
        System.out.println("Printing Orders and their Products:");
        Query query = em.createQuery("SELECT o FROM Order o JOIN FETCH o.products");
        List<Order> orders = query.getResultList();
        for (Order order : orders) {
            System.out.println("Order Number: " + order.getNumber());
            System.out.println("Products:");
            for (Product product : order.getProducts()) {
                System.out.println("    Product Name: " + product.getProductName());
                System.out.println("    Product Number: " + product.getProductNumber());
            }
        }
    }


    private static void protectedTransaction() {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();

            // Adding a new manufacturer
            String manufacturerName = "Biba";
            Query addManufacturerQuery = em.createNativeQuery("INSERT INTO manufacturer (\"manufacturer name\") VALUES (?)");
            addManufacturerQuery.setParameter(1, manufacturerName);
            addManufacturerQuery.executeUpdate();

            Query getManufacturerIdQuery = em.createNativeQuery("SELECT \"manufacturer id\" FROM manufacturer WHERE \"manufacturer name\" = ? LIMIT 1");
            getManufacturerIdQuery.setParameter(1, manufacturerName);
            Integer manufacturerId = (Integer) getManufacturerIdQuery.getSingleResult();

            BigDecimal productPrice = BigDecimal.valueOf(159.99);
            String productNumber = "D-1254322890";
            String productName = "Super cool";
            String model = "Model 1";
            String size = "Small";
            Query addProductQuery = em.createNativeQuery("INSERT INTO product (\"product price\", \"product number\", \"product name\", \"manufacturer id\", model, size, \"shopping website id\") VALUES (?, ?, ?, ?, ?, ?, ?)");
            addProductQuery.setParameter(1, productPrice);
            addProductQuery.setParameter(2, productNumber);
            addProductQuery.setParameter(3, productName);
            addProductQuery.setParameter(4, manufacturerId);
            addProductQuery.setParameter(5, model);
            addProductQuery.setParameter(6, size);
            addProductQuery.setParameter(7, 1);
            addProductQuery.executeUpdate();
            System.out.println("Transaction from cp4 completed successfully");

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            closeEntityManager(em, emf);
        }
    }






    public static void createOrder() {
        em.getTransaction().begin();
        OrderDao orderDao = new OrderDao();
        orderDao.setEntityManager(em);
        orderDao.create("1234567890", LocalDate.now(), "10%", 1);
        em.getTransaction().commit();
    }

    public static void createDigital() {
        em.getTransaction().begin();
        DigitalDao digitalDao = new DigitalDao();
        digitalDao.setEntityManager(em);
        digitalDao.create("D-1234567890", "Photoshop", BigDecimal.valueOf(100.00), "Adobe", "Size 1", "1", "1", "1.0 GB", "File", "v1.0", "License 1");
        em.getTransaction().commit();
    }

    public static void updateDigitalVersion() {
        em.getTransaction().begin();
        DigitalDao digitalDao = new DigitalDao();
        digitalDao.setEntityManager(em);
        digitalDao.updateVersionByNumber("D-1234567890", "v2.0");
        em.getTransaction().commit();
    }

    public static void deleteDigital() {
        em.getTransaction().begin();
        DigitalDao digitalDao = new DigitalDao();
        digitalDao.setEntityManager(em);
        digitalDao.deleteByNumber("D-1234567890");
        em.getTransaction().commit();
    }

    public static void createPhysical() {
        em.getTransaction().begin();
        PhysicalDao physicalDao = new PhysicalDao();

        physicalDao.setEntityManager(em);
        physicalDao.create("P-0987654321", "Product 2", BigDecimal.valueOf(320.00), "Model 2", "Big", "1", "1", "Blue", "3.0 kg", "Material 1");

        em.getTransaction().commit();
    }


    public static void updatePhysicalColor() {
        em.getTransaction().begin();
        PhysicalDao physicalDao = new PhysicalDao();

        physicalDao.setEntityManager(em);
        physicalDao.updateColorByNumber("P-0987654321", "Black");

        em.getTransaction().commit();
    }

    public static void updatePhysicalWeight() {
        em.getTransaction().begin();
        PhysicalDao physicalDao = new PhysicalDao();

        physicalDao.setEntityManager(em);
        physicalDao.updateWeightByNumber("P-0987654321", "23.0 kg");

        em.getTransaction().commit();
    }

    public static void deletePhysical() {
        em.getTransaction().begin();
        PhysicalDao physicalDao = new PhysicalDao();

        physicalDao.setEntityManager(em);
        physicalDao.deleteByNumber("P-0987654321");

        em.getTransaction().commit();
    }



    public static void createProduct() {
        em.getTransaction().begin();
        ProductDao productDao = new ProductDao();

        productDao.setEntityManager(em);
        productDao.create("P-1234567890", "Product 1", BigDecimal.valueOf(100.00), "Model 1", "Size 1", "1", "1");

        em.getTransaction().commit();
    }

    public static void updateProduct() {
        em.getTransaction().begin();
        ProductDao productDao = new ProductDao();

        productDao.setEntityManager(em);
        productDao.updatePriceByNumber("P-1234567890", BigDecimal.valueOf(200.00));

        em.getTransaction().commit();
    }

    public static void deleteProduct() {
        em.getTransaction().begin();
        ProductDao productDao = new ProductDao();

        productDao.setEntityManager(em);
        productDao.deleteByNumber("P-1234567890");

        em.getTransaction().commit();
    }



}