package pe.edu.i202223858.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202223858.domain.Continent;
import pe.edu.i202223858.domain.Country;

public class JPAPersist {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Registrar los países
        try {
            em.getTransaction().begin();

            // Define países
            Country genji = new Country(
                    "ZA", "Genji", Continent.Asia, "Hanaoka", 890000.0, 2024, 8900000,
                    84.0, 14000.0, 80000.0, "Genji Local", "Republic", "Jiovanna Duran", 1, "SP1");

            Country mono = new Country(
                    "ZB", "Mono", Continent.Antarctica, "Numbani", 550000.0, 2024, 4500000,
                    89.0, 11000.0, 11200.0, "Mono Local", "Republic", "Pablito Ramirez", 2, "BI2");

            Country zarya = new Country(
                    "ZC", "Zarya", Continent.Asia, "Nacional", 790000.0, 2024, 6500000,
                    81.0, 12900.0, 12200.0, "Zarya Local", "Republic", "Daniela Santiago", 3, "CT3");



            // Persiste países
            em.persist(genji);
            em.persist(mono);
            em.persist(zarya);

            em.getTransaction().commit();

            System.out.println("Países persistidos con éxito.");

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }

}
