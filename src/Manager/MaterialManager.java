package Manager;

import Model.Material;

import java.util.ArrayList;
import java.util.Scanner;

public class MaterialManager {
    public ArrayList<Material> materials = new ArrayList<>() ;
    public void addMaterial(Material material){
        materials.add(material);
    }
    public void removeMaterial(String id){
        for (Material material1:
             materials) {
                if (material1.getId() == id){
                    materials.remove(material1);
                }
        }
    }
    public void editMaterial(String id , Material newMaterial){
        for (Material material1:
             materials) {
                if (material1.getId()== id){
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter new ID: ");
                    String idNew = sc.nextLine();
                    id = idNew;
                    material1 = newMaterial;
                }

        }
    }

}
