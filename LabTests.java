public class LabTests {
    private final String name;
    private final int cost;
    private final String defination;

    public LabTests(String name, int cost,String defination) {
        this.name = name;
        this.cost = cost;
        this.defination = defination;
    }
    public String Result(){
        if(Math.random()<0.6){
            return "Fine";
        }else{
            return "Need Attention";
        }
    }
    public String toString(){
        return "Name- " + this.name + "\nCost- " + this.cost + "\nPurpose- " + this.defination;
    }
}
