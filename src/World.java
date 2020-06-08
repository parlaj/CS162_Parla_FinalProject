import processing.core.PApplet;
import java.util.ArrayList;
/**
 * Sketches a zombie vs human simulator using the PApplet class.
 * @author Jacob Parla
 * @version 1.0
 * @since 06/07/2020
 */
public class World extends PApplet {
    ArrayList<Person> population;
    ArrayList<Person> humanPopulation;
    ArrayList<Person> zombiePopulation;
    ArrayList<Person> humanPopulation2;
    ArrayList<Person> zombiePopulation2;
    int zombiePop;
    int humanPop;
    PApplet p;

    public void settings() {size(500,500);}

    public void setup() {
        p = new PApplet();
        zombiePop = 0;
        humanPop = 0;
        humanPopulation = new ArrayList<>();
        zombiePopulation = new ArrayList<>();
        humanPopulation2 = new ArrayList<>();
        zombiePopulation2 = new ArrayList<>();
        population = new ArrayList<>();

        for ( int i = 0; i <= p.random(10,50); i++) {
            population.add(new Human(this, p.random(20,480), 480, p.random(5, 35)));
            population.add(new Zombie(this, p.random(20,480), 20, p.random(5, 35)));
        }


        for (Person person: population) {
            if(person instanceof Zombie){
                zombiePopulation.add(person);
                zombiePopulation2.add(person);
                zombiePop++;
            }
            else if(person instanceof Human){
                humanPopulation.add(person);
                humanPopulation2.add(person);
                humanPop++;
            }
        }


    }
    public void draw() {
        background(0);
        for (Person person: zombiePopulation) {
            person.display();
            person.move();

        }
        for (Person person: humanPopulation) {
            person.display();
            person.move();

        }


        for (Person human: humanPopulation2){
            for (Person zomb: zombiePopulation2){

                if (human.contact(zomb) && human.getSize() <= zomb.getSize() && humanPop > 0) {
                    if (p.random(0,1000) < 350) {
                        humanPopulation.remove(human);
                        humanPop--;

                    }
                    else if (p.random(0,1000) < 200){
                        humanPopulation.remove(human);
                        humanPop--;
                        zombiePopulation.add(new Zombie(this, human.getxPos(), human.getyPos(), human.getSize()));
                        zombiePop++;
                    }
                }

                else if (human.contact(zomb) && zombiePop > 0) {
                    if (human.getSize() > zomb.getSize())  {
                        if (p.random(0,1000) > 250) {
                            zombiePopulation.remove(zomb);
                            zombiePop--;
                            ParticleSystem pS = new ParticleSystem((int) zomb.getxPos(), (int) zomb.getyPos(), this);
                            pS.draw();
                        }
                    }

                }
                else if (zomb.contact(human) && p.random(1000) >= 1 && zombiePop > 0) {
                    zombiePopulation.remove(zomb);
                    zombiePop--;
                    ParticleSystem pS = new ParticleSystem((int)zomb.getxPos(), (int)zomb.getyPos(), this);
                    pS.draw();
                }
            }

        }

        fill(20, 41, 228);
        text("Human Population: " + humanPopulation.size(), 180,20);
        fill(69, 228, 52);
        text("Zombie Population: " + zombiePopulation.size(), 180,480);
    }
}
