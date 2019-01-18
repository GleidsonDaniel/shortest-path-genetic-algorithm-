package Domain;

public class DNA {

    private int lifeSpan;
    private Vector2[] genes;

    public DNA(int lifeSpan){
        this.lifeSpan = lifeSpan;
        init();
    }

    public DNA(int lifeSpan, Vector2[] genes){
        this.lifeSpan = lifeSpan;
        this.genes = genes;
    }

    private void init(){
        genes = new Vector2[lifeSpan];
        for(int i = 0; i < genes.length; i++){
            genes[i] = new Vector2();
            genes[i].random(1);
        }
    }

    public Vector2[] getGenes() {
        return genes;
    }

    public DNA crossOver(DNA parentB) {

        Vector2[] newGenes = new Vector2[lifeSpan];
        double mid = Math.random()*genes.length;
        for(int i = 0; i<genes.length;i++){
            if(i > mid){
                newGenes[i] = genes[i];
            }else {
                newGenes[i] = parentB.getGenes()[i];
            }
        }
        return new DNA(lifeSpan,newGenes);
    }
}
