package repo;

import entity.AlbumsEntity;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AlbumRepository {
    public void create(String name, int artistId, int releaseYear){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();

        AlbumsEntity album =
                (AlbumsEntity) em.createNamedQuery("Album.maxim")
                        .getSingleResult();

        AlbumsEntity newAlbum = new AlbumsEntity();

        newAlbum.setId(album.getId());
        newAlbum.setArtistId(artistId);
        newAlbum.setName(name);
        newAlbum.setReleaseYear((long) releaseYear);

        em.persist(newAlbum);
        em.getTransaction().commit();

        em.close();
    }
    public List<AlbumsEntity> findByArtist(int artistId){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        Query query =
                em.createNamedQuery("Album.findByArtist")
                        .setParameter("artistId", artistId);

        List<AlbumsEntity> albums = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return albums;
    }

    public List<AlbumsEntity> findByName(String name){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();
        Query query =
                em.createNamedQuery("Album.findByName")
                        .setParameter("name", name);

        List<AlbumsEntity> albums = query.getResultList();
        em.getTransaction().commit();
        em.close();
        return albums;
    }

    public AlbumsEntity findById(int id){
        EntityManager em = util.PersistenceUtil.getEmf().createEntityManager();
        em.getTransaction().begin();

        AlbumsEntity albums = em.find(AlbumsEntity.class, id);

        em.getTransaction().commit();
        em.close();
        return albums;
    }
}
