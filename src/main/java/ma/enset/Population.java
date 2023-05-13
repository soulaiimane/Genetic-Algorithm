package ma.enset;

import java.util.*;

public class Population  {
    List<Individual> individuals=new ArrayList<>();
    Individual firstFitness;
    Individual secondFitness;
    Random rmd =new Random();
    public void initialazePopulation() {
        for (int i = 0; i < 20; i++) {
            Individual individual = new Individual();
            individuals.add(individual);
        }
    }
    public void calculateIndividualsFitness() {
        for (int i = 0; i < 20; i++) {
            individuals.get(i).calculateFitness();
        }

    }
    public void selection( ) {

        firstFitness=individuals.get(0);
        secondFitness=individuals.get(1);

    }
    public void crossover(){
        int pontCroisement=rmd.nextInt(8);
        pontCroisement++;
        System.out.println("pontCroisement= "+pontCroisement);
        Individual individual1=new Individual();
        Individual individual2=new Individual();
        for (int j=0 ;j<individual1.getGenes().length;j++){
            individual1.getGenes()[j]=firstFitness.getGenes()[j];
            individual2.getGenes()[j]=secondFitness.getGenes()[j];
        }
        for (int i=0;i<pontCroisement;i++) {
            individual1.getGenes()[i]=secondFitness.getGenes()[i];
            individual2.getGenes()[i]=firstFitness.getGenes()[i];
            individual1.calculateFitness();
            individual2.calculateFitness();

        }
        individuals.set(individuals.size()-1,individual1);
        individuals.set(individuals.size()-2,individual2);

    }
    public void mutation (){
        int index=rmd.nextInt(10);
        if (individuals.get(individuals.size()-2).getGenes()[index]==1)
            individuals.get(individuals.size()-2).getGenes()[index]=0;
        else individuals.get(individuals.size()-2).getGenes()[index]=1;
        index=rmd.nextInt(10);
        if (individuals.get(individuals.size()-1).getGenes()[index]==1)
            individuals.get(individuals.size()-1).getGenes()[index]=0;
        else individuals.get(individuals.size()-1).getGenes()[index]=1;
    }

    public List<Individual> getIndividuals() {
        return individuals;
    }
    public  void sortPopulation(){
        Collections.sort(individuals,Collections.reverseOrder());
    }
    Individual getBestFitnessIndividual(){
        return individuals.get(0);
    }
}
