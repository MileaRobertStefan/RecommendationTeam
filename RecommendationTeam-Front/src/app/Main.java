package app;

import repo.AlbumRepository;
import repo.ArtistRepository;
import util.PersistenceUtil;

class Main{
    public static void main(String args[]){
      ArtistRepository artist = new ArtistRepository();
      AlbumRepository album = new AlbumRepository();

      artist.create("Terog","Mergi");
      album.create("Colaj2001",1,2000);

      System.out.println(artist.findById(1));
      System.out.println(artist.findByName("Terog"));
      System.out.println(album.findById(1));
      System.out.println(album.findByName("Colaj2001"));
      System.out.println(album.findByArtist(1));


      PersistenceUtil.emf.close();
    }
}