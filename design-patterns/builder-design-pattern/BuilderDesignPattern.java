class Car{
    private String name;
    private int milaege;
    private String fuelCategory;
    private String category;
    private int onRoadPrice;

    public void setName(String name) {
        this.name = name;
    }
    public void setMilaege(int milaege) {
        this.milaege = milaege;
    }
    public void setFuelCategory(String fuelCategory) {
        this.fuelCategory = fuelCategory;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setOnRoadPrice(int onRoadPrice) {
        this.onRoadPrice = onRoadPrice;
    }
    @Override
    public String toString() {
        return "Car [category=" + category + ", fuelCategory=" + fuelCategory + ", milaege=" + milaege + ", name="
                + name + ", onRoadPrice=" + onRoadPrice + "]";
    }
    
    
}

abstract class CarBuilder{
    protected Car car;
    abstract public CarBuilder setName(String name);
    abstract public CarBuilder setMilaege(int milaege);
    abstract public CarBuilder setFuelCategory(String category);
    abstract public CarBuilder setCategory(String category);
    abstract public CarBuilder setOnRoadPrice(int onRoadPrice);

    public Car build(){
        return car;
    }
}

class TeslaCarBuilder extends CarBuilder{

    public TeslaCarBuilder() {
        car = new Car();
    }

    @Override
    public CarBuilder setCategory(String category) {
        car.setCategory(category);
        return this; 
    }

    @Override
    public CarBuilder setFuelCategory(String category) {
        if(category==null){
            car.setFuelCategory("EV");
        }else{
            car.setFuelCategory(category); 
        }  
        return this;      
    }

    @Override
    public CarBuilder setMilaege(int milaege) {
        car.setMilaege(milaege); 
        return this;       
    }

    @Override
    public CarBuilder setName(String name) {
        car.setName(name);  
        return this;      
    }

    @Override
    public CarBuilder setOnRoadPrice(int onRoadPrice) {
        car.setOnRoadPrice(onRoadPrice); 
        return this;       
    }    
}

class TataCarBuilder extends CarBuilder{

    public TataCarBuilder() {
        car = new Car();
    }

    @Override
    public CarBuilder setCategory(String category) {
        car.setCategory(category);
        return this; 
    }

    @Override
    public CarBuilder setFuelCategory(String category) {
        if(category==null){
            car.setFuelCategory("Petrol");
        }else{
            car.setFuelCategory(category); 
        } 
        return this;       
    }

    @Override
    public CarBuilder setMilaege(int milaege) {
        car.setMilaege(milaege);
        return this;        
    }

    @Override
    public CarBuilder setName(String name) {
        car.setName(name);
        return this;        
    }

    @Override
    public CarBuilder setOnRoadPrice(int onRoadPrice) {
        car.setOnRoadPrice(onRoadPrice); 
        return this;       
    }    
}


public class BuilderDesignPattern {
    // This class will be working as a director
    public static void main(String[] args) {
        Car car = new TeslaCarBuilder()
        .setName("S1")
        .setCategory("SEDAN")
        .setMilaege(27)
        .setFuelCategory("Full Electric")
        .setOnRoadPrice(30000)
        .build();

        System.out.println(car);

        car = new TeslaCarBuilder()
        .setName("Nexon")
        .setCategory("HatchBack")
        .setMilaege(27)
        .setFuelCategory(null)
        .setOnRoadPrice(1300000)
        .build();

        System.out.println(car);
    }
}
