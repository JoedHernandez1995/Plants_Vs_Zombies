package astro; 

/* Esta es nuestra clase jugador, que el atributo nombre es pedido al momento que un usuario
 * finaliza el juego totalmente sin perder, los demas atributos son calculados mientras el usuario
 * esta en juego.
 */
public class Jugador {
    
    private String nombre; //Nombre del jugador
    private int Score; //Puntaje Total que saco
    private int shooterCounter; //Total plantas Disparadoras Puestas
    private int bombCounter; //Total Bombas puestas
    private int sunFlowerCounter; //Total Girasoles puestos
    private int potatoCounter; //Total papas puestas
    private int totalPlants; //Total Plantas puestas

    public Jugador(String nombre, int Score, int shooterCounter, int bombCounter, int sunFlowerCounter, int potatoCounter, int totalPlants) {
        this.nombre = nombre;
        this.Score = Score;
        this.shooterCounter = shooterCounter;
        this.bombCounter = bombCounter;
        this.sunFlowerCounter = sunFlowerCounter;
        this.potatoCounter = potatoCounter;
        this.totalPlants = totalPlants;
    }

    public Jugador() {
    }

    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    public int getShooterCounter() {
        return shooterCounter;
    }

    public void setShooterCounter(int shooterCounter) {
        this.shooterCounter = shooterCounter;
    }

    public int getBombCounter() {
        return bombCounter;
    }

    public void setBombCounter(int bombCounter) {
        this.bombCounter = bombCounter;
    }

    public int getSunFlowerCounter() {
        return sunFlowerCounter;
    }

    public void setSunFlowerCounter(int sunFlowerCounter) {
        this.sunFlowerCounter = sunFlowerCounter;
    }

    public int getPotatoCounter() {
        return potatoCounter;
    }

    public void setPotatoCounter(int potatoCounter) {
        this.potatoCounter = potatoCounter;
    }

    public int getTotalPlants() {
        return totalPlants;
    }

    public void setTotalPlants(int totalPlants) {
        this.totalPlants = totalPlants;
    }

    @Override
    public String toString() {
        return nombre + "," + Score + "," + shooterCounter + "," + bombCounter + "," + sunFlowerCounter + "," + potatoCounter + "," + totalPlants;
    }
    
    
    
}
