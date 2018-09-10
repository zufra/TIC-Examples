package Entities;

import javax.persistence.*;
import java.util.List;

public class Main {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence.createEntityManagerFactory("RESOURCE_LOCAL");

    public static void main(String[] args) {

//        createClient(1,"Juan",23);
//        createClient(2,"Ignacio",22);
//        createClient(3,"Martin",20);
//        createClient(4,"Daniel",15);
//        createClient(5,"Pablo",5);
//
//
//        createRestaurant(1, "McDonalds");
//        createRestaurant(2, "La Perdiz");
//        createRestaurant(3, "Juan Eriza Pabla");
//        createRestaurant(4, "Umami Sushi");
        updateClient(2, "Jose", 30);


        List restaurantList = readAllRestaurants();
        if (restaurantList != null) {
            for (int i = 0; i < restaurantList.size(); i++) {
                Restaurant oRestaurant = (Restaurant) restaurantList.get(i);
                System.out.println(oRestaurant.getName());
            }
        }

        List clientList = readAllClients();
        if (clientList != null) {
            for (int i = 0; i < clientList.size(); i++) {
                Client oClient = (Client) clientList.get(i);
                System.out.print(oClient.getName());
                System.out.print(" ");
                System.out.println(oClient.getAge());
            }
        }

        ENTITY_MANAGER_FACTORY.close();
    }

    public static void createRestaurant(int id, String name) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Restaurant oRestaurant = new Restaurant();
            oRestaurant.setId(id);
            oRestaurant.setName(name);

            manager.persist(oRestaurant);
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public static void createClient(int id, String name, int age) {
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Client oClient = new Client();
            oClient.setId(id);
            oClient.setAge(age);
            oClient.setName(name);

            manager.persist(oClient);
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

    public static List<Client> readAllClients() {
        List<Client> clients = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            clients = manager.createQuery("SELECT s FROM Client s", Client.class).getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return clients;
    }

    public static List<Restaurant> readAllRestaurants() {
        List<Restaurant> restaurants = null;
        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            restaurants = manager.createQuery("SELECT r FROM Restaurant r", Restaurant.class).getResultList();
            transaction.commit();

        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }

        return restaurants;
    }

    public static void updateClient(int id, String name, int age) {

        EntityManager manager = ENTITY_MANAGER_FACTORY.createEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = manager.getTransaction();
            transaction.begin();

            Client oClientTemp = manager.find(Client.class, id);

            oClientTemp.setName(name);
            oClientTemp.setAge(age);

            manager.persist(oClientTemp);

            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            manager.close();
        }
    }

}
