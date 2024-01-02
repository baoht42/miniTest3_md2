package Views;

import Manager.MaterialManager;
import Model.CrispyFlour;
import Model.Material;
import Model.Meat;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MaterialManage {
    public static void main(String[] args) {
        List<Material> materials = new ArrayList<>();
        Meat meat1 = new Meat("1", "Meat 1", LocalDate.of(2023, 12, 22), 110, 10);
        Meat meat2 = new Meat("2", "Meat 2", LocalDate.of(2023, 12, 20), 120, 10);
        Meat meat3 = new Meat("3", "Meat 3", LocalDate.of(2023, 12, 19), 130, 10);
        Meat meat4 = new Meat("4", "Meat 4", LocalDate.of(2023, 12, 24), 150, 10);
        Meat meat5 = new Meat("5", "Meat 5", LocalDate.of(2023, 12, 26), 160, 10);
        materials.add(meat1);
        materials.add(meat2);
        materials.add(meat3);
        materials.add(meat4);
        materials.add(meat5);
        CrispyFlour flour1 = new CrispyFlour("6", "Flour 1", LocalDate.of(2023, 12, 22), 12, 1);
        CrispyFlour flour2 = new CrispyFlour("7", "Flour 2", LocalDate.of(2023, 12, 23), 14, 1);
        CrispyFlour flour3 = new CrispyFlour("8", "Flour 3", LocalDate.of(2023, 12, 24), 16, 1);
        CrispyFlour flour4 = new CrispyFlour("9", "Flour 4", LocalDate.of(2023, 12, 26), 13, 1);
        CrispyFlour flour5 = new CrispyFlour("10", "Flour 5", LocalDate.of(2023, 12, 27), 11, 1);
        materials.add(flour1);
        materials.add(flour2);
        materials.add(flour3);
        materials.add(flour4);
        materials.add(flour5);

//        getSumPrice(materials);
//        getDifferncePrice(materials);

        Scanner sc = new Scanner(System.in);
        String choice;
        do {
            System.out.println("MENU---------- ");
            System.out.println("1. Sumary of Price ");
            System.out.println("2. Difference of SumPrice and DisCountPrice ");
            System.out.println("3. Add material ");
            System.out.println("4. Display material ");
            System.out.println("5. Edit material");
            System.out.println("6. Remove material ");
            System.out.println("7. Exit ");
            System.out.println("--Your choice: ");

            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    getSumPrice(materials);
                    break;
                case "2":
                    getDifferncePrice(materials);
                    break;
                case "3":
                    //Them vat lieu
                    System.out.println("1. Add Meat");
                    System.out.println("2. Add Flour");
                    String choiceAdd = sc.nextLine();
                    switch (choiceAdd) {
                        case "1":
                            try {
                                System.out.println("Nhập id sản phẩm Meat: ");
                                String id = sc.nextLine();
                                System.out.println("Nhập tên sản phẩm Meat: ");
                                String name = sc.nextLine();
                                System.out.println("Nhập ngày sản xuất Meat(yyyy-mm-dd): ");
                                String manufacturingDayString = sc.nextLine();
                                LocalDate manufacturingDate = LocalDate.parse(manufacturingDayString);


                                System.out.println("Nhập giá sản phẩm Meat: ");
                                int cost = sc.nextInt();
                                System.out.println("Nhập số kí Meat: ");
                                double weight = sc.nextDouble();
                                Meat m1 = new Meat(id, name, manufacturingDate, cost, weight);
                                materials.add(m1);
                            } catch (DateTimeException e) {
                                System.out.println("Định dạng ngày không hợp lệ. Hãy nhập lại!");
                                continue;

                            }
                            break;
                        case "2":
                            try {
                                System.out.println("Nhập id sản phẩm Flour: ");
                                String id = sc.nextLine();
                                System.out.println("Nhập tên sản phẩm Flour: ");
                                String name = sc.nextLine();
                                System.out.println("Nhập ngày sản xuất Flour (yyyy-mm-dd): ");
                                String manufacturingDayString = sc.nextLine();
                                LocalDate manufacturingDate = LocalDate.parse(manufacturingDayString);
                                System.out.println("Nhập giá sản phẩm Flour: ");
                                int cost = sc.nextInt();
                                System.out.println("Nhập số lượng bột Flour: ");
                                int quantity = sc.nextInt();
                                CrispyFlour f1 = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
                                materials.add(f1);
                            } catch (DateTimeException e) {
                                System.out.println("Định dạng ngày không hợp lệ. Hãy nhập lại!");
                                continue;
                            }
                            break;
                    }
                    break;
                case "4":
                    for (Material material1 :
                            materials) {
                        System.out.println(material1.toString());
                    }
                    break;
                case "6":
                    //Xóa theo ID nhập vào
                    System.out.println("Nhap ID material muon xoa: ");
                    String choiceDel = sc.nextLine();
                    boolean foundDel = false;
                    //foreach ko the dung lenh remove trong arrlist.. nen phai dung forindex
                    for (int i = 0; i < materials.size(); i++) {
                        if (choiceDel.equals(materials.get(i).getId())) {
                            foundDel =true;
                            materials.remove(materials.get(i));
                            break;
                        }
                    }if (!foundDel){
                    System.out.println("Khong tim thay ID de xoa");
                }
                    break;
                case "5":
                    //sửa sản phẩm theo id và mục nhập vào
                    System.out.println("Nhap ID material muon sua: ");
                    String idEdit = sc.nextLine();
                    boolean foundEdit = false;
                    for (int i = 0; i < materials.size(); i++) {
                        if (idEdit.equals(materials.get(i).getId())) {
                            foundEdit = true;
                            System.out.println("Tim thay san pham theo ID: " + materials.get(i).getId() + "---Ten: " + materials.get(i).getName() + "---Gia: " + materials.get(i).getCost());
                            System.out.println("Nhap ID moi: ");
                            String newID = sc.nextLine();
                            System.out.println("Nhap ten material moi: ");
                            String newName = sc.nextLine();
                            System.out.println("Nhap gia moi cho material: ");
                            int newCost = sc.nextInt();
                            //sua thong tin
                            materials.get(i).setId(newID);
                            materials.get(i).setName(newName);
                            materials.get(i).setCost(newCost);
                        }
                    }if (!foundEdit){
                    System.out.println("Khong tim thay ID san pham");
                }
                    break;
                case "7":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        while (!choice.equals("7")) ;
    }
    private static int getDifferncePrice(List<Material> materials) {
        int sumPrice = 0;
        int discountPrice = 0;
        int diffPrice = 0;
        for (Material material1:
                materials) {
            sumPrice += material1.getAmount();
            discountPrice += material1.getRealMoney();
            diffPrice = sumPrice - discountPrice;

        }
        System.out.println("Chênh lệnh giá tổng và giá chiết khấu là: "+ diffPrice);
        return diffPrice;
    }

    private static int getSumPrice(List<Material> materials) {
        int sumPrice = 0;
        for (Material material1:
                materials) {
            sumPrice += (int) material1.getAmount();
        }
        System.out.println("Tổng giá của tất cả sản phẩm: " + sumPrice);
        return sumPrice;
    }
}
