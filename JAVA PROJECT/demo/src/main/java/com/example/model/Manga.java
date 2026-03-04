//Classe Manga
package com.example.model;

//Atributos: título, volume, resenha, pontos
public class Manga {
    private int id;
    private String title;
    private int volume;
    private String review;
    private int points;

//Construtor
    public Manga(int id, String title, int volume, String review, int points) {
        this.id = id;
        this.title = title;
        this.volume = volume;
        this.review = review;
        this.points = points;
    }

//Construtor vazio
    public Manga() {
    }



    public String LerManga(){
        return "Lendo o manga " + title;
    }

    public int getId(){ return id; }
    public void setId(int id) { this.id = id; }
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    } 
    
    public void setReview(String review) {
        this.review = review;
    }
    public String getReview(){
        return review;
    }

    public void setPoints(int points){
        this.points = points;
    }
    public int getPoints(){
        return points;
    }

    @Override
    public String toString() {
        return "Manga{" +
                "title='" + title + '\'' +
                ", volume=" + volume +
                ", review='" + review + '\'' +
                ", points=" + points +
                '}';
    }

}