package repo;

import entity.ArtistsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ArtistRepository {
    public void create(String name, String country){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();

        ArtistsEntity artist =
                (ArtistsEntity) em.createNamedQuery("Artist.maxim")
                        .getSingleResult();

        ArtistsEntity newArtist = new ArtistsEntity();

        newArtist.setId(artist.getId());
        newArtist.setName(name);
        newArtist.setCountry(country);

        em.persist(newArtist);
        em.getTransaction().commit();

        em.close();
    }
    public List<ArtistsEntity> findByName(String name){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        Query query =
               em.createNamedQuery("Artist.findByName")
                        .setParameter("name", name);

        List<ArtistsEntity> artists = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return artists;
    }
    public ArtistsEntity findById(int id){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();

        ArtistsEntity artist = em.find(ArtistsEntity.class, id);

        em.getTransaction().commit();
        em.close();
        return artist;
    }
}
