/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bmicalculatorfrancais;

/**
 *
 * @author sa
 */
public class BmiFrancais {
    
    private String name;
    private int age;
    private double weight;
    private double height;
    double Kilograms_Per_Pound = 0.45359237;
    double Meters_Per_inch = 0.0254;
    
    public BmiFrancais(String name, int age, double weight, double height){
        this.name= name;
        this.age= age;
        this.weight = weight;
        this.height= height;
    }
   // public Bmi(String name, double weight, double height){
       // this(name,20,weight,height);
    //}
    public double getBmi(){
        double bmi = weight / (height * height);
        return Math.round(bmi*100)/100;
    }
    public String getStatus(){
        double bmi = getBmi();
        if(bmi < 18.5){
            return " a une insuffisance ponderale(maigreur)";
            
        }else if(bmi < 25){
            return " a une Corpulance Normale";
            
        }else if (bmi < 30){
            return " est en Surpoids";
            
        }else
            return " est Obese";
        
    }
    public String getName(){
        return name;
    }
    public int getAge(){
        return age;
    }
    public double getHeight(){
        return height;
    }
    public double getWeight(){
        return weight;
    }
}
