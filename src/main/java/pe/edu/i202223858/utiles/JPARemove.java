package pe.edu.i202223858.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202223858.domain.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();


        try {
            em.getTransaction().begin();

            Country country = em.find(Country.class, "ZA" +
                    "");

            if (country != null) {
                em.remove(country);
                System.out.println("País " + country.getName() + " eliminado .");
            } else {
                System.out.println("País no encontrado.");
            }

            em.getTransaction().commit();

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
