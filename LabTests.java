public class LabTests {
    private final String name;
    private final int cost;
    private final String defination;

    public LabTests(String name, int cost,String defination) {
        this.name = name;
        this.cost = cost;
        this.defination = defination;
    }
    public int Result(){
        if(Math.random()<0.6){
            return 1;
        }else{
            return 0;
        }
    }
    public String toString(){
        return "Name- " + this.name + "\nCost- " + this.cost + "\nPurpose- " + this.defination;
    }
}
