package banhngocninh.pttd;


import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static int Nhap() {
        boolean check = false;
        int n = 0;
        while (!check) {
            try {
                n = new Scanner(System.in).nextInt();
                check = true;
            } catch (Exception e) {
                System.out.print("Entered wrong, please re-enter the numeric data type: ");
                //n = new Scanner(System.in).nextInt();
            }
        }
        return (n);
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        //ArrayList<NhanVien> NV = new ArrayList<NhanVien>();
        List<NhanVien> NV = new CopyOnWriteArrayList<NhanVien>();
        System.out.print("Type the number of Empolyee: ");
        int n = Nhap();
        for (int i = 0; i < n; i++) {
            System.out.println("------------");
            System.out.println("Employee " + (i + 1));
            System.out.print("Please choose (1 - Administrative, 2 - Marketing Staff, 3 - Manager): ");
            int choose = Nhap();
            System.out.print("Type Employee code: ");
            String EmployeeCode = new Scanner(System.in).nextLine();
            System.out.print("Type Name: ");
            String Name = new Scanner(System.in).nextLine();
            System.out.print("Type Salary: ");
            Long Salary = (long) Nhap();
            switch (choose) {
                case 1: {
                    NhanVien Administrative = new HanhChinh(EmployeeCode, Name, Salary);
                    NV.add(Administrative);
                }
                    break;
                case 2: {

                    System.out.print("Type Sale: ");
                    Long Sale = (long) Nhap();
                    System.out.print("Type Commission: ");
                    int Commission = Nhap();
                    NhanVien MarketingStaff = new TiepThi(EmployeeCode, Name, Salary, Sale, Commission);
                    NV.add(MarketingStaff);
                }
                    break;
                case 3: {
                    System.out.print("Type Salary of Responsibility: ");
                    Long SoR = (long) Nhap();
                    NhanVien Manager = new TruongPhong(EmployeeCode, Name, Salary, SoR);
                    NV.add(Manager);
                }
                    break;
            }
        }
        do {
            System.out.println("+--------------------------CHOOSE ONE FUNCTION OF THE LIST--------------------------+");
            System.out.println("| 1. Export the list of the employees                                               |");
            System.out.println("| 2. Find and display the employee according to the code input from the keyboard    |");
            System.out.println("| 3. Remove the employee according to the code input from the keyboard              |");
            System.out.println("| 4. Update employees's information according to the code input from the keyboard   |");
            System.out.println("| 5. Find the employees by salary from the keyboard                                 |");
            System.out.println("| 6. Sort employees by name                                                         |");
            System.out.println("| 7. Sort employees by pay                                                          |");
            System.out.println("| 8. Export the 5 highest-earning employees                                         |");
            System.out.println("| 9. Exit the program                                                               |");
            System.out.println("+-----------------------------------------------------------------------------------+");
            System.out.print("PLEASE CHOOSE ONE FUNCTION: ");
            int choose2 = Nhap();
            switch (choose2) {
                case 1: {
                    System.out.println("----------EMPLOYEE LIST-------");
                    for (NhanVien i : NV) {
                        i.Output();
                        System.out.println("------------");
                    }
                }
                    break;
                case 2: {
                    System.out.print("Type the Employee Code you want to find: ");
                    String EC = new Scanner(System.in).nextLine();
                    int check = 0;
                    System.out.println("-----Information of Employee-----");
                    for (NhanVien i : NV) {
                        if (i.getEcode().equals(EC)) {
                            i.Output();
                            System.out.println("------------");
                            check++;
                        }
                    }
                    if (check == 0) {
                        System.out.println("Which employee code entered does not exist!");
                    }
                }
                    break;
                case 3: {
                    System.out.print("Type the Employee Code you want to delete: ");
                    String EC1 = new Scanner(System.in).nextLine();
                    int check = 0;
                    for (NhanVien i : NV) {
                        if ((EC1).equals(i.getEcode())) {
                            NV.remove(i);
                            check++;
                            System.out.println("The employee was deleted!!!");

                        }
                    }
                    if (check == 0) {
                        System.out.println("Which employee code entered does not exist!");
                    }
                }
                    break;
                case 4: {
                    System.out.print("Type the Employee Code you want to update: ");
                    String EC2 = new Scanner(System.in).nextLine();
                    System.out.println("-----Information of Employee-----");
                    for (NhanVien i : NV) {
                        if (i.getEcode().equals(EC2)) {
                            i.update();
                            System.out.println("------------");
                        }
                    }
                }
                    break;
                case 5: {
                    System.out.print("Type the Salary you want to find: ");
                    Long S = (long) Nhap();
                    int check = 0;
                    System.out.println("-----Information of Employee-----");
                    for (NhanVien i : NV) {
                        if (i.getSalary() == S) {
                            i.Output();
                            System.out.println("------------");
                            check++;
                        }
                    }
                    if (check == 0) {
                        System.out.println("Which Salary entered does not exist!");
                    }
                }
                    break;
                case 6: {
                    System.out.println("-----The Employee List after sorting by Name-----");
                    Collections.sort(NV, new Comparator<NhanVien>() {
                        @Override
                        public int compare(NhanVien nv1, NhanVien nv2) {
                            return (nv1.getName().compareTo(nv2.getName()));
                            // return (sv2.hoTen.compareTo(sv1.hoTen));
                        }
                    });
                    for (NhanVien i : NV) {
                        i.Output();
                        System.out.println("------------");
                    }
                }
                    break;
                case 7: {
                    System.out.println("-----The Employee List after sorting by Salary-----");
                    Comparator<NhanVien> comp = new Comparator<NhanVien>() {
                        public int compare(NhanVien nv1, NhanVien nv2) {
                            if (nv1.pay() < nv2.pay()) {
                                return 1;
                            } else if (nv1.pay() == nv2.pay()) {
                                return 0;
                            } else
                                return -1;
                        }
                    };
                    Collections.sort(NV, comp);
                    for (NhanVien i : NV) {
                        i.Output();
                        System.out.println("------------");
                    }
                }
                    break;
                case 8: {
                    Comparator<NhanVien> comp = new Comparator<NhanVien>() {
                        public int compare(NhanVien nv1, NhanVien nv2) {
                            if (nv1.pay() < nv2.pay()) {
                                return 1;
                            } else if (nv1.pay() == nv2.pay()) {
                                return 0;
                            } else
                                return -1;
                        }
                    };
                    Collections.sort(NV, comp);
                    for (int i = 0; i < 5; i++) {
                        System.out.println(NV.get(i));
                    }
                }
                    break;
                case 9:
                    System.exit(0);
                default:
                    System.out.println("Entered wrong, please enter again!!!");
            }
        } while (true);
    }
}
