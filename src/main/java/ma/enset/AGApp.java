package ma.enset;

import java.util.Arrays;
import java.util.Random;

public class AGApp {
    static final int MaxIteration=10;
    private static final int Max_fitnes=10;
    public static void main(String[] args) {
        Population population=new Population();
        population.initialazePopulation();
        population.calculateIndividualsFitness();
        population.sortPopulation();
        int iteration=0;
        while (iteration<MaxIteration && population.getBestFitnessIndividual().getFitness() <Max_fitnes) {
            population.selection();
            population.crossover();
            Random random = new Random();
            if (random.nextInt(101) < 20)
                population.mutation();
            population.calculateIndividualsFitness();
            population.sortPopulation();
            System.out.println("Iteration Number "+iteration);
            System.out.println("chromosome= " + Arrays.toString(population.getBestFitnessIndividual().getGenes()) + "Fitness------->" + population.getBestFitnessIndividual().getFitness());
            iteration++;
        }

        }


    }




